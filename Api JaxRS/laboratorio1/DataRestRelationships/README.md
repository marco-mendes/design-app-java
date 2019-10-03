## Trabalhando com relacionamentos no Spring Data REST

### Material de preparação
[Working with Relationships in Spring Data REST](https://www.baeldung.com/spring-data-rest-relationships)

### Introdução
Neste laboratório abordaremos como criar e utilizar relacionamentos entre entidades no Spring Data Rest, serão abordados os seguintes 
tipos de relacionamentos:
 * 1 para 1
 * 1 para muitos
 * Muitos para muitos

### O que você irá precisar
 * Seu IDE favorito
 * JDK 11
 * Maven 3.2 ou superior

### Estruturando nosso projeto
Iremos primeiro estruturar nosso projeto, crie uma pasta chamada **spring-data-rest**, esta pasta será a pasta raiz de nosso projeto.<br/>
Dentro desta pasta crie a seguinte estrutura de diretórios:<br/>

```java
└───src
    ├───main
    │   ├───java
    │   │   └───com
    │   │       └───springdatarest
    │   │           ├───model
    │   │           └───repository
    │   └───resources
    └───test
        └───java
            └───com
                └───springdatarest
```

### Criando nosso pom.xml
Crie o arquivo pom.xml da seguinte forma:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.1.8.RELEASE</version>
		<relativePath/>
	</parent>
	<groupId>com.example</groupId>
	<artifactId>spring-data-rest</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>spring-data-rest</name>
	<description>Demo project for Spring Boot</description>

	<properties>
		<java.version>11</java.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-rest</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>

		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>

		<!-- Início Dependências para compatibilidade com o Java 11 -->
		<dependency>
			<groupId>javax.xml.bind</groupId>
			<artifactId>jaxb-api</artifactId>
			<version>2.2.11</version>
		</dependency>
		<dependency>
			<groupId>com.sun.xml.bind</groupId>
			<artifactId>jaxb-core</artifactId>
			<version>2.2.11</version>
		</dependency>
		<dependency>
			<groupId>com.sun.xml.bind</groupId>
			<artifactId>jaxb-impl</artifactId>
			<version>2.2.11</version>
		</dependency>
		<dependency>
			<groupId>javax.activation</groupId>
			<artifactId>activation</artifactId>
			<version>1.1.1</version>
		</dependency>
		<dependency>
			<groupId>org.javassist</groupId>
			<artifactId>javassist</artifactId>
			<version>3.23.1-GA</version>
		</dependency>
		<!-- Fim Dependências para compatibilidade com o Java 11 -->
		
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
Nosso pom possui as dependências básicas para utilizar o Spring Data Rest, possuímos também algumas outras dependências utilizadas para manter a compatibilidade de nossa 
aplicação com o Java 11.<br/>
Além delas possuímos também nossa dependência **h2** que será utilizada para armazenar nossos dados em memória durante a execução da aplicação.

### Models de nossas entidades
Neste laboratório possuímos o cenário de uma biblioteca no qual possuímos as seguintes entidades:
 * Library
 * Address
 * Book
 * Author

Essas entidades devem ser criadas no pacote **com.springdatarest.model**, possuímos também a estrutura inicial de cada uma delas logo abaixo:

```java
// Classe Library
public class Library {
 
    private long id;
 
    private String name;
 
    private Address address;
     
    private List<Book> books;
    
    // Getters, Setters and Constructors
    
}
```

```java
// Classe Address
public class Address {

    private long id;
 
    private String location;
 
    private Library library;

    // Getters, Setters and Constructors
}
```

```java
// Classe Book
public class Book {
	 
    private long id;
     
    private String title;
     
    private Library library;
    
    private List<Author> authors;
    
    // Getters, Setters and Constructors
    
}
```

```java
// Classe Author
public class Author {
 
    private long id;
 
    private String name;
 
    private List<Book> books;
    
    // Getters, Setters and Constructors
    
}

```

### Relacionamentos entre nossas entidades
Os relacionamentos entre essas entidades podem ser definidos da seguinte maneira:
 * Classes Address e Library: Possuem um relacionamento de 1 para 1.
 * Classe Library e Book: Possuem um relacionamento de 1 para muitos, sendo Library(1) e Book(Muitos).
 * Classe Author e Book: Possuem um relacionamento de muitos para muitos.

### Estruturando nossos models com JPA
Iremos agora estruturar os models que criamos como Entidades do JPA e iremos também definir os relacionamentos entre essas entidades utilizando as annotations do JPA.<br/>

#### Estruturando o Model Library
Altere o model Library para que o mesmo contenha a seguinte estrutura:
```java
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.data.rest.core.annotation.RestResource;

@Entity
public class Library {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
 
    @Column
    private String name;
 
    @OneToOne
    @JoinColumn(name = "address_id")
    @RestResource(path = "libraryAddress", rel="address")
    private Address address;
     
    @OneToMany(mappedBy = "library")
    private List<Book> books;
    
    public Library() {
    }

    public Library(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
}
```

#### Estruturando o model Address
Altere o model Address para que o mesmo contenha a seguinte estrutura:
```java
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Address {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
 
    @Column(nullable = false)
    private String location;
 
    @OneToOne(mappedBy = "address")
    private Library library;

    // Getters, Setters and Constructors
    
    public Address() {
    }

    public Address(String location) {
        super();
        this.location = location;
    }
    
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}
 
    
}
```

#### Estruturando o model Book
Altere o model Book para que o mesmo contenha a seguinte estrutura:
```java
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
     
    @Column(nullable=false)
    private String title;
     
    @ManyToOne
    @JoinColumn(name="library_id")
    private Library library;
    
    @ManyToMany(mappedBy = "books")
    private List<Author> authors;
    
    public Book() {
    }

    public Book(String title) {
        super();
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
    
}
```

#### Estruturando o model Author
Altere o model Author para que o mesmo contenha a seguinte estrutura:
```java
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Author {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
 
    @Column(nullable = false)
    private String name;
 
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book_author", 
      joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"), 
      inverseJoinColumns = @JoinColumn(name = "author_id", 
      referencedColumnName = "id"))
    private List<Book> books;
    
    public Author() {
    }

    public Author(String name) {
        super();
        this.name = name;
    }


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
 

}
```

### Criando nossos repositórios
Agora iremos criar repositórios com as operações Crud de cada um de nossos models.<br/>
Isso pode ser feito criando uma interface que extende a interface **CrudRepository**, ao fazermos isso o SpringBoot fica responsável por gerar o código Crud da entidade alvo 
automáticamente para que possamos utilizar sem ter que codificar as operações manualmente.<br/>
Todos os nossos repositórios deverão ser criados no pacote **com.springdatarest.repository**.

#### Repositório do model Address
```java
import com.springdatarest.model.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {

}
```

#### Repositório do model Author
```java
import com.springdatarest.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
	
}
```

#### Repositório do model Book
```java
import com.springdatarest.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
	
}
```

#### Repositório do model Library
```java
import com.springdatarest.model.Library;
import org.springframework.data.repository.CrudRepository;

public interface LibraryRepository extends CrudRepository<Library, Long> {
	
}
```

### Criando a classe de inicialização de nossa aplicação
Nossa classe de inicialização segue o mesmo padrão de classes com método **main()** no SpringBoot, utilize o pacote **com.springdatarest** para criar essa classe e utilize 
 o código abaixo como base:
```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataRestApplication.class, args);
	}

}
```

### Executando e testando nossa aplicação
Neste tópico iremos realizar alguns testes manuais para ver como podemos utilizar nossa aplicação, realizaremos requisições HTTP utilizando Curl para testar o que desenvolvemos e 
nos próximos tópicos montaremos um teste automátizado de nossa aplicação.

Com a aplicação em execução iremos criar os objetos de nossas entidades e realizar o relacionamento entre cada um deles, iremos utilizar a ferramenta Curl mas também é 
possível realizar esses testes em qualquer outra ferramenta que possibilite a criação de requisições HTTP.<br/>

Caso queria consultar novamente o relacionamento entre nossas entidades volte ao tópico [Relacionamentos entre nossas entidades](#relacionamentos-entre-nossas-entidades) deste artigo.

#### Criando um relacionamento de 1 para 1
Conforme vimos neste laboratório as entidades Address e Library possuem um relacionamento de 1 para 1, para criarmos este relacionamento precisaremos primeiro criar instâncias 
de nossas entidades.<br/>
Abaixo temos um exemplo de criação da entidade Library:
```java
curl -i -X POST -H "Content-Type:application/json" -d "{\"name\":\"My Library\"}" http://localhost:8080/libraries
```
Ao executarmos este comando teremos um retorno semelhante a este no qual podemos verificar todos os endpoints que nos dão acesso as funcionalidades de nosso objeto Library.<br/>
O mesmo ocorrerá em todos os objetos que criamos em nossa aplicação.
```java
HTTP/1.1 201
Location: http://localhost:8080/libraries/1
Content-Type: application/hal+json;charset=UTF-8
Transfer-Encoding: chunked
Date: Fri, 20 Sep 2019 20:04:18 GMT

{
  "name" : "My Library",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/libraries/1"
    },
    "library" : {
      "href" : "http://localhost:8080/libraries/1"
    },
    "address" : {
      "href" : "http://localhost:8080/libraries/1/libraryAddress"
    },
    "books" : {
      "href" : "http://localhost:8080/libraries/1/books"
    }
  }
}
```

Para criar uma instância de Address você pode executar o seguinte comando:
```java
curl -i -X POST -H "Content-Type:application/json" -d "{\"location\":\"Main Street nr 5\"}" http://localhost:8080/addresses
```
Ao executarmos este comando teremos um retorno semelhante a este:
```java
HTTP/1.1 201
Location: http://localhost:8080/addresses/1
Content-Type: application/hal+json;charset=UTF-8
Transfer-Encoding: chunked
Date: Fri, 20 Sep 2019 20:08:01 GMT

{
  "location" : "Main Street nr 5",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/addresses/1"
    },
    "address" : {
      "href" : "http://localhost:8080/addresses/1"
    },
    "library" : {
      "href" : "http://localhost:8080/addresses/1/library"
    }
  }
}
```

Para criar um relacionamento entre Library e Address precisaremos obter a url de acesso ao recurso Address de nossos 2 objetos criados, conforme vimos ao criarmos estes 2 objetos 
o endereço de acesso a esta funcionalidade é semelhante a este:<br/>
```java
Objeto Library: http://localhost:8080/libraries/1/libraryAddress
Objeto Address: http://localhost:8080/addresses/1
```

Com base nisso podemos montar nosso comando para criar o relacionamento entre eles, o comando seria semelhante ao exemplo abaixo no qual estamos utilizando o endpoint de Address
de nosso objeto Library para adicionar a referência ao nosso objeto Address:
```java
curl -i -X PUT -d "http://localhost:8080/addresses/1" -H "Content-Type:text/uri-list" http://localhost:8080/libraries/1/libraryAddress
```
Ao executar este comando você verá um retorno semelhante a este:
```java
HTTP/1.1 204
Date: Fri, 20 Sep 2019 20:12:52 GMT
```

Com apenas isso nosso relacionamento de 1 para 1 já está criado.<br/>
Para consultar o relacionamento que criamos podemos executar o seguinte comando:
```java
curl -i -X GET http://localhost:8080/libraries/1/libraryAddress
```

Caso queira excluir este relacionamento basta executar um DELETE da seguinte forma:
```java
curl -i -X DELETE http://localhost:8080/libraries/1/libraryAddress
```

#### Criando um relacionamento de 1 para muitos
Conforme vimos neste laboratório as entidades Library e Book possuem um relacionamento de 1 para muitos, para criarmos este relacionamento precisaremos primeiro criar instâncias 
de nossas entidades.<br/>
Como já possuímos um objeto Library criado iremos criar agora duas instâncias do objeto Book, isso pode ser feito da seguinte forma:
```java
curl -i -X POST -H "Content-Type:application/json" -d "{\"title\":\"Book1\"}" http://localhost:8080/books
curl -i -X POST -H "Content-Type:application/json" -d "{\"title\":\"Book 2\"}" http://localhost:8080/books
```

Agora iremos criar um relacionamento entre nossos objetos Book e Library, podemos fazer isso da seguinte forma:
```java
curl -i -X PUT -H "Content-Type:text/uri-list" -d "http://localhost:8080/libraries/1" http://localhost:8080/books/1/library
curl -i -X PUT -H "Content-Type:text/uri-list" -d "http://localhost:8080/libraries/1" http://localhost:8080/books/2/library
```

Para consultar o relacionamento que criamos podemos executar o seguinte comando: 
```java	
curl -i -X GET http://localhost:8080/libraries/1/books
```

Caso queira excluir este relacionamento basta executar um DELETE da seguinte forma:
```java
curl -i -X DELETE http://localhost:8080/books/1/library
curl -i -X DELETE http://localhost:8080/books/2/library
```

#### Criando um relacionamento de muitos para muitos
Conforme vimos neste laboratório as entidades Book e Author possuem um relacionamento de muitos para muitos, para criarmos este relacionamento precisaremos primeiro criar 
instâncias de nossas entidades.<br/>
Iremos criar mais um objeto Book e em seguida criaremos dois objetos Author, o primeiro objeto Author terá um relacionamento entre o primeiro e segundo objeto Book, 
já nosso segundo objeto Author se relacionará com o segundo e o terceiro objetos Book.<br/>
Criando mais um objeto Book:
```java
curl -i -X POST -H "Content-Type:application/json" -d "{\"title\":\"Book 3\"}" http://localhost:8080/books
```

Criando nossos 2 objetos de Author:
```java
curl -i -X POST -H "Content-Type:application/json" -d "{\"name\":\"Author 1\"}" http://localhost:8080/authors
curl -i -X POST -H "Content-Type:application/json" -d "{\"name\":\"Author 2\"}" http://localhost:8080/authors
```

Agora iremos relacionar primeiro e o segundo objeto Book ao primeiro objeto Author:
```java
curl -i -X PATCH -H "Content-Type: text/uri-list" -d "http://localhost:8080/books/1" http://localhost:8080/authors/1/books
curl -i -X PATCH -H "Content-Type: text/uri-list" -d "http://localhost:8080/books/2" http://localhost:8080/authors/1/books
```

Para consultar o resultado você pode executar o seguinte comando:
```java
curl -i -X GET http://localhost:8080/authors/1/books
```

Em seguida associaremos o segundo e o terceiro objeto Book ao segundo objeto Author:
```java
curl -i -X PATCH -H "Content-Type: text/uri-list" -d "http://localhost:8080/books/2" http://localhost:8080/authors/2/books
curl -i -X PATCH -H "Content-Type: text/uri-list" -d "http://localhost:8080/books/3" http://localhost:8080/authors/2/books
```

Para consultar o resultado você pode executar o seguinte comando:
```java
curl -i -X GET http://localhost:8080/authors/2/books
```

Caso queira excluir estes relacionamentoo basta executar um DELETE para cada objeto Book da seguinte forma:
```java
curl -i -X DELETE http://localhost:8080/authors/1/books/1
curl -i -X DELETE http://localhost:8080/authors/1/books/2

curl -i -X DELETE http://localhost:8080/authors/2/books/2
curl -i -X DELETE http://localhost:8080/authors/2/books/3
```


### Criando testes automatizados para nossa aplicação
Neste tópico criaremos testes automatizados para nossa aplicação, abordaremos primeiro algumas partes individuais de nossos testes, e em seguida disponibilizaremos o código 
completo da classe de teste que estamos criando incluindo todos os imports que estão sendo utilizados.<br/>

#### Criando a estrutura inicial da classe de testes
Primeiro vamos criar uma classe de teste que injeta uma instância **TestRestTemplate** e define as constantes que usaremos:
```java
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringDataRestApplication.class, 
  webEnvironment = WebEnvironment.DEFINED_PORT)
public class SpringDataRelationshipsTest {
 
    @Autowired
    private TestRestTemplate template;
 
    private static String BOOK_ENDPOINT = "http://localhost:8080/books/";
    private static String AUTHOR_ENDPOINT = "http://localhost:8080/authors/";
    private static String ADDRESS_ENDPOINT = "http://localhost:8080/addresses/";
    private static String LIBRARY_ENDPOINT = "http://localhost:8080/libraries/";
 
    private static String LIBRARY_NAME = "My Library";
    private static String AUTHOR_NAME = "George Orwell";
    private static String AUTHOR_NAME_2 = "Orwell Richards";
}
```

#### Testando o relacionamento de 1 para 1
Vamos criar um método de teste que salva os objetos **Library** e **Address** fazendo requisições POST para os recursos da coleção.<br/>
Em seguida, ele salva o relacionamento com uma requisição PUT no recurso de associação e verifica se o relacionamento foi estabelecido corretamente através de um requisição GET:
```java
    @Test
    public void testingOneToOneRelationship() {
        // Criando instância de Library e cadastrando via POST
        Library library = new Library(LIBRARY_NAME);
        template.postForEntity(LIBRARY_ENDPOINT, library, Library.class);

        // Criando instância de Address e cadastrando via POST
        Address address = new Address("Main street, nr 1");
        template.postForEntity(ADDRESS_ENDPOINT, address, Address.class);

        // Definindo cabeçalho para Content-Type: text/uri-list
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Content-type", "text/uri-list");

        // Criando relacionamento 1 para 1
        HttpEntity<String> httpEntity 
          = new HttpEntity<>(ADDRESS_ENDPOINT + "/1", requestHeaders);
        template.exchange(LIBRARY_ENDPOINT + "/1/libraryAddress", 
          HttpMethod.PUT, httpEntity, String.class);

        // Testando se o relacionamento foi criado corretamente
        ResponseEntity<Library> libraryGetResponse 
          = template.getForEntity(ADDRESS_ENDPOINT + "/1/library", Library.class);
        assertEquals("library is incorrect", 
          libraryGetResponse.getBody().getName(), LIBRARY_NAME);
    }
```

#### Testando o relacionamento de 1 para muitos
Vamos criar um método de teste que salva uma instância de **Library** e duas instâncias de **Book**, envia uma requisição PUT para cada novo objeto **Book** associando-os 
à **Library** e em seguida verificamos se o relacionamento foi salvo:
```java
    @Test
    public void testingOneToManyRelationship() {
        // Criando instância de Library e cadastrando via POST
        Library library = new Library(LIBRARY_NAME);
        template.postForEntity(LIBRARY_ENDPOINT, library, Library.class);

        // Criando duas instâncias de Book e cadastrando via POST
        Book book1 = new Book("Dune");
        template.postForEntity(BOOK_ENDPOINT, book1, Book.class);
     
        Book book2 = new Book("1984");
        template.postForEntity(BOOK_ENDPOINT, book2, Book.class);

        // Definindo cabeçalho para Content-Type: text/uri-list
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Content-Type", "text/uri-list");

        // Criando relacionamento de 1 para muitos
        HttpEntity<String> bookHttpEntity 
          = new HttpEntity<>(LIBRARY_ENDPOINT + "/1", requestHeaders);
        template.exchange(BOOK_ENDPOINT + "/1/library", 
          HttpMethod.PUT, bookHttpEntity, String.class);
        template.exchange(BOOK_ENDPOINT + "/2/library", 
          HttpMethod.PUT, bookHttpEntity, String.class);

        // Testando se o relacionamento foi criado corretamente para o objeto Book 1
        ResponseEntity<Library> libraryGetResponse = 
          template.getForEntity(BOOK_ENDPOINT + "/1/library", Library.class);
        assertEquals("library is incorrect", 
          libraryGetResponse.getBody().getName(), LIBRARY_NAME);

        // Testando se o relacionamento foi criado corretamente para o objeto Book 2
        libraryGetResponse =
                template.getForEntity(BOOK_ENDPOINT + "/2/library", Library.class);
        assertEquals("library is incorrect",
                libraryGetResponse.getBody().getName(), LIBRARY_NAME);
    }
```

#### Testando o relacionamento de muitos para muitos
Para testar o relacionamento muitos para muitos entre as entidades **Book** e **Author**, criaremos um método de teste que salva dois registros de **Author** e três 
registros de **Book**.<br/>
Enviamos uma requisição PUT relacionando os objetos 1 e 2 de **Book** ao primeiro objeto **Author**.<br/>
Em seguida enviamos uma requisição PUT relacionando os objetos 2 e 3 de **Book** ao segundo objeto **Author**.<br/>
Para finalizar testamos se os relacionamentos foram criados conforme esperado.
```java
    @Test
    public void testingManyToManyRelationship() throws JSONException {
        // Criando duas instâncias de Author e cadastrando via POST
        Author author1 = new Author(AUTHOR_NAME_1);
        template.postForEntity(AUTHOR_ENDPOINT, author1, Author.class);

        Author author2 = new Author(AUTHOR_NAME_2);
        template.postForEntity(AUTHOR_ENDPOINT, author2, Author.class);

        // Criando três instâncias de Book e cadastrando via POST
        Book book1 = new Book("Animal Farm");
        template.postForEntity(BOOK_ENDPOINT, book1, Book.class);
     
        Book book2 = new Book("1984");
        template.postForEntity(BOOK_ENDPOINT, book2, Book.class);

        Book book3 = new Book("Lost");
        template.postForEntity(BOOK_ENDPOINT, book3, Book.class);

        // Definindo cabeçalho para Content-Type: text/uri-list
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Content-type", "text/uri-list");

        // Criando relacionamento de muitos para muitos com o objeto Author 1
        HttpEntity<String> httpEntity = new HttpEntity<>(
          BOOK_ENDPOINT + "/1\n" + BOOK_ENDPOINT + "/2", requestHeaders);
        template.exchange(AUTHOR_ENDPOINT + "/1/books", 
          HttpMethod.PUT, httpEntity, String.class);


        // Testando se o relacionamento com o objeto Book 1 foi criado corretamente para o objeto Author 1
        String jsonResponse = template
                .getForObject(BOOK_ENDPOINT + "/1/authors", String.class);
        JSONObject jsonObj = new JSONObject(jsonResponse).getJSONObject("_embedded");
        JSONArray jsonArray = jsonObj.getJSONArray("authors");
        assertEquals("author is incorrect",
                jsonArray.getJSONObject(0).getString("name"), AUTHOR_NAME_1);


        // Testando se o relacionamento com o objeto Book 2 foi criado corretamente para o objeto Author 1
        jsonResponse = template
                .getForObject(BOOK_ENDPOINT + "/2/authors", String.class);
        jsonObj = new JSONObject(jsonResponse).getJSONObject("_embedded");
        jsonArray = jsonObj.getJSONArray("authors");
        assertEquals("author is incorrect",
                jsonArray.getJSONObject(0).getString("name"), AUTHOR_NAME_1);


        // Criando relacionamento de muitos para muitos com o objeto Author 2
        HttpEntity<String> httpEntity1 = new HttpEntity<>(
                BOOK_ENDPOINT + "/2\n" + BOOK_ENDPOINT + "/3", requestHeaders);
        template.exchange(AUTHOR_ENDPOINT + "/2/books",
                HttpMethod.PUT, httpEntity1, String.class);

        // Testando se o relacionamento com o objeto Book 2 foi criado corretamente para o objeto Author 2
        jsonResponse = template
                .getForObject(BOOK_ENDPOINT + "/2/authors", String.class);
        jsonObj = new JSONObject(jsonResponse).getJSONObject("_embedded");
        jsonArray = jsonObj.getJSONArray("authors");
        assertEquals("author is incorrect",
                jsonArray.getJSONObject(1).getString("name"), AUTHOR_NAME_2);


        // Testando se o relacionamento com o objeto Book 3 foi criado corretamente para o objeto Author 2
        jsonResponse = template
                .getForObject(BOOK_ENDPOINT + "/3/authors", String.class);
        jsonObj = new JSONObject(jsonResponse).getJSONObject("_embedded");
        jsonArray = jsonObj.getJSONArray("authors");
        assertEquals("author is incorrect",
                jsonArray.getJSONObject(0).getString("name"), AUTHOR_NAME_2);


    }
```

#### Código completo de nosso teste
O código completo de nosso teste incluindo também todos os nossos imports pode ser encontrado neste [link](./exemplos/spring-data-rest/src/test/java/com/springdatarest/SpringDataRelationshipsTest.java).

### Conclusão
Parabéns, você acabou de criar um projeto utilizando diferentes tipos de relacionamentos com o Spring Data REST.<br/>
Caso queira verificar o código completo você pode encontrá-lo neste [link](https://github.com/corelioBH/design-app-java/tree/master/Api%20JaxRS/laboratorio1/DataRestRelationships/exemplos/spring-data-rest).