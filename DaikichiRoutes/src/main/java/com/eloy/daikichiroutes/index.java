package com.eloy.daikichiroutes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class index {
	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("name", "Eloy");
		
		return "NewFile.jsp";
	}
	
}
	
		


