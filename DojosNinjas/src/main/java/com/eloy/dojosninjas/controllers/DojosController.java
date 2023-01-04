package com.eloy.dojosninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.eloy.dojosninjas.models.Dojo;
import com.eloy.dojosninjas.models.Ninja;
import com.eloy.dojosninjas.services.DojosService;
import com.eloy.dojosninjas.services.NinjasService;

@Controller
public class DojosController {

	@Autowired
	private DojosService dojosService;
	
	@Autowired
	private NinjasService ninjasService;
	
	
	@GetMapping("/dojo")
	public String dojos(@ModelAttribute("dojo") Dojo dojo, Model model) {
		List<Dojo> dojos = dojosService.allDojo();
		model.addAttribute("dojos", dojos);
		return "newDojo.jsp";
	}
	
	@GetMapping("/ninja")
	public String ninjas(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojos = dojosService.allDojo();
		model.addAttribute("dojos", dojos);
		return "newNinja.jsp"; 
	}
	
	@GetMapping("/display/{id}")
	public String display(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojosService.findById(id);
		model.addAttribute("dojo", dojo);
		model.addAttribute("ninja", dojo.getNinjas());
		return "show.jsp";
	}
	
	@PostMapping("/dojos")
	public String makeDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("dojo", dojosService.allDojo());
			return "newDojo.jsp";
		}
		dojosService.create(dojo);
		return "redirect:/display";
	}
	
	@PostMapping("/ninjas")
	public String makeNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Dojo> dojos = dojosService.allDojo();
			model.addAttribute("dojos", dojos);
			return "newNinja.jsp";
		}
		ninjasService.create(ninja);
		return "redirect:/dojo";
	}
	
}
