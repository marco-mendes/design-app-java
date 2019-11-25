package com.exemplo.bookapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemplo.bookapi.entity.Book;
import com.exemplo.bookapi.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	
	public List<Book> getAllBooks() {
		List<Book> books = (List<Book>) bookRepository.findAll();
		return books;
	}
	
	public Optional<Book> getBookById(int id) {
		return bookRepository.findById(id);
	}

	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}
		
	public void deleteBook(int id) {
		bookRepository.deleteById(id);
	}
		
}
