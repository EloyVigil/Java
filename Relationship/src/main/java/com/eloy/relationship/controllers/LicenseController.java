package com.eloy.relationship.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.eloy.relationship.models.License;
import com.eloy.relationship.services.LicenseService;


@Controller
public class LicenseController {

	@Autowired
	LicenseService licenseService;
	
	// show form page passes "newLicense" to the form:form
	@GetMapping("/license")
	public String newPerson(Model model) {
		model.addAttribute("newLicense", new License());
		return "newLicense.jsp";
	}
	
	// post method to add new user reads "newLicense" on form:form
//   	@PostMapping("/license/add")
//  	 public String create(@Valid @ModelAttribute("newLicense") License license, BindingResult results, Model model)	{
//  		if (results.hasErrors()) {
//  			model.addAttribute("license", licenseService.allLicense());
//  			return "newLicense.jsp";
//  		}
//  		licenseService.createLicense(license);
//  		return "redirect:License";
//  	}
	
	@PostMapping("/licenses")
	public String licenses(@Valid @ModelAttribute("license") License license) {
	    // error handling with binding result omitted    
	    licenseService.createLicense(license); // Already has the person!
	        
	    return "redirect:/show";
	}


	
   	
   	
	
}
