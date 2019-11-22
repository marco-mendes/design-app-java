package com.exemplo.bookapi.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.anyLong;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import com.exemplo.bookapi.entities.Book;
import com.exemplo.bookapi.repository.BookRepository;
import com.exemplo.bookapi.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class BookControllerTest {

	@MockBean
	BookRepository bookRepository;
	
	@MockBean
	BookService bookService;
	
    @Autowired
    private MockMvc mvc;
    
    @Autowired
    private ObjectMapper objectMapper;

    List<Book> books;
	Book novoLivro = new Book("Meu novo Livro", "897979");
	Book novoLivroComId = new Book(1L, "Meu novo Livro", "897979");
	Book livroAtualizado = new Book(1L, "Meu novo Livro - Atualizado", "897979");
    
    @BeforeEach
    public void setup() {
    	books = new ArrayList();
		
		books.add(new Book(1L, "O Senhor dos Anéis", "12345"));
		books.add(new Book(2L, "Harry Potter e a pedra filosofal", "23456"));
		books.add(new Book(3L, "Jogos Vorazes", "34567"));
		books.add(new Book(4L, "Percy Jackson o ladrão de raios", "45678"));

		/*
		when(bookRepository.findAll()).thenReturn(books);
    	when(bookRepository.findById(1L)).thenReturn(Optional.of(books.get(0)));
    	when(bookRepository.findById(2L)).thenReturn(Optional.of(books.get(1)));
    	when(bookRepository.save(novoLivro)).thenReturn(novoLivroComId);
    	when(bookRepository.save(novoLivroComId)).thenReturn(livroAtualizado);
    	doNothing().when(bookRepository).deleteById(anyLong());
    	*/
    	
		when(bookService.getAllBooks()).thenReturn(books);
    	when(bookService.getBookById(1L)).thenReturn(Optional.of(books.get(0)));
    	when(bookService.getBookById(2L)).thenReturn(Optional.of(books.get(1)));
    	when(bookService.addBook(novoLivro)).thenReturn(novoLivroComId);
    	when(bookService.updateBook(novoLivroComId)).thenReturn(livroAtualizado);
    	doNothing().when(bookService).deleteBook(anyLong());
    	
    }
    
    @Test
    public void getAllBooks( ) throws Exception {
    	MvcResult resultado = mvc.perform(MockMvcRequestBuilders
    			.get("/v1/books")
    			.accept(MediaType.APPLICATION_JSON))
    			.andExpect(MockMvcResultMatchers.status().isOk())
    			.andReturn();
    	
    	String contentAsString = resultado.getResponse().getContentAsString(StandardCharsets.UTF_8);
    	List<Book> bookResponse = Arrays.asList(objectMapper.readValue(contentAsString, Book[].class));
    	assertEquals(books, bookResponse);
    }

    @Test
    public void getBookById() throws Exception {
    	MvcResult resultado = mvc.perform(MockMvcRequestBuilders
    			.get("/v1/books/{id}", 1)
    			.accept(MediaType.APPLICATION_JSON))
    			.andExpect(MockMvcResultMatchers.status().isOk())
    			.andReturn();
    	
    	String contentAsString = resultado.getResponse().getContentAsString(StandardCharsets.UTF_8);
    	Book bookResponse = objectMapper.readValue(contentAsString, Book.class);
    	assertEquals(books.get(0), bookResponse);
    }
    

    @Test
    public void createBook() throws Exception {

    	
    	MvcResult resultado = mvc.perform(MockMvcRequestBuilders
    			.post("/v1/books")
    			.content(asJsonString(novoLivro))
    			.contentType(MediaType.APPLICATION_JSON)
    			.characterEncoding("UTF-8")
    			.accept(MediaType.APPLICATION_JSON))
    			.andExpect(MockMvcResultMatchers.status().isCreated())
    			.andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
    			.andReturn();
    	
    	String contentAsString = resultado.getResponse().getContentAsString(StandardCharsets.UTF_8);
    	Book bookResponse = objectMapper.readValue(contentAsString, Book.class);
    	assertEquals(novoLivroComId, bookResponse);

    }
    
    @Test
    public void updateBook() throws Exception {

    	MvcResult resultado = mvc.perform(MockMvcRequestBuilders
    			.put("/v1/books/{id}", 1)
    			.content(asJsonString(livroAtualizado))
    			.contentType(MediaType.APPLICATION_JSON)
    			.characterEncoding("UTF-8")
    			.accept(MediaType.APPLICATION_JSON))
    			.andExpect(MockMvcResultMatchers.status().isOk())
    			.andReturn();
    	
    	String contentAsString = resultado.getResponse().getContentAsString(StandardCharsets.UTF_8);
    	Book bookResponse = objectMapper.readValue(contentAsString, Book.class);
    	assertEquals(livroAtualizado, bookResponse);

    }

    @Test
    public void deleteBook() throws Exception {
    	mvc.perform(MockMvcRequestBuilders
    			.delete("/v1/books/{id}", 1))
    			.andExpect(MockMvcResultMatchers.status().isOk());
    }
    
    public static String asJsonString(final Object obj) {
        try {
        	ObjectMapper mapper = new ObjectMapper();

            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
