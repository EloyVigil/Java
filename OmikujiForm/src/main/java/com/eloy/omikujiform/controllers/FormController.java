package com.eloy.omikujiform.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/omikuji")
public class FormController {
	
	@RequestMapping("")
	public String form() {
		return "index.jsp";
	}
	
	@RequestMapping("/show")
	public String show(HttpSession session) {
		return "show.jsp";
	}
	
	@RequestMapping(value="/formsubmit", method=RequestMethod.POST)
	public String formSubmit(
			@RequestParam(value="number") int number,
			@RequestParam(value="city") String city,
			@RequestParam(value="person") String person,
			@RequestParam(value="hobby") String hobby,
			@RequestParam(value="thing") String thing,
			@RequestParam(value="quote") String quote,
			HttpSession session
			) {
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("thing", thing);
		session.setAttribute("quote", quote);
		
		return "redirect:/omikuji/show";
	}
	
}
