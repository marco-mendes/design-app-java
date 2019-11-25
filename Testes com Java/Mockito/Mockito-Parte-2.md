## Testando um Controller utilizando Mockito, JUnit e Spring Boot

### Introdução

Abordaremos aqui como realizar testes de Controllers utilizando Mockito, JUnit 5 e o Spring Boot.

O Spring Boot nos fornece uma classe que fornece suporte ao teste Spring MVC do lado servidor.

Estamos falando da classe **MockMvc**.

Continuaremos utilizando nosso projeto de exemplo do tutorial anterior neste tutorial.



### Configuração básica para uso

No exemplo abaixo possuímos a configuração básica para uso:

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class BookControllerTest {
	
    @LocalServerPort
    private int port;
    
    @Autowired
    private MockMvc mvc;
    
}
```

A anotação **@AutoConfigureMockMvc** é utilizada para habilitar a auto configuração de nosso objeto **MockMvc**, sem ela não conseguiremos utilizar adequadamente o objeto **MockMvc**.

Com o **MockMvc** podemos realizar requisições ao nosso servidor e validar a resposta de retorno.

Adicionamos também o parâmetro **webEnvironment** com o valor **SpringBootTest.WebEnvironment.RANDOM_PORT** a nossa anotação **@SpringBootTest** para indicar que nossa aplicação será servida em uma porta aleatória, podemos recuperar qual porta está sendo usada utilizando a anotação **@LocalServerPort** conforme o exemplo acima.



### Testando nosso componente BookController

Abra o código fonte de nosso **BookController**, note que possuímos o componente **BookService** como dependência, neste exemplo realizaremos um Mock desta classe para testarmos nosso **BookController**.

```java
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.exemplo.bookapi.entity.Book;
import com.exemplo.bookapi.service.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class BookControllerTest {

    @MockBean
    BookService bookService;
	
    @Autowired
    private MockMvc mvc;
    
    @Autowired
    private ObjectMapper objectMapper;

    List<Book> books;
    Book novoLivro = new Book("Meu novo Livro", "897979");
    Book novoLivroComId = new Book(1, "Meu novo Livro", "897979");
    Book livroAtualizado = new Book(1, "Meu novo Livro - Atualizado", "897979");
    
    @BeforeEach
    public void setup() {
    	books = new ArrayList();
		
    	books.add(new Book(1, "O Senhor dos Anéis", "12345"));
    	books.add(new Book(2, "Harry Potter e a pedra filosofal", "23456"));
    	books.add(new Book(3, "Jogos Vorazes", "34567"));
    	books.add(new Book(4, "Percy Jackson o ladrão de raios", "45678"));
    	
    	Mockito.when(bookService.getAllBooks()).thenReturn(books);
    	Mockito.when(bookService.getBookById(1)).thenReturn(Optional.of(books.get(0)));
    	Mockito.when(bookService.getBookById(2)).thenReturn(Optional.of(books.get(1)));
    	Mockito.when(bookService.saveBook(novoLivro)).thenReturn(novoLivroComId);
    	Mockito.when(bookService.saveBook(novoLivroComId)).thenReturn(livroAtualizado);
    	Mockito.doNothing().when(bookService).deleteBook(Mockito.anyInt());
    	
    }
    
    @Test
    public void getAllBooks( ) throws Exception {
    	MvcResult resultado = mvc.perform(MockMvcRequestBuilders
    			.get("/v1/books")
    			.accept(MediaType.APPLICATION_JSON))
    			.andExpect(MockMvcResultMatchers.status().isOk())
    			.andReturn();
    	
    	List<Book> bookResponse = Arrays.asList(mapeiaRetornoParaObjeto(resultado, Book[].class));
    	assertEquals(books, bookResponse);
    }

    @Test
    public void getBookById() throws Exception {
    	MvcResult resultado = mvc.perform(MockMvcRequestBuilders
    			.get("/v1/books/{id}", 1)
    			.accept(MediaType.APPLICATION_JSON))
    			.andExpect(MockMvcResultMatchers.status().isOk())
    			.andReturn();
    	
    	Book bookResponse = mapeiaRetornoParaObjeto(resultado, Book.class);
    	assertEquals(books.get(0), bookResponse);
    }
    

    @Test
    public void createBook() throws Exception {

    	MvcResult resultado = mvc.perform(MockMvcRequestBuilders
    			.post("/v1/books")
    			.content(mapeiaObjetoParaJson(novoLivro))
    			.contentType(MediaType.APPLICATION_JSON)
    			.characterEncoding("UTF-8")
    			.accept(MediaType.APPLICATION_JSON))
    			.andExpect(MockMvcResultMatchers.status().isCreated())
    			.andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
    			.andReturn();
    	
    	Book bookResponse = mapeiaRetornoParaObjeto(resultado, Book.class);
    	assertEquals(novoLivroComId, bookResponse);

    }
    
    @Test
    public void updateBook() throws Exception {

    	MvcResult resultado = mvc.perform(MockMvcRequestBuilders
    			.put("/v1/books/{id}", 1)
    			.content(mapeiaObjetoParaJson(livroAtualizado))
    			.contentType(MediaType.APPLICATION_JSON)
    			.characterEncoding("UTF-8")
    			.accept(MediaType.APPLICATION_JSON))
    			.andExpect(MockMvcResultMatchers.status().isOk())
    			.andReturn();
    	
    	Book bookResponse = mapeiaRetornoParaObjeto(resultado, Book.class);
    	assertEquals(livroAtualizado, bookResponse);

    }

    @Test
    public void deleteBook() throws Exception {
		Mockito.verify(bookService, Mockito.never()).deleteBook(1);    	
    	
		mvc.perform(MockMvcRequestBuilders
    			.delete("/v1/books/{id}", 1))
    			.andExpect(MockMvcResultMatchers.status().isOk());
    	
    	Mockito.verify(bookService, Mockito.times(1)).deleteBook(1);
    }

    public <T> T mapeiaRetornoParaObjeto(MvcResult resultado, Class tipoRetorno) throws
    		UnsupportedEncodingException, 
    		JsonMappingException, 
    		JsonProcessingException {

    	String contentAsString = resultado.getResponse().getContentAsString(StandardCharsets.UTF_8);
    	return (T) objectMapper.readValue(contentAsString, tipoRetorno);
    }
    
    public static String mapeiaObjetoParaJson(final Object obj) {
        try {
        	ObjectMapper mapper = new ObjectMapper();

            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
```



Neste exemplo estamos realizando o Mock de nosso **BookService** utilizando a anotação **@MockBean**, esta anotação injeta os objetos Mockados no [Spring ApplicationContext]( https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/ApplicationContext.html ). O mock substituirá qualquer [bean]( https://www.baeldung.com/spring-bean#bean-definition ) existente do mesmo tipo no ApplicationContext.

*Um **bean** é um objeto que é instanciado, montado e gerenciado por um contêiner Spring IoC.* 



Vimos no exemplo acima vários usos de nosso objeto MockMvc, abordaremos abaixo alguns dos métodos desse objeto:

* **get()**: Realiza uma requisição do tipo **get** ao nosso servidor, recebe como parâmetro o path que deverá se acessado.
* **post()**: Realiza uma requisição do tipo **post** ao nosso servidor, recebe como parâmetro o path que deverá se acessado.
* **put()**: Realiza uma requisição do tipo **put** ao nosso servidor, recebe como parâmetro o path que deverá se acessado.
* **delete()**: Realiza uma requisição do tipo **delete** ao nosso servidor, recebe como parâmetro o path que deverá se acessado.
* **accept()**: Define o cabeçalho da requisição para o tipo de **MediaType** aceito pela requisição.
* **content()**: Define o conteúdo que será enviado em conjunto com a requisição, normalmente utilizado em conjunto com as requisições do tipo **post** e **put**.
* **contentType()**: Define o valor do cabeçalho **ContentType** de nossa requisição.
* **characterEncoding()**: Define o tipo de codificação de caracteres que nossa requisição deve suportar.
* **andExpect()**: Este método espera que uma condição seja verdadeira em relação a resposta de nossa requisição, caso a condição não seja verdadeira nosso teste falhará.
* **andReturn()**: Retorna um objeto do tipo **MvcResult** que contém o resultado de nossa requisição.

