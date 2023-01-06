package com.eloy.mvc.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.eloy.mvc.models.Book;
import com.eloy.mvc.repositories.BookRepository;

@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public ArrayList<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }
    // retrieves a book by id
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }
	
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }
	
}
