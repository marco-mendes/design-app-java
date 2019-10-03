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