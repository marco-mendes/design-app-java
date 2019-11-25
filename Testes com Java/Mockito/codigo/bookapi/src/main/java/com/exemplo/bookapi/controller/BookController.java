package com.exemplo.bookapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exemplo.bookapi.entity.Book;
import com.exemplo.bookapi.service.BookService;

import org.springframework.transaction.annotation.Transactional;

@RestController
@RequestMapping("v1")
public class BookController {

	@Autowired
	BookService bookService;

	@GetMapping(path="books")
	public ResponseEntity<?> listAll(){
		return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
		
	}

	@GetMapping(path="books/{id}")
	public ResponseEntity<?>  getBookById(@PathVariable("id") Integer id) {
		Optional<Book> bookOptional = bookService.getBookById(id);
		
		if(bookOptional.isPresent()) {
			return new ResponseEntity<>(bookOptional.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}

	@PostMapping(path="books")
	@Transactional(rollbackFor = Exception.class)
	public ResponseEntity<?> save(@RequestBody Book book){
		return new ResponseEntity<>(bookService.saveBook(book), HttpStatus.CREATED);
	}

	@DeleteMapping(path = "books/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		bookService.deleteBook(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping(path="books/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody Book book){
		if(bookService.getBookById(id).isPresent()) {
			bookService.saveBook(book);
			return new ResponseEntity<>(book, HttpStatus.OK);			
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
	}
	
}
