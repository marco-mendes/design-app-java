## Introdução a OpenAPI

### Material de preparação
[Introdução conceitual OpenAPI e Swagger](https://swagger.io/docs/specification/about/)<br/>
[Documentando uma Api com Swagger e SpringBoot](https://www.treinaweb.com.br/blog/documentando-uma-api-spring-boot-com-o-swagger/)<br/>

### Introdução
OpenApi é uma especificação para descrição de API para APIs REST. Um arquivo OpenAPI permite que você descreva toda a sua API, incluindo:
 * Endpoints disponíveis (/users) e operações em cada Endpoint ( GET /users, POST /users)
 * Parâmetros de operação Entrada e saída para cada operação
 * Métodos de autenticação
 * Informações de contato, licença, termos de uso e outras informações
 
As especificações da API podem ser escritas em YAML ou JSON. O formato é fácil de aprender e legível para humanos e máquinas.


O Swagger é um conjunto de ferramentas de código aberto criadas em torno da Especificação OpenAPI que podem ajudá-lo a projetar, criar, documentar e consumir APIs REST.<br/>
Neste laboratório iremos utilizar a implementação Springfox do Swagger e daremos uma pequena introdução sobre sua configuração e uso.<br/>
Caso queira se aprofundar nessa API recomendamos que leia a documentação da mesma que pode ser encontrada neste [link](https://springfox.github.io/springfox/docs/current/).


### Projeto base para este laboratório
Neste laboratório iremos implementar o Swagger em uma API de usuários, o código da mesma está disponível neste [link](./exemplos/exemplo-sem-swagger)


### Adicionando o Springfox ao projeto
Para adicionar o Springfox ao projeto basta adicionar as seguintes dependências ao arquivo pom.xml do [projeto que iremos utilizar de exemplo](./exemplos/exemplo-sem-swagger):
```java
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>2.9.2</version>
</dependency>

<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>2.9.2</version>
</dependency>
```

### Realizando a configuração básica do Swagger
Para configurar o Swagger precisamos criar uma classe de configuração com um Bean do tipo Docket, com apenas isso o Swagger se encarregará de criar uma documentação padrão 
para nossa API mapeando todos os Endpoints e Paths aceitos durante a configuração.<br/>
Um exemplo básico dessa configuração seria:
```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket configuracaoBasica() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.exemplo"))
                .paths(PathSelectors.any())
                .build();
    }
}
```

O Bean Docket inicializa o Bean principal do Springfox para configurar a especificação Swagger 2.<br/>
A annotation @EnableSwagger2 é responsável por ativar o Springfox em nossa aplicação.<br/>
Veja que criamos um Bean do tipo **Docket** especificando através da propriedade **DocumentationType.SWAGGER_2** que a documentação a ser criada é do tipo Swagger 2, além disso 
possuímos os métodos: 
 * **select()**: Retorna uma instância do ApiSelectBuilder para fornecer controle sobre os Endpoints expostos por meio de swagger.
 * **apis()**: Define quais classes serão incluídas, você pode limitá-las por um pacote base, classe ou método, neste exemplo limitamos apenas ao pacote **com.exemplo**.
 * **paths()**: Você pode definir quais métodos do Endpoint devem ser incluídos na documentação, neste exemplo incluímos todos.
 * **build()**: Retorna um objeto do tipo Docket inicializado com as propriedades que definimos durante sua construção.
 
Com apenas isso nossa aplicação já possuirá uma documentação padrão criada pelo Swagger, você pode acessá-la pelo seu navegar através da seguinte url: http://localhost:porta/swagger-ui.html, 
especificando a porta no qual sua aplicação SpringBoot está sendo executada. 

Ao fazer isso você verá algo semelhante a isso:
