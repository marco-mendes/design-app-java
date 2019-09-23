## Acessando dados do JPA com REST

### Material de referência

[Accessing JPA Data with REST](https://spring.io/guides/gs/accessing-data-rest/)

### Introdução

Este guia orienta você no processo de criação de um aplicativo que acessa dados JPA relacionais por meio de um front end RESTful baseado em Hypermedia.

### O que você irá construir

Você criará um aplicativo Spring que permite criar e recuperar objetos Person armazenados em um banco de dados usando o Spring Data REST. O Spring Data REST utiliza os recursos do Spring HATEOAS e do Spring Data JPA e os combina automaticamente.

### O que você irá precisar

- Seu IDE favorito
- JDK 11
- Maven 3.2 ou superior

### Obtendo o código base para este realizar este tutorial

Possuímos um código que pode ser utilizado como base para completar este tutorial, o mesmo pode ser encontrado neste [link](./exemplos/base/) e pode ser importado em seu IDE.<br/>
É importante analisar o arquivo **pom.xml** do projeto para verificar as dependências que estão sendo utilizadas nele.

### Criando a classe Person

Crie uma representação da classe Person conforme o exemplo abaixo:

```java
// Localização para criação desta classe: src/main/java/com/example/accessingdatarest/Person.java
package com.example.accessingdatarest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String firstName;
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
```

O objeto Person possui as propriedades **firstName** e **lastName**, além deles possuímos também a propriedade **id** configurada para ser gerada automaticamente, portanto você não precisa lidar com ela.

### Criando a classe PersonRepository

Em seguida, você precisa criar um repositório simples conforme o exemplo abaixo:

```java
// Localização para criação desta classe: src/main/java/com/example/accessingdatarest/PersonRepository.java
package com.example.accessingdatarest;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

	List<Person> findByLastName(@Param("name") String name);

}
```

Este repositório é uma interface que permite executar várias operações envolvendo objetos **Person**. Ele obtém essas operações estendendo a interface **PagingAndSortingRepository** definida no Spring Data Commons.

No tempo de execução, o Spring Data REST cria automaticamente uma implementação dessa interface. Em seguida, ele usa a annotation **@RepositoryRestResource** para direcionar o Spring MVC para criar endpoints RESTful em **/people**.

**@RepositoryRestResource** não é necessário para que um repositório seja exportado. É usado apenas para alterar os detalhes da exportação, como usar **/people** em vez do valor padrão de **/peoples**.

Aqui você também definiu automáticamente uma consulta personalizada para recuperar uma lista de objetos **Person** com base no atributo **lastName**. Você pode ver como utilizá-la posteriormente neste tutorial.

**@SpringBootApplication** é uma annotation de conveniência que adiciona todo o seguinte:

- **@Configuration**: marca a classe como uma fonte de definições de bean para o contexto do aplicativo.
- **@EnableAutoConfiguration**: Diz ao Spring Boot para começar a adicionar beans com base nas configurações do classpath, outros beans e várias configurações de propriedades. Por exemplo, se spring-webmvc estiver no classpath, essa annotation sinalizará o aplicativo como um aplicativo da web e ativará os principais comportamentos, como configurar um **DispatcherServlet**.
- **@ComponentScan**: Diz ao Spring que procure outros componentes, configurações e serviços no pacote **com.exemplo**, permitindo que ele encontre os controllers.

O método **main()** usa o método **SpringApplication.run()** do Spring Boot para iniciar um aplicativo. Você notou que não havia uma única linha de XML? Também não há arquivo web.xml. Esse aplicativo da Web é 100% Java puro e você não precisou configurar nenhum [plumbing](http://mindprod.com/jgloss/plumbing.html) ou infraestrutura.

O Spring Boot gera automaticamente o Spring Data JPA para criar uma implementação concreta do **PersonRepository** e configurá-lo para conversar com um banco de dados backend na memória usando JPA.

O Spring Data REST é construído sobre o Spring MVC. Ele cria uma coleção de controllers Spring MVC, conversores JSON e outros beans para fornecer um front end RESTful. Esses componentes são vinculados ao backend do Spring Data JPA. Quando você usa o Spring Boot, tudo isso é configurado automaticamente. Se você deseja investigar como isso funciona, consulte o **RepositoryRestMvcConfiguration** no Spring Data REST.

### Executando a aplicação

Para executar a aplicação basta que você execute a classe Application em seu IDE, caso queira gerar um binário JAR e executar a aplicação através dele você pode executar o seguinte comando na pasta raiz do projeto:

```java
mvn package
```

Após isso basta executar o seguinte comando:

```java
java -jar target/gs-accessing-data-rest-0.1.0.jar
```

### Testando o serviço

Agora que o aplicativo está sendo executado, você pode testá-lo. Você pode usar qualquer cliente REST que desejar. Os exemplos a seguir usam a ferramenta unix **curl**.

Primeiro você deseja ver o serviço de nível superior. O exemplo a seguir mostra como fazer isso:

```java
curl http://localhost:8080

{
  "_links" : {
    "people" : {
      "href" : "http://localhost:8080/people{?page,size,sort}",
      "templated" : true
    }
  }
}
```

O exemplo anterior fornece uma primeira visão do que esse servidor tem a oferecer. Há um link para people localizado em http://localhost:8080/people. Possui algumas opções, como **?page**, **?size**, e **?sort**.

O Spring Data REST usa o [formato HAL](http://stateless.co/hal_specification.html) para saída JSON. É flexível e oferece uma maneira conveniente de fornecer links adjacentes aos dados que são veiculados.

O exemplo a seguir mostra como ver os registros de **/people** (nenhum atualmente):

```java
curl http://localhost:8080/people

{
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/people{?page,size,sort}",
      "templated" : true
    },
    "search" : {
      "href" : "http://localhost:8080/people/search"
    }
  },
  "page" : {
    "size" : 20,
    "totalElements" : 0,
    "totalPages" : 0,
    "number" : 0
  }
}
```

No momento, não há elementos e, portanto, não há páginas. Hora de criar um novo registro do tipo **Person**! O exemplo a seguir mostra como fazer isso:

```java
curl -i -X POST -H "Content-Type:application/json" -d '{"firstName": "Frodo", "lastName": "Baggins"}' http://localhost:8080/people

HTTP/1.1 201 Created
Server: Apache-Coyote/1.1
Location: http://localhost:8080/people/1
Content-Length: 0
Date: Wed, 26 Feb 2014 20:26:55 GMT
```

- **-i**: garante que você possa ver a mensagem de resposta, incluindo os cabeçalhos. O URI do objeto Person recém-criado é mostrado.
- **-X POST**: sinaliza que esta requisição é do tipo POST usado para criar um novo registro.
- **-H "Content-Type:application/json"**: define o tipo de conteúdo para que o aplicativo saiba que os dados de entrada contém um objeto JSON.
- **-d '{"firstName": "Frodo", "lastName": "Baggins"}'**: os dados que serão enviados.

Você pode consultar todos os registros Person, como mostra o exemplo a seguir:

```java
curl http://localhost:8080/people

{
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/people{?page,size,sort}",
      "templated" : true
    },
    "search" : {
      "href" : "http://localhost:8080/people/search"
    }
  },
  "_embedded" : {
    "persons" : [ {
      "firstName" : "Frodo",
      "lastName" : "Baggins",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/people/1"
        }
      }
    } ]
  },
  "page" : {
    "size" : 20,
    "totalElements" : 1,
    "totalPages" : 1,
    "number" : 0
  }
}
```

O objeto **persons** contém uma lista que inclui o **Frodo**. Observe como ele inclui um link automático. O Spring Data REST também usa o Evo Inflector para pluralizar o nome da entidade para agrupamentos.

Você pode consultar diretamente o registro individual, da seguinte maneira:

```java
curl http://localhost:8080/people/1

{
  "firstName" : "Frodo",
  "lastName" : "Baggins",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/people/1"
    }
  }
}
```

Você pode encontrar todas as consultas personalizadas, conforme mostrado no exemplo a seguir:

```java
curl http://localhost:8080/people/search

{
  "_links" : {
    "findByLastName" : {
      "href" : "http://localhost:8080/people/search/findByLastName{?name}",
      "templated" : true
    }
  }
}
```

Você pode ver o URL da consulta, incluindo o parâmetro de consulta HTTP, **name**. Observe que isso corresponde à annotation **@Param("name")** incorporada na interface.

O exemplo a seguir mostra como usar a consulta **findByLastName**:

```java
curl http://localhost:8080/people/search/findByLastName?name=Baggins

{
  "_embedded" : {
    "persons" : [ {
      "firstName" : "Frodo",
      "lastName" : "Baggins",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/people/1"
        }
      }
    } ]
  }
}
```

Como você o definiu para retornar List <Person> no código, ele retorna todos os resultados. Se você o definiu para retornar apenas Person, ele seleciona um dos objetos Person para retornar. Como isso pode ser imprevisível, você provavelmente não deseja fazer isso para consultas que possam retornar várias entradas.

Você também pode emitir chamadas **PUT**, **PATCH** e **DELETE** para substituir, atualizar ou excluir registros existentes (respectivamente). O exemplo a seguir usa uma chamada **PUT**:

```java
curl -X PUT -H "Content-Type:application/json" -d '{"firstName": "Bilbo", "lastName": "Baggins"}' http://localhost:8080/people/1
curl http://localhost:8080/people/1

{
  "firstName" : "Bilbo",
  "lastName" : "Baggins",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/people/1"
    }
  }
}
```

O exemplo a seguir usa uma chamada **PATCH**:

```java
curl -X PATCH -H "Content-Type:application/json" -d '{"firstName": "Bilbo Jr."}' http://localhost:8080/people/1
curl http://localhost:8080/people/1

{
  "firstName" : "Bilbo Jr.",
  "lastName" : "Baggins",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/people/1"
    }
  }
}
```

**Observação**:<br/>
**PUT** substitui um registro inteiro. Os campos não fornecidos são substituídos por valores nulos. Você pode usar **PATCH** para atualizar um subconjunto de itens.

Você também pode excluir registros, como o exemplo a seguir mostra:

```java
curl -X DELETE http://localhost:8080/people/1
curl http://localhost:8080/people

{
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/people{?page,size,sort}",
      "templated" : true
    },
    "search" : {
      "href" : "http://localhost:8080/people/search"
    }
  },
  "page" : {
    "size" : 20,
    "totalElements" : 0,
    "totalPages" : 0,
    "number" : 0
  }
}
```

Um aspecto conveniente dessa interface controlada por Hypermedia é que você pode descobrir todos os terminais RESTful usando curl (ou qualquer cliente REST que desejar). Você não precisa trocar um contrato formal ou documento de interface com seus clientes.

### Conclusão

Parabéns! Você desenvolveu um aplicativo com um front end RESTful baseado em Hypermedia e um backend baseado em JPA.<br/>
Caso queira verificar o código completo você pode encontrá-lo neste [link](./exemplos/completo/).
