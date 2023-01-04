package com.eloy.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eloy.bookclub.models.Books;
import com.eloy.bookclub.repository.BooksRepository;

@Service
public class BooksService {

	// Adding dependecy from book repository
	@Autowired
	private BooksRepository booksRepo;
	
	// Create new book
	public Books create(Books books) {
		return booksRepo.save(books);
	}
	
	//Get one book
	public Books getBook(Long id) {
		return booksRepo.findById(id).orElse(null);
	}
	
	//Find one book by id
	 public Books findById(Long id) {
		 Optional<Books> optionalBook = booksRepo.findById(id);
		 if(optionalBook.isPresent()) {
			 return optionalBook.get();
		 } else {
			 return null;
		 }
	 }
	 
	 //find all books
	 public List<Books> allBooks() {
		 return booksRepo.findAll();
	 }
	 
	 //Update book
	 public Books updateBooks(Books books) {
		 return booksRepo.save(books);
		 }
		 
	 // Delete book
		 public void deleteBook(Long id) {
			 booksRepo.deleteById(id);
		 }
	
	
}
