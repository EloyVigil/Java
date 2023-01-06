package com.eloy.relationship.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eloy.relationship.models.Person;
import com.eloy.relationship.services.PersonService;

@Controller
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	// show form page passes "newPerson" to the form
	@GetMapping("/person")
	public String newPerson(Model model) {
		model.addAttribute("newPerson", new Person());
		return "newPerson.jsp";
	}
	
//	// update method 
//	   @PutMapping("/person/update/{id}")
//	    public String update(@Valid @ModelAttribute("person") Person person, BindingResult result) {
//	        if (result.hasErrors()) {
//	            return "edit.jsp";
//	        } else {
//	            personService.updatePerson(person);
//	            return "redirect:/person";
//	        }
//	    }
	
	//  get method shows 1 person by id
	@GetMapping("/persons/{person_id}")
	public String showPerson(@PathVariable Long person_id, Model model) {
	    Person someAwesomePerson = personService.findPerson(person_id);
	    model.addAttribute("person", someAwesomePerson);
	    return "show.jsp";
	}

	// post method to add new user and reads "newPerson" from form:form
   	@PostMapping("/person/add")
  	 public String create(@Valid @ModelAttribute("newPerson") Person person, BindingResult results, Model model)	{
  		if (results.hasErrors()) {
  			model.addAttribute("person", personService.allPerson());
  			return "newPerson.jsp";
  		}
  		personService.createPerson(person);
  		return "redirect:/person/{person_id}}";
  	}

	

}
