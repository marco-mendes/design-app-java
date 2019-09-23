package com.springdatarest;

import static org.junit.Assert.assertEquals;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.springdatarest.model.Address;
import com.springdatarest.model.Author;
import com.springdatarest.model.Book;
import com.springdatarest.model.Library;

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
    private static String AUTHOR_NAME_1 = "George Orwell";
    private static String AUTHOR_NAME_2 = "Orwell Richards";

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

        // Testando se o relacionamento foi criado corretamente
        ResponseEntity<Library> libraryGetResponse = 
          template.getForEntity(BOOK_ENDPOINT + "/1/library", Library.class);
        assertEquals("library is incorrect", 
          libraryGetResponse.getBody().getName(), LIBRARY_NAME);
    }

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
    
}