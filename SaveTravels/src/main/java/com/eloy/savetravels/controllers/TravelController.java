package com.eloy.savetravels.controllers;

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

import com.eloy.savetravels.models.Travel;
import com.eloy.savetravels.services.TravelService;

@Controller
@RequestMapping("/travel")
public class TravelController {

	@Autowired
	TravelService travelService;
	
	@RequestMapping("")
	public String travelstable(Model model) {
		ArrayList<Travel> travels = travelService.allTravel();
		model.addAttribute("travels", travels);
		model.addAttribute("newTravel", new Travel());
		return "travels.jsp";
	}
	
	
	// displays one specific piece of data
	@RequestMapping("/{id}")
	public String addNewTravel(@PathVariable("id") Long id, Model model) {
		Travel travel = travelService.findTravel(id);
		model.addAttribute("travel",travel);
		return "details.jsp";
	}
	
	@RequestMapping("/{id}/edit")
	public String editTravel(@PathVariable("id") Long id, Model model) {
		Travel travel = travelService.findTravel(id);
		model.addAttribute("travel", travel);
		return "edit.jsp";
	}
	
	   @RequestMapping(value="/{id}", method=RequestMethod.PUT)
	    public String update(@Valid @ModelAttribute("travel") Travel travel, BindingResult result) {
	        if (result.hasErrors()) {
	            return "/travel/edit.jsp";
	        } else {
	            travelService.updateTravel(travel);
	            return "redirect:/travel";
	        }
	    }
	
	   	@PostMapping("/add")
	   	 public String create(@Valid @ModelAttribute("newTravel") Travel travel, BindingResult results, Model model)	{
	   		if (results.hasErrors()) {
	   			model.addAttribute("travels", travelService.allTravel());
	   			return "travels.jsp";
	   		}
	   		travelService.createTravel(travel);
	   		return "redirect:/travel";
	   	}
	   	
	    @DeleteMapping("/{id}/delete")
	    public String destroy(@PathVariable("id") Long id) {
	        travelService.deleteTravel(id);
	        return "redirect:/travel";
	    }
	
	
	
	
}
