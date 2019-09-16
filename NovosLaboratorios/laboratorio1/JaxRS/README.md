## Introdução ao Jax-RS com SpringBoot e Jersey

### Material de preparação

[Breve introdução ao Jax-RS](https://www.baeldung.com/jax-rs-spec-and-implementations)<br/>
[SpringBoot + Jersey em 1 minuto](https://tassioauad.com/2018/04/05/spring-boot-jersey-em-1-minuto/)<br/>
[Alguns dos principais recursos do Jersey](https://jersey.github.io/documentation/latest/jaxrs-resources.html)<br/>

### Introdução

O Jax-RS é uma especificação do Java EE que fornece suporte a criação de serviços da web de acordo com o padrão arquitetônico REST.<br/>
Existem algumas implementações dessa especificação, dentre elas as mais conhecidas são o **RESTEasy** e o **Jersey**.<br/>
Neste laboratório abordaremos o uso básico da implementação Jax-RS **Jersey** em uma aplicação baseada em SpringBoot, caso queira verificar a documentação completa do **Jersey** ela
está disponível neste [link](https://jersey.github.io/documentation/latest/index.html).

Criaremos neste laboratório uma API de Livros utilizando o Jersey e suas annotations em conjunto com o SpringBoot e estruturado em um projeto maven.<br/>
Utilizaremos as seguintes classes como base para o exemplo que será abordado neste laboratório:

Classe responsável pela criação de um objeto **Book**(Livro).

```java
public class Book {

    private int id;
    private String nome;
    private String autor;

    public Book(int id, String nome, String autor) {
        this.id = id;
        this.nome = nome;
        this.autor = autor;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", autor='" + autor + '\'' +
                '}';
    }

}
```

A classe **BookService** simulará um crud de nosso objeto **Book** utilizando uma base de dados simulada em memória.

```java
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class BookService {


    private List<Book> bookDatabase;

    public BookService() {
        this.initBookDatabase();
    }

    public List<Book> getAllBooks() {
        return this.bookDatabase;
    }

    // Get
    public Book getBookById(int id) {
        return this.bookDatabase.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .get();
    }

    // Post
    public void addBook(Book book) {
        this.bookDatabase.add(book);
    }

    // Put
    public void updateBook(int id, Book book) {
        Book bookToUpdate = this.getBookById(id);
        int indexOfBook = this.bookDatabase.indexOf(bookToUpdate);
        this.bookDatabase.set(indexOfBook, book);
    }

    // Delete
    public void removeBook(int id) {
        Book book = this.getBookById(id);
        this.bookDatabase.remove(book);
    }

    private void initBookDatabase() {
        this.bookDatabase = new ArrayList<>();
        this.bookDatabase.add(new Book(1, "Padrões de Projeto", "Erich Gamma"));
        this.bookDatabase.add(new Book(2, "Java 8 Lambdas", "Richard Warburton"));
        this.bookDatabase.add(new Book(3, "Métricas Ágeis", "Raphael Albino"));
        this.bookDatabase.add(new Book(4, "Java EE", "Alberto Souza"));
        this.bookDatabase.add(new Book(5, "Vire o jogo com Spring Framework", "Henrique Lobo Weissmann"));
    }

}
```

A annotation **@Component** é uma annotation do SpringBoot que irá indicar que a classe **BookService** será tratada como um Bean do Spring.

### Configurando o Jersey em uma aplicação SpringBoot

Para configurar o Jersey em uma aplicação SpringBoot basta adicionar a dependencia **spring-boot-starter-jersey** em nosso arquivo **pom.xml**, esta dependência traz consigo
um conjunto de dependências necessárias para utilizar o Jersey em nossa aplicação SpringBoot.<br/>
Nosso arquivo **pom.xml** após ter essa dependência configurada ficará semelhante a isso:

```java
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.exemplo</groupId>
    <artifactId>jax-rs-jersey</artifactId>
    <version>1.0-SNAPSHOT</version>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.1.6.RELEASE</version>
    </parent>

    <properties>
        <java.version>11</java.version>
    </properties>

    <dependencies>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-jersey</artifactId>
        </dependency>

    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>


</project>
```

### Criando nossa classe Resource

Afinal, o que é uma classe Resource?<br/>
Conforme foi abordado no material de preparação, classes Resource são POJOs que utilizam a annotation **@Path** ou possuem pelo menos um método com a annotation **@Path**
ou um designador de método de requisição, como **@GET**, **@PUT**, **@POST** ou **@DELETE**.<br/>

Criaremos uma classe Resource para nosso objeto **Book** e utilizamos as annotations Jax-RS conforme o exemplo abaixo.

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import java.net.URI;
import java.util.List;



@Component
@Path("books")
public class BookResource {

    @Autowired
    private BookService bookService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllBooks() {
        List<Book> allBooks = bookService.getAllBooks();
        return Response.ok(allBooks).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getBook(@PathParam("id") int id) {
        Book book = bookService.getBookById(id);
        return Response.ok(book).build();
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBook(Book book) {
        bookService.addBook(book);
        return Response.created(URI.create("/" + book.getId())).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response updateBook (@PathParam("id") int id, Book book) {
        bookService.updateBook(id, book);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteBook(@PathParam("id") int id) {
        bookService.removeBook(id);
        return Response.noContent().build();
    }

}
```

A classe **BookResource** serve como um Endpoint e será responsável por lidar com as requisições HTTP que nossa aplicação irá receber.<br/>
Funcionamento das annotations do Jax-RS:

- **@Path** é usado para identificar o caminho do URI (relativo) para o qual uma classe de Resource ou método de classe atenderá solicitações.
- **@PathParam** é usado para obter o valor de um parâmetro de uma URI para que possamos atribuir esse valor a um parâmetro de método. Um exemplo seria a URI /livros/{id}, nesta
  URI conseguiriamos obter o valor do parâmetro id informado durante a requisição desta URI.
- **@GET** indica que o método anotado lida com solicitações HTTP GET.
- **@POST** indica que o método anotado manipula solicitações HTTP POST.
- **@PUT** indica que o método anotado manipula solicitações HTTP PUT.
- **@DELETE** indica que o método anotado manipula solicitações HTTP DELETE.
- **@Produces** define um **MediaType** que o método anotado pode produzir como resposta a uma solicitação HTTP. Em nosso exemplo estamos utilizando o tipo **MediaType.APPLICATION_JSON**.
- **@Consumes** define um **MediaType** que o método anotado pode aceitar ao receber uma solicitação HTTP. Em nosso exemplo estamos utilizando o tipo **MediaType.APPLICATION_JSON**.

O objeto do tipo **Response** é utilizado para criar e retornar uma resposta HTTP com um código de resposta, podendo ou não retornar uma entidade do tipo **Book**.<br/>
Observe também que utilizamos nossa classe **BookService** em nossa classe **BookResource** para realizar as operações crud em nossa base de dados fictícia.

### Registrando nossa classe Resource em um ResourceConfig do Jersey

Para que nossa classe Resource entre em funcionamento precisamos primeiro registrá-la no Jersey, para isso será necessário criar uma classe que extenda a classe
**ResourceConfig** do Jersey e registre nossa classe **BookResource**.<br/>
Isso pode ser implementado da seguinte forma:

```java
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("v1")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(BookResource.class);
    }
}
```

A annotation **@Configuration** é comum no Spring Boot e transforma a classe **JerseyConfig** em um Bean lido automaticamente pelo Spring Boot.<br/>
A annotation **@ApplicationPath** receberá um endereço base para todos os Resources. Sendo assim, todo Resource que formos acessar será através da URL base
http://localhost:port/v1/resource_name/path_param.<br/>

- **port**: Corresponde a porta em que nossa aplicação está sendo executada
- **resource_name**: Corresponde ao nome que atribuímos a annotation **@Path** que se encontra em cima da declaração de nossa classe **BookResource**.
- **path_param**: Corresponde ao nome que atribuímos a annotation **@Path** que se encontra em cima da declaração de nossos métodos no Resource **BookResource**.

Exemplos:

- Se realizarmos uma requisição POST através da url http://localhost:8080/v1/books/ iremos acessar o método **addBook()** de nosso Resource.
- Se realizarmos uma requisição GET através da url http://localhost:8080/v1/books/1 iremos acessar o método **getBook()** de nosso Resource.

### Criando a classe main e executando a aplicação

A criação da classe que possui o método main segue o padrão básico de uma classe main do Spring Boot conforme o exemplo abaixo:

```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
```

Para executar a aplicação você pode executar a classe **Application** em seu IDE e realizar as requisições HTTP via curl ou através de seu navegador.<br/>
Além disso você pode utilizar o [Postman](https://www.getpostman.com/) para testar sua API, leia este [artigo](https://www.codetreat.com/testing-rest-api-using-postman/)
para compreender como fazer isso.

#### Exercício

Com base no código contido neste [link](./exercicio/ExercicioJaxRSJersey/) configure a aplicação para utilizar o Jersey e após isso crie um Resource para o objeto **Usuario**
que realize as operações Crud utilizando como base para as operações crud os métodos contidos na classe **UsuarioService**.<br/>
Configure o **@Path** de sua classe Resource com a URI **/user** ou utilize alguma URI de sua preferência para essa configuração.
