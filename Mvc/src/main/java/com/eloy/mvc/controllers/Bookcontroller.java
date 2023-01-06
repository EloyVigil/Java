package com.eloy.mvc.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eloy.mvc.models.Book;
import com.eloy.mvc.services.BookService;

@Controller
@RequestMapping("/books")
public class Bookcontroller {
	
	@Autowired
	BookService bookService;
	
	@RequestMapping("")
	public String bookstable(Model model) {
		ArrayList<Book> books = bookService.allBooks();
		model.addAttribute("books",books);
		return "index.jsp";
	}
	
	@RequestMapping("/{bookId}")
		public String index(@PathVariable("bookId") Long bookId, Model model) {
		System.out.println(bookId);
		Book book = bookService.findBook(bookId);
		System.out.println(book);
		model.addAttribute("book",book);
		return "show.jsp";		
	}
	
	@RequestMapping("/new")
	public String addNewBook(@ModelAttribute("book") Book book) {
		return "form.jsp";
	}
	
	// Note: We'll be altering this a bit after we introduce data binding.
	@PostMapping("/add")
	public String create(
	    @Valid @ModelAttribute("book") Book book, 
	    BindingResult result) {
		if (result.hasErrors()) {
			return "form.jsp";
		}
	    bookService.createBook(book);
	    return "redirect:/books";
	}

    @RequestMapping("/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "edit.jsp";
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/books/edit.jsp";
        } else {
            bookService.updateBook(book);
            return "redirect:/books";
        }
    }
    
    @RequestMapping(value="/books/{id}", method=RequestMethod.DELETE)
    public String destroyer(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }

    @DeleteMapping("/books/{id}")
    public String destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
	
}
