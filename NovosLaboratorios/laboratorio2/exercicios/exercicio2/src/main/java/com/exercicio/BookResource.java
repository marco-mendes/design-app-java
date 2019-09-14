package com.exercicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("v1")
public class BookResource {

    @Autowired
    private BookService bookService;

    @GetMapping(path="books")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> allBooks = bookService.getAllBooks();
        return new ResponseEntity<>(allBooks, HttpStatus.OK);
    }

    @GetMapping(path="book/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
        Book book = bookService.getBookById(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PostMapping(path="book")
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(path="book/{id}")
    public ResponseEntity<?> updateBook (@PathVariable("id") int id, @RequestBody Book book) {
        bookService.updateBook(id, book);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path="book/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") int id) {
        bookService.removeBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
