package com.exemplo.bookapi.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.never;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.exemplo.bookapi.entities.Book;
import com.exemplo.bookapi.repository.BookRepository;
import com.exemplo.bookapi.service.BookService;

//@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class BookControllerTest {

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
		
		books.add(new Book(1L, "Coração de Tinta", "12345"));
		books.add(new Book(2L, "A Bússola de ouro", "23456"));
		books.add(new Book(3L, "Casos de Uso Eficazes", "34567"));
		books.add(new Book(4L, "Padrões de Projeto", "45678"));
		
		bookTesteUpdate = new Book(2L, "A Bússola de ouro - 2ºReimpressão", "67890");
		novoLivro = new Book(5L, "Discover to Deliver", "08978");
		
		when(bookRepository.findAll()).thenReturn(books);
		when(bookRepository.findById(1L)).thenReturn(Optional.of(books.get(0)));
		when(bookRepository.findById(2L)).thenReturn(Optional.of(books.get(1)));
		when(bookRepository.findById(3L)).thenReturn(Optional.of(books.get(2)));
		when(bookRepository.findById(4L)).thenReturn(Optional.of(books.get(3)));
		when(bookRepository.save(bookTesteUpdate)).thenReturn(bookTesteUpdate);	
		when(bookRepository.save(novoLivro)).thenReturn(novoLivro);
		doNothing().when(bookRepository).deleteById(1L);
	}
	
	@Test
	public void testeBookService() {
		assertEquals(books, bookService.getAllBooks());
		assertEquals(books.get(0), bookService.getBookById(1L).get());
		assertEquals(books.get(1), bookService.getBookById(2L).get());
		assertEquals(books.get(2), bookService.getBookById(3L).get());
		assertEquals(books.get(3), bookService.getBookById(4L).get());
		assertEquals(bookTesteUpdate, bookService.updateBook(bookTesteUpdate));
		assertEquals(novoLivro, bookService.updateBook(novoLivro));
		verify(bookRepository, never()).deleteById(1L);
		bookService.deleteBook(1L);
		verify(bookRepository, times(1)).deleteById(1L);
	}
	
}
