package com.eloy.bookclub.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eloy.bookclub.models.Books;

// Annotation always used in repository interface
@Repository
public interface BooksRepository extends CrudRepository<Books, Long>{       // extends crud repo to use built in queries
	
	// Adding a method to find all books in List
	List<Books> findAll();


}
