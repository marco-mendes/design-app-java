## Construindo um Hypermedia-Driven RESTful Web Service

### Material de referência

[Building a Hypermedia-Driven RESTful Web Service](https://spring.io/guides/gs/rest-hateoas/)<br/>

### Introdução

Este guia orienta você no processo de criação de um projeto "Hello World" de um web service orientado por Hypermedia com Spring.

A Hypermedia é um aspecto importante do REST. Ele permite que você crie serviços que dissociam o cliente e o servidor em grande medida e permitem que eles evoluam independentemente. As representações retornadas para recursos REST contêm não apenas dados, mas links para recursos relacionados. Assim, o design das representações é crucial para o design do serviço geral.

### O que você irá construir

Você criará um serviço REST orientado à Hypermedia com o Spring HATEOAS, uma biblioteca de APIs que pode ser usada para criar facilmente links apontando para os Controllers do Spring MVC, criar representações de recursos e controlar como eles são renderizados em formatos de Hypermedia suportados, como HAL.

Você criará um serviço que aceitará solicitações HTTP GET em:

```java
http://localhost:8080/greeting
```

e responderá com uma representação JSON de um Greeting enriquecido com o elemento Hypermedia mais simples possível, um link apontando para o próprio recurso:

```java
{
  "content":"Hello, World!",
  "_links":{
    "self":{
      "href":"http://localhost:8080/greeting?name=World"
    }
  }
}
```

A resposta já indica que você pode personalizar um Greeting com um parâmetro name opcional na sequência de consultas:

```java
http://localhost:8080/greeting?name=User
```

O valor do parâmetro name substitui o valor padrão de "World" e é refletido na resposta:

```java
{
  "content":"Hello, User!",
  "_links":{
    "self":{
      "href":"http://localhost:8080/greeting?name=User"
    }
  }
}
```

### O que você irá precisar

- Seu IDE favorito
- JDK 11
- Maven 3.2 ou superior

### Obtendo o código base para este realizar este tutorial

Possuímos um código que pode ser utilizado como base para completar este tutorial, o mesmo pode ser encontrado neste [link](./exemplos/base/) e pode ser importado em seu IDE.

### Criando a classe de representação de nosso recurso Greeting

Comece o processo pensando em interações de serviço.

O serviço manipulará solicitações GET para /greeting, opcionalmente com um parâmetro name na string de consulta. A solicitação GET deve retornar uma resposta 200 OK com JSON no corpo que representa um Greeting.

Além disso, a representação JSON do recurso será enriquecida com uma lista de elementos Hypermedia em uma propriedade **\_links**. A forma mais rudimentar disso é um link que aponta para o próprio recurso. Portanto, a representação deve ser algo como isto:

```java
{
  "content":"Hello, World!",
  "_links":{
    "self":{
      "href":"http://localhost:8080/greeting?name=World"
    }
  }
}
```

O content é a representação textual de Greetin. O elemento **\_links** contém uma lista de links, neste caso, exatamente um com o tipo de relação **rel**(neste caso seria nossa propriedade **self**) e o atributo **href** apontando para o recurso que acabou de ser acessado.

Para modelar a representação de Greeting, você cria uma classe de representação de recurso. Como a propriedade **\_links** é uma propriedade fundamental do modelo de representação, o Spring HATEOAS é fornecido com uma classe base **ResourceSupport()** que permite adicionar instâncias do Link e garantir que elas sejam renderizadas conforme mostrado acima.

Então você simplesmente criará um objeto java simples que estende a classe **ResourceSupport**, adiciona a propriedade content e um modificador de acesso para ela, além de um construtor para a classe Greeting conforme o exemplo abaixo:

```java
// Localização para criação desta classe: src/main/java/hello/Greeting.java
package hello;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Greeting extends ResourceSupport {

    private final String content;

    @JsonCreator
    public Greeting(@JsonProperty("content") String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
```

- @JsonCreator - sinaliza como o Jackson pode criar uma instância deste POJO
- @JsonProperty - marca claramente em que campo Jackson deve colocar esse argumento dentro do construtor

Como você verá nas próximas etapas, o Spring usa a biblioteca Jackson JSON para organizar automaticamente instâncias do tipo Greeting no formato JSON.

### Criando nosso Greeting Controller

Na abordagem do Spring para criar web services RESTful, as solicitações HTTP são tratadas por um Controller. Esses componentes são facilmente identificados pela annotation @RestController, e o GreetingController abaixo lida com solicitações GET para o path /greeting retornando uma nova instância da classe Greeting:

```java
// Localização para criação desta classe: src/main/java/hello/GreetingController.java
package hello;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class GreetingController {

    private static final String TEMPLATE = "Hello, %s!";

    @RequestMapping("/greeting")
    public HttpEntity<Greeting> greeting(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name) {

        Greeting greeting = new Greeting(String.format(TEMPLATE, name));
        greeting.add(linkTo(methodOn(GreetingController.class).greeting(name)).withSelfRel());

        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }
}
```

Esse Controller é conciso e simples, mas há muita coisa acontecendo. Vamos dividir passo a passo.<br/>
A annotation @RequestMapping assegura que as solicitações HTTP para /greeting sejam mapeadas para o método greeting().

O exemplo acima não especifica explicitamente o tipo de requisição HTTP(GET, POST, PUT ...) porque @RequestMapping mapeia todas as operações HTTP por padrão.<br/>
Use @RequestMapping (path="/greeting", method=RequestMethod.GET) para restringir esse mapeamento. Nesse caso, você também deve importar **org.springframework.web.bind.annotation.RequestMethod**.
<br/>Você também pode mapear outros método HTTP através de RequestMethod.NOME_REQUESTMETHOD, onde NOME_REQUESTMETHOD deve ser substituído pelo método a ser usado.

@RequestParam vincula o valor do nome do parâmetro da string de consulta ao parâmetro name do método greeting(). Se o parâmetro name estiver ausente na solicitação, o valor padrão de "World" será usado.

Como a annotation @RestController está presente na classe, uma annotation implícita @ResponseBody está sendo adicionada ao método de greeting(). Isso faz com que o Spring MVC processe o HttpEntity retornando seu payload e o greeting diretamente na resposta da requisição HTTP.

A parte mais interessante da implementação do método é como você cria o link apontando para o método do Controller e como o adiciona ao modelo de representação. Os links linkTo (…) e methodOn (…) são métodos estáticos no ControllerLinkBuilder que permitem falsificar uma chamada de método no Controller. O LinkBuilder retornado terá inspecionado a annotation de mapeamento do método do controller para criar exatamente o URI para o qual o método está mapeado.

O Spring HATEOAS respeita vários cabeçalhos(headers) **X-FORWARDED-**. Se você colocar um serviço Spring HATEOAS atrás de um proxy e configurá-lo adequadamente com os cabeçalhos(headers) **X-FORWARDED-HOST**, os links resultantes serão formatados corretamente.

A chamada para withSelfRel() cria uma instância de Link que você adiciona ao objeto Greeting.

### Tornando a aplicação executável

Embora seja possível empacotar esse serviço como um arquivo WAR tradicional para implementação em um servidor de aplicativos externo, a abordagem mais simples demonstrada abaixo cria um aplicativo independente. Você empacota tudo em um único arquivo JAR executável, orientado por um bom e velho método Java main(). No caminho, você usa o suporte do Spring para incorporar o contêiner de servlet Tomcat como tempo de execução HTTP, em vez de implantar em uma instância externa.

```java
// Localização para criação desta classe: src/main/java/hello/Application.java
package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
```

**@SpringBootApplication** é uma annotation de conveniência que adiciona todo o seguinte:

- **@Configuration**: marca a classe como uma fonte de definições de bean para o contexto do aplicativo.
- **@EnableAutoConfiguration**: Diz ao Spring Boot para começar a adicionar beans com base nas configurações do classpath, outros beans e várias configurações de propriedades. Por exemplo, se spring-webmvc estiver no classpath, essa annotation sinalizará o aplicativo como um aplicativo da web e ativará os principais comportamentos, como configurar um **DispatcherServlet**.
- **@ComponentScan**: Diz ao Spring que procure outros componentes, configurações e serviços no pacote **hello**, permitindo que ele encontre os controllers.

O método **main()** usa o método **SpringApplication.run()** do Spring Boot para iniciar um aplicativo. Você notou que não havia uma única linha de XML? Também não há arquivo web.xml. Esse aplicativo da Web é 100% Java puro e você não precisou configurar nenhum encanamento ou infraestrutura.

### Executando a aplicação

Para executar a aplicação basta que você execute a classe Application em seu IDE, caso queira gerar um binário JAR e executar a aplicação através dele você pode executar o seguinte comando na pasta raiz do projeto:

```java
mvn package
```

Após isso basta executar o seguinte comando:

```java
java -jar target/gs-rest-hateoas-0.1.0.jar
```

### Testando o serviço

Agora que o serviço está ativo, visite http://localhost:8080/greeting, onde você verá:

```javab
{
  "content":"Hello, World!",
  "_links":{
    "self":{
      "href":"http://localhost:8080/greeting?name=World"
    }
  }
}
```

Forneça um parâmetro name na url como por exemplo http://localhost:8080/greeting?name=User. Observe como o valor do atributo content muda de "Hello, World!" para "Hello, User!" e o atributo **href** de **self** reflete essa alteração também:

```java
{
  "content":"Hello, User!",
  "_links":{
    "self":{
      "href":"http://localhost:8080/greeting?name=User"
    }
  }
}
```

Essa alteração demonstra que o arranjo @RequestParam no GreetingController está funcionando conforme o esperado. O parâmetro name recebeu um valor padrão de "World", mas sempre pode ser substituído explicitamente pela string de consulta.

### Resumo

Parabéns! Você acabou de desenvolver um serviço da Web RESTful baseado em Hypermedia com o Spring HATEOAS.<br/>
Caso queira verificar o código completo você pode encontrá-lo neste [link](./exemplos/completo/).
