## Dockerizando uma aplicação Spring Boot

### Material de preparação

[Dockerizing a Spring Boot Application](https://www.baeldung.com/dockerizing-spring-boot-application)<br/>

### Introdução
Neste laboratório discutiremos como criar uma imagem docker a partir de uma aplicação Spring Boot.<br/>
O código que utilizaremos neste laboratório para criar a imagem docker está disponíveis neste [link](./exemplo/spring-data-rest-base/).<br/>
Em resumo ele contém um microsserviço que possui diferentes tipos de relacionamentos entre entidades do Spring Data REST.

### Roteiros Introdutórios do Docker

Faça os seguintes tutoriais para aclimatação de conceitos do Docker com a plataforma Katacoda.

Execução de uma primeira imagem Docker:

https://www.katacoda.com/courses/docker/deploying-first-container

Montagem uma imagem simples Docker:

https://www.katacoda.com/courses/docker/2

Montagem de build Docker com o conceito de Multi-Estágio:

https://www.katacoda.com/courses/docker/multi-stage-builds

### Passos para a criação da imagem docker de nossa aplicação
Para criar a imagem docker de nossa aplicação precisaremos primeiro seguir alguns passos e criar algumas imagens docker intermediárias que serão utilizadas para criamos a imagem 
docker de nossa aplicação.<br/>
Nossos passos para isso serão:
 * Criar uma imagem docker com o JDK 11 configurado
 * Criar uma imagem Maven que utilize o JDK 11 para podermos realizar o build de nossa aplicação
 * Criar a imagem docker a partir do binário Java de nosso projeto de exemplo.
 
Além disso podemos executar a imagem docker criada de duas formas:
 * Execução via comando docker
 * Execução via docker compose
 

### Criando nossa imagem docker com o JDK 11
Para criar essa imagem primeiro navegue até o diretório de nosso [projeto que utilizaremos como base para este laboratório](./exemplo/spring-data-rest-base/).<br/>
Em seguida crie um arquivo chamado **Dockerfile** com o seguinte conteúdo:
```java
FROM alpine:edge
RUN apk --no-cache add openjdk11 --repository=http://dl-cdn.alpinelinux.org/alpine/edge/community
```

Este arquivo indica que utilizaremos como base a imagem docker **alpine:edge**, e instalaremos nela o open JDK 11.<br/>
Para gerar o build dessa imagem execute o seguinte comando no mesmo diretório de nosso arquivo **Dockerfile**:
```java
docker build --tag=alpine-java:base --rm=true .
```
Com isso teremos a imagem docker **alpine-java:base** criada.

### Criando nossa imagem docker do Maven
Para cria essa imagem navegue até o diretório de nosso projeto que utilizaremos como base para este laboratório e em seguida crie um 
arquivo chamado **Dockerfile.maven** com o seguinte conteúdo:
```java
# Utilizando a imagem alpine-java:base como base
FROM alpine-java:base

RUN apk update && apk add bash

RUN apk add --no-cache curl tar bash procps

# Alterando o timezone de nosso container
RUN apk add tzdata

RUN cp /usr/share/zoneinfo/America/Sao_Paulo /etc/localtime

# Argumentos que utilizaremos para a instalacao do maven
ARG MAVEN_VERSION=3.6.2
ARG USER_HOME_DIR="/root"
ARG SHA=d941423d115cd021514bfd06c453658b1b3e39e6240969caf4315ab7119a77299713f14b620fb2571a264f8dff2473d8af3cb47b05acf0036fc2553199a5c1ee
ARG BASE_URL=https://apache.osuosl.org/maven/maven-3/${MAVEN_VERSION}/binaries

# Realizand o download e instalando o maven
RUN mkdir -p /usr/share/maven /usr/share/maven/ref \
  && curl -fsSL -o /tmp/apache-maven.tar.gz ${BASE_URL}/apache-maven-${MAVEN_VERSION}-bin.tar.gz \
  && echo "${SHA}  /tmp/apache-maven.tar.gz" | sha512sum -c - \
  && tar -xzf /tmp/apache-maven.tar.gz -C /usr/share/maven --strip-components=1 \
  && rm -f /tmp/apache-maven.tar.gz \
  && ln -s /usr/share/maven/bin/mvn /usr/bin/mvn

# Configurando o maven
ENV MAVEN_HOME /usr/share/maven
ENV MAVEN_CONFIG "$USER_HOME_DIR/.m2"

ENV M3_HOME = /user/share/maven/
ENV M3 = /user/share/maven/bin
```
Note que neste Dockerfile estamos utilizando como base a imagem **alpine-java:base** que criamos no tópico anterior.<br/>
Leia os comentários do dockerfile para melhor compreensão.

Podemos realizar o build de nossa imagem Maven utilizando o seguinte comando:
```java
docker build --file=Dockerfile.maven --tag=maven:base --rm=true .
```
Após executarmos este comando teremos a imagem **maven:base** criada.

### Criando nossa imagem docker de nossa aplicação
Para cria a imagem docker de nossa aplicação precisaremos primeiro gerar o binário Java e logo em seguida criar uma imagem docker utilizando este binário.<br/>
Podemos realizar estes 2 processos com um Dockerfile multistage, que consiste em um arquivo Dockerfile com vários estágios até a geração da imagem docker final.<br/>
Podemos fazer isso da seguinte forma:
```java
# Estagio 1 do Build - Compilar o projeto
FROM maven:base AS BUILD_BINARIO

# Copiando o codigo de nossa maquina local para dentro do container
COPY ./ /home/codigo
WORKDIR /home/codigo

# Gerando o binario Java
RUN mvn clean compile package

# Estagio 2 do Build - Gerar a imagem docker final
FROM alpine-java:base

# Alterando timezone do container
RUN apk add tzdata
RUN cp /usr/share/zoneinfo/America/Sao_Paulo /etc/localtime

# Definindo o diretorio /home/binarios como o diretorio de trabalho em nosso container
WORKDIR /home/binarios

# Copiando o binario gerado no container do primeiro estagio para o container do segundo estagio
COPY --from=BUILD_BINARIO /home/codigo/target/spring-data-rest-*.jar /home/binarios

# Comando para execucao de nossa aplicacao assim que um novo container for criado
CMD ["sh", "-c", "java -Dserver.port=5555 -jar ./spring-data-rest-*.jar"]
```
Leia os comentarios do Dockerfile para melhor compreensão.

Podemos realizar o build de nossa imagem docker utilizando o seguinte comando:
```java
docker build --file=Dockerfile.app --tag=spring-data-rest:latest --rm=true .
```

Com isso já possuiremos nossa imagem **spring-data-rest:latest** de nossa aplicação criada.

### Executando nossa imagem spring-data-rest:latest
Nossa imagem docker pode ser executada de duas formas:
 * Execução via comando docker
 * Execução via docker compose
 
#### Execução via comando docker
```java
docker run --name spring-data-rest -p 5555:5555 -it spring-data-rest:latest
```

#### Executando via docker-compose
Na pasta raiz de nosso projeto crie um arquivo chamado **docker-compose.yml** com o seguinte conteúdo:
```java
version: '2'
services:
  executa-aplicacao:
    container_name: SpringDataRest
    image: spring-data-rest:latest
    restart: always
    ports:
      - "5555:5555"
    expose:
      - "5555"
```
Para executar nosso container basta rodar o seguinte comando no terminal:
```java
docker-compose up
```

### Testando nossa aplicação
Podemos testar se nossa aplicação está em execução através de alguns comandos **curl**:
```java
// Criando objeto Library
curl -i -X POST -H "Content-Type:application/json" -d "{\"name\":\"My Library\"}" http://localhost:5555/libraries
curl -i -X POST -H "Content-Type:application/json" -d "{\"name\":\"My Library\"}" http://localhost:5555/libraries

// Criando objetos book
curl -i -X POST -H "Content-Type:application/json" -d "{\"title\":\"Book1\"}" http://localhost:5555/books
curl -i -X POST -H "Content-Type:application/json" -d "{\"title\":\"Book 2\"}" http://localhost:5555/books

// Criando relacionamento de 1 para muitos entre as entidades Book e Library
curl -i -X PUT -H "Content-Type:text/uri-list" -d "http://localhost:5555/libraries/1" http://localhost:5555/books/1/library
curl -i -X PUT -H "Content-Type:text/uri-list" -d "http://localhost:5555/libraries/1" http://localhost:5555/books/2/library

// Consultando o relacionamento criado
curl -i -X GET http://localhost:5555/libraries/1/books
curl -i -X GET http://localhost:5555/libraries/2/books

// Deletando o relacionamento criado
curl -i -X DELETE http://localhost:5555/books/1/library
curl -i -X DELETE http://localhost:5555/books/2/library
```

### Conclusão
Parabéns, neste laboratório você transformou uma aplicação Spring Boot simples em uma imagem Docker.<br/>
O código completo do que fizemos neste laboratório pode ser encontrado neste [link](./exemplo/spring-data-rest/).
