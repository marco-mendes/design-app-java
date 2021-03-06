package com.exemplo.bookapi.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
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
@ExtendWith(SpringExtension.class)
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
    	Mockito.when(bookService.saveBook(novoLivro)).thenReturn(novoLivroComId);
    	Mockito.when(bookService.saveBook(novoLivroComId)).thenReturn(livroAtualizado);
    	Mockito.doNothing().when(bookService).deleteBook(Mockito.anyInt());
    	
    }
    
    @Test
    public void testeGetAllBooks( ) throws Exception {
    	MvcResult resultado = mvc.perform(MockMvcRequestBuilders
    			.get("/v1/books")
    			.accept(MediaType.APPLICATION_JSON))
    			.andExpect(MockMvcResultMatchers.status().isOk())
    			.andReturn();
    	
    	List<Book> bookResponse = Arrays.asList(mapeiaRetornoParaObjeto(resultado, Book[].class));
    	assertEquals(books, bookResponse);
    }

    @Test
    public void testeGetBookById() throws Exception {
    	MvcResult resultado = mvc.perform(MockMvcRequestBuilders
    			.get("/v1/books/{id}", 1)
    			.accept(MediaType.APPLICATION_JSON))
    			.andExpect(MockMvcResultMatchers.status().isOk())
    			.andReturn();
    	
    	Book bookResponse = mapeiaRetornoParaObjeto(resultado, Book.class);
    	assertEquals(books.get(0), bookResponse);
    }
    

    @Test
    public void testeCreateBook() throws Exception {

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
    public void testeUpdateBook() throws Exception {

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
    public void testeDeleteBook() throws Exception {
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
