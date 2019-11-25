package com.exemplo.bookapi.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.exemplo.bookapi.entity.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

    Book findByIsbn(String isbn);

    List<Book> findByTitleContaining(String title);
}