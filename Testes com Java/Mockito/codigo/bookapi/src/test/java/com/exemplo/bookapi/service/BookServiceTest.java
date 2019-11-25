package com.exemplo.bookapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.anyInt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.exemplo.bookapi.entity.Book;
import com.exemplo.bookapi.repository.BookRepository;
import com.exemplo.bookapi.service.BookService;

@SpringBootTest
public class BookServiceTest {

	@Mock
	BookRepository bookRepository;
	
	@InjectMocks
	BookService bookService;
	
	List<Book> books;
	Book bookTesteUpdate;
	Book novoLivro;
	
	@BeforeEach
	public void setup() {
		books = new ArrayList();
		
		books.add(new Book(1, "Coração de Tinta", "12345"));
		books.add(new Book(2, "A Bússola de ouro", "23456"));
		books.add(new Book(3, "Casos de Uso Eficazes", "34567"));
		books.add(new Book(4, "Padrões de Projeto", "45678"));
		
		bookTesteUpdate = new Book(2, "A Bússola de ouro - 2ºReimpressão", "67890");
		novoLivro = new Book(5, "Discover to Deliver", "08978");
		
		when(bookRepository.findAll()).thenReturn(books);
		when(bookRepository.findById(1)).thenReturn(Optional.of(books.get(0)));
		when(bookRepository.findById(2)).thenReturn(Optional.of(books.get(1)));
		when(bookRepository.findById(3)).thenReturn(Optional.of(books.get(2)));
		when(bookRepository.findById(4)).thenReturn(Optional.of(books.get(3)));
		when(bookRepository.save(bookTesteUpdate)).thenReturn(bookTesteUpdate);	
		when(bookRepository.save(novoLivro)).thenReturn(novoLivro);
		doNothing().when(bookRepository).deleteById(anyInt());
	}
	
	@Test
	public void testeGetAllBooks() {
		assertEquals(books, bookService.getAllBooks());
	}
	
	@Test
	public void testeGetBookById() {
		assertEquals(books.get(0), bookService.getBookById(1).get());
		assertEquals(books.get(1), bookService.getBookById(2).get());
		assertEquals(books.get(2), bookService.getBookById(3).get());
		assertEquals(books.get(3), bookService.getBookById(4).get());		
	}

	@Test
	public void testeAddBook() {
		assertEquals(novoLivro, bookService.saveBook(novoLivro));
	}
	
	public void testeUpdateBook() {
		assertEquals(bookTesteUpdate, bookService.saveBook(bookTesteUpdate));
	}
	
	@Test
	public void testeDeleteBook() {
		
		verify(bookRepository, never()).deleteById(1);
		bookService.deleteBook(1);
		verify(bookRepository, times(1)).deleteById(1);
		
		verify(bookRepository, never()).deleteById(10);
		bookService.deleteBook(10);
		verify(bookRepository, times(1)).deleteById(10);
		
	}
	
}
