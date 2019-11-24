## Testes Mock com Mockito, JUnit e SpringBoot

### Introdução

Uma das características fundamentais de testes de unidade é isolar determinado componente e testar seus métodos da melhor forma possível. Em alguns casos isso não é possível pois muitas vezes dependemos de um serviço externo ou dependemos de uma camada de persistência para executar os testes de alguns componentes.

Imagine que você precisa testar um código que faz acesso à uma camada de persistência por meio de um DAO/Repository. 

Para esse código funcionar em produção, é necessário que algum mecanismo de persistência esteja disponível. Para o código de testes de unidade isso é impraticável: ele vai ficar lento, mais complexo, vai perder o isolamento.
Uma solução para este caso seria simular o acesso à camada de persistência, isso seria possível utilizandos Mocks.

De maneira geral, para facilitar o entendimento, mocks são objetos criados para simular, de forma controlada, determinados comportamentos de objetos reais.



### Mockito

O Mockito é um framework popular para criação de Mocks, utilizaremos ele para os exemplos deste laboratório.

Para instalar o Mockito em um projeto maven é bem simples, basta inserir as seguintes dependências ao arquivo pom.xml:

```xml
<!-- https://mvnrepository.com/artifact/org.mockito/mockito-core -->
<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-core</artifactId>
    <version>3.1.0</version>
    <scope>test</scope>
</dependency>

<!-- https://mvnrepository.com/artifact/org.mockito/mockito-junit-jupiter -->
<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-junit-jupiter</artifactId>
    <version>3.1.0</version>
    <scope>test</scope>
</dependency>
```



As versões mais novas do SpringBoot já contém essas dependências autocontidas na dependência **spring-boot-starter-test**, com isso basta adicionar a seguinte dependência ao seu arquivo pom.xml para utilizar o Mockito com o SpringBoot:

```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-test</artifactId>
	<scope>test</scope>
	<exclusions>
		<exclusion>
			<groupId>org.junit.vintage</groupId>
			<artifactId>junit-vintage-engine</artifactId>
		</exclusion>
	</exclusions>
</dependency>
```



### Aplicação de exemplo

Neste laboratório utilizaremos o projeto de uma API de Livros que pode ser baixado neste [link](./codigo/BookApi.zip)

Após baixar o projeto de exemplo basta que o importem para o eclipse para podermos utilizar. 

