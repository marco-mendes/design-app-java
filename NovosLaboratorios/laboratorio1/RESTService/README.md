## Construindo um Web Service RESTful

### Material de referência

[Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)

### Introdução

Este guia orienta você no processo de criação de um projeto "Hello World" web service RESTful com o Spring.

### O que você irá construir

Você criará um serviço que aceitará solicitações HTTP GET em:

```java
http://localhost:8080/greeting
```

e responda com uma representação JSON de uma greeting:

```java
{"id":1,"content":"Hello, World!"}
```

Você pode personalizar o greeting com um parâmetro de nome opcional na sequência de consultas:

```java
http://localhost:8080/greeting?name=User
```

O valor do parâmetro name substitui o valor padrão de "World" e é refletido na resposta:

```java
{"id":1,"content":"Hello, User!"}
```

### O que você irá precisar

- Seu IDE favorito
- JDK 11
- Maven 3.2 ou superior

### Obtendo o código base para este realizar este tutorial

Possuímos um código que pode ser utilizado como base para completar este tutorial, o mesmo pode ser encontrado neste [link](./exemplos/base/) e pode ser importado em seu IDE.

### Criando a classe de representação de nosso recurso Greeting

Comece o processo pensando em interações de serviço.

O serviço manipulará solicitações GET para /greeting, opcionalmente com um parâmetro de nome na string de consulta. A solicitação GET deve retornar uma resposta 200 OK com JSON no corpo que representa um Greeting. Deve ser algo como isto:

```java
{
    "id": 1,
    "content": "Hello, World!"
}

```

O campo id é um identificador exclusivo para a Greeting e o conteúdo é a representação textual de Greeting.

Para modelar a representação de Greeting, você cria uma classe de representação de recurso. Forneça um objeto java simples com campos, construtores e acessadores para os dados de identificação e conteúdo:

```java
// Localização para criação desta classe: src/main/java/hello/Greeting.java
package hello;

public class Greeting {

    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
```

Como você verá nas próximas etapas, o Spring usa a biblioteca Jackson JSON para organizar automaticamente instâncias do tipo Greeting no formato JSON.

### Criando nosso Greeting Controller

Na abordagem do Spring para criar web services RESTful, as solicitações HTTP são tratadas por um Controller. Esses componentes são facilmente identificados pela annotation @RestController, e o GreetingController abaixo lida com solicitações GET para o path /greeting retornando uma nova instância da classe Greeting:

```java
// Localização para criação desta classe: src/main/java/hello/GreetingController.java
package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
}
```

Este Controller é conciso e simples, mas há muita coisa acontecendo sob o capô. Vamos dividir passo a passo.

A annotation @RequestMapping assegura que as solicitações HTTP para /greeting sejam mapeadas para o método greeting().

O exemplo acima não especifica explicitamente o tipo de requisição HTTP(GET, POST, PUT ...) porque @RequestMapping mapeia todas as operações HTTP por padrão.<br/>
Use @RequestMapping (path="/greeting", method=RequestMethod.GET) para restringir esse mapeamento. Nesse caso, você também deve importar **org.springframework.web.bind.annotation.RequestMethod**.
<br/>Você também pode mapear outros método HTTP através de RequestMethod.NOME_REQUESTMETHOD, onde NOME_REQUESTMETHOD deve ser substituído pelo método a ser usado.

@RequestParam vincula o valor do nome do parâmetro da string de consulta ao parâmetro name do método greeting(). Se o parâmetro name estiver ausente na solicitação, o valor padrão de "World" será usado.

A implementação do corpo do método cria e retorna um novo objeto Greeting com atributos de ID e Content com base no próximo valor do contador e formata o nome fornecido usando o modelo de Greeting.

Uma diferença importante entre um Controller MVC tradicional e o Controller de web service RESTful acima é a maneira como o corpo da resposta HTTP é criado. Em vez de depender de uma tecnologia de exibição para executar a renderização do servidor dos dados de Greeting em HTML, esse controller de web service RESTful simplesmente preenche e retorna um objeto de Greeting. Os dados do objeto serão gravados diretamente na resposta HTTP como JSON.

Esse código usa a nova annotation @RestController do Spring 4, que marca a classe como um Controller em que todo método retorna um objeto de domínio em vez de uma exibição. É uma abreviação de @Controller e @ResponseBody reunidos.

O objeto Greeting deve ser convertido em JSON. Graças ao suporte ao conversor de mensagens HTTP do Spring, você não precisa fazer essa conversão manualmente. Como o Jackson 2 está no classpath, o MappingJackson2HttpMessageConverter do Spring é escolhido automaticamente para converter a instância Greeting em JSON.

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

@SpringBootApplication é uma annotation de conveniência que adiciona todo o seguinte:

- @Configuration: marca a classe como uma fonte de definições de bean para o contexto do aplicativo.
- @EnableAutoConfiguration: Diz ao Spring Boot para começar a adicionar beans com base nas configurações do classpath, outros beans e várias configurações de propriedades. Por exemplo, se spring-webmvc estiver no classpath, essa annotation sinalizará o aplicativo como um aplicativo da web e ativará os principais comportamentos, como configurar um DispatcherServlet.
- @ComponentScan: Diz ao Spring que procure outros componentes, configurações e serviços no pacote hello, permitindo que ele encontre os controllers.

O método main() usa o método SpringApplication.run() do Spring Boot para iniciar um aplicativo. Você notou que não havia uma única linha de XML? Também não há arquivo web.xml. Esse aplicativo da Web é 100% Java puro e você não precisou configurar nenhum encanamento ou infraestrutura.

### Executando a aplicação

Para executar a aplicação basta que você execute a classe Application em seu IDE, caso queira gerar um binário JAR e executar a aplicação através dele você pode executar o seguinte comando na pasta raiz do projeto:

```java
mvn package
```

Após isso basta executar o seguinte comando:

```java
java -jar target/gs-rest-service-0.1.0.jar
```

### Testando o serviço

Agora que o serviço está ativo, visite http://localhost:8080/greeting, onde você verá:

```java
{"id":1,"content":"Hello, World!"}
```

Forneça um parâmetro name na url como por exemplo http://localhost:8080/greeting?name=User. Observe como o valor do atributo content muda de "Hello, World!" para "Hello, User!":

```java
{"id":2,"content":"Hello, User!"}
```

Essa alteração demonstra que o arranjo @RequestParam no GreetingController está funcionando conforme o esperado. O parâmetro name recebeu um valor padrão de "World", mas sempre pode ser substituído explicitamente pela string de consulta.

Observe também como o atributo id mudou de 1 para 2. Isso prova que você está trabalhando na mesma instância GreetingController com várias solicitações e que seu campo id está sendo incrementado em cada chamada conforme o esperado.

### Resumo

Parabéns! Você acabou de desenvolver um web service RESTful com o Spring.<br/>
Caso queira verificar o código completo você pode encontrá-lo neste [link](./exemplos/completo/).
