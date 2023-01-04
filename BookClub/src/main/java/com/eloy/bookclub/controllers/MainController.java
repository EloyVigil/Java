package com.eloy.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.eloy.bookclub.models.Books;
import com.eloy.bookclub.models.LoginUser;
import com.eloy.bookclub.models.User;
import com.eloy.bookclub.services.BooksService;
import com.eloy.bookclub.services.UserService;

// Controller annotation to indicate class no need to extend api class or servlet
@Controller
public class MainController {

	// Dependecy for user service class methods
	@Autowired
	private UserService userServ;
	
	// Dependecy for book service class methods
	@Autowired
	private BooksService booksServ;


	// To display login and registration page
	@GetMapping("/")
	public String logreg(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "loginreg.jsp";
	}
	
	// To post the registration information valid used for validating data from form model attribute binds data with models
	 @PostMapping("/register")
	 public String register(@Valid @ModelAttribute("newUser") User newUser, 
	         BindingResult result, Model model, HttpSession session) {
		 // New instance of user
		 User user = userServ.register(newUser, result);
		 //Validation errors returns to jsp to display error messages
		 if(result.hasErrors()) {
			 model.addAttribute("newLogin", new LoginUser());
			 return "loginreg.jsp";
		 }
		 //Saving userId and userName into session
		 // Setting user id to match user db id
		 session.setAttribute("userId", user.getId());
		 session.setAttribute("userName", user.getUserName());
	     return "redirect:/dashboard";
	 }
	 
	// To post the registration information valid used for validating data from form model attribute binds data with models
	 @PostMapping("/login")
	 public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
	         BindingResult result, Model model, HttpSession session) {
		 User user = userServ.login(newLogin, result);
	     if(result.hasErrors()) {
	         model.addAttribute("newUser", new User());
	         return "loginreg.jsp";
	     }
	     session.setAttribute("userId", user.getId());
	     session.setAttribute("userName", user.getUserName());
	     return "redirect:/dashboard";
	 }

	// To post the registration information valid used for validating data from form model attribute binds data with models
	 @PostMapping("/add/book")
	 public String createBook(@Valid @ModelAttribute("book") Books books, BindingResult result, Model model, HttpSession session) {
		 // If user is NOT in session then redirect to home page
		 if(session.getAttribute("userId") == null) {
			 return "redirect:/";
		 }
		 // Validation errors
		 if(result.hasErrors()) {
			 model.addAttribute("id", session.getAttribute("userId"));
			 return "addbook.jsp";
		 }
		// If no errors then create new book
		 booksServ.create(books);
		 return "redirect:/dashboard";
	 }
	 
	 // Dashboard display using session to check if user is logged in 
	 @GetMapping("/dashboard")
	 public String dashboard(HttpSession session, Model model) {
		 Long userId = (Long) session.getAttribute("userId");
		 if(session.getAttribute("userId") == null) {
			 return "redirect:/";
		 }
		 User user = userServ.findById(userId);
		 model.addAttribute("bookuser", user);
		 model.addAttribute("books", booksServ.allBooks());
		 return "dashboard.jsp";
	 }
	
	 // Invalidates session data at log out
	 @GetMapping("/logout")
	 public String logout(HttpSession session) {
		 session.invalidate();
		 return "redirect:/";
	 }
	 
	 // Model attribute used to bind data from model to form form session is used to input who adds book and validation
	 @GetMapping("/book/form")
	 public String bookform(@ModelAttribute("book")Books books, BindingResult result, HttpSession session, Model model) {
		 if(session.getAttribute("userId") == null) {
			 return "redirect:/";
		 }
		 // Session being passed in to form form for correct creation of book data
		 model.addAttribute("id", session.getAttribute("userId"));
		 return "addbook.jsp";
	 }
	 
	 // Path variable used to correctly identify individual book for viewing
	 @GetMapping("/viewbook/{id}")
	 public String viewBook(@PathVariable("id")Long id, Model model, HttpSession  session) {
		 // If user not in session then redirect to login page
		 if(session.getAttribute("userId") == null) {
			 return "redirect:/";
		 }
		 // If in session then find book by id to view on page
		 Books books = booksServ.findById(id);
		 model.addAttribute("book", books);
		 return "viewbook.jsp";
	 }
	 
	 // Deletion of book if all session security checks pass so no user can interfere with data that they did not enter
	 @DeleteMapping("/delete/{id}")
	 public String delete(@PathVariable("id")Long id, HttpSession session) {
		 // Instance of bookuser id for security check using session data
		 Long bookUserId = booksServ.getBook(id).getUser().getId();
		 // If not in session redirect
		 if(session.getAttribute("userId") == null) {
			 return "redirect:/";
		 }
		 // If not user who created book data then redirect checks logged in user against creator of book  
		 if(!session.getAttribute("userId").equals(bookUserId)) {
			 return "redirect:/dashboard";
		 }
		 // if security passes then delete book
		 booksServ.deleteBook(id);
		 return "redirect:/dashboard"; 
	 }
	 
	 // Uses path variable for id to get book by id
	 @GetMapping("/editbook/{id}")
	 public String edit(@PathVariable("id")Long id,@ModelAttribute("books")Books books, BindingResult result, HttpSession session, Model model) {
		 if(session.getAttribute("userId") == null) {
			 return "redirect:/";
		 }
		    if (result.hasErrors()) {
	            return "edit.jsp";
		    }
		    // uses model model to pass book by id into jsp
		    model.addAttribute("books", booksServ.getBook(id));
		    return "edit.jsp";
	 }
	 
	 // Update mapping to edit book
	 @PutMapping("/editbook/{id}")
	 public String update(@Valid @PathVariable("id")Long id, @ModelAttribute("books") Books books, BindingResult result, HttpSession session, Model model) {
		 // Getting instance of book user who entered data
		 Long bookUserId = booksServ.getBook(id).getUser().getId();
		 if(session.getAttribute("userId") == null) {
			 return "redirect:/";
		 }
		// If not user who created book data then redirect checks logged in user against creator of book 
		 if(!session.getAttribute("userId").equals(bookUserId)) {
			 return "redirect:/dashboard";
		 }
		 // If all security checks pass then update book
		 booksServ.updateBooks(books);
		 return "redirect:/dashboard";
	 }
	
	
}
