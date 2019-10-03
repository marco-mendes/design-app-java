package com.springdatarest.repository;

import com.springdatarest.model.Library;
import org.springframework.data.repository.CrudRepository;

public interface LibraryRepository extends CrudRepository<Library, Long> {
	
}