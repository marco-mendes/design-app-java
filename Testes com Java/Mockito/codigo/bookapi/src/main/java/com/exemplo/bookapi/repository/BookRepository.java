package com.exemplo.bookapi.repository;

import com.exemplo.bookapi.entities.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    Book findByIsbn(String isbn);

    List<Book> findByTitleContaining(String title);
}