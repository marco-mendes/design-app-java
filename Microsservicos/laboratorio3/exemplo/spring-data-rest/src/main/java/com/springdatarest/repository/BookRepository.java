package com.springdatarest.repository;

import com.springdatarest.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
	
}