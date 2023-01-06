package com.eloy.hoppersreceipt;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecieptController {
	
	@RequestMapping("/")
	public String index(Model model) {
		
		 String name = "Eloy Vigil";
	     String itemName = "Copper wire";
	     double price = 5.25;
	     String description = "Metal strips, also an illustration of nanoseconds.";
	     String vendor = "Little Things Corner Store";
		
	     model.addAttribute("fullName", name);
	     model.addAttribute("itemName", itemName);
	     model.addAttribute("price", price);
	     model.addAttribute("description", description);
	     model.addAttribute("vendor", vendor);
	        
	        return "Index.jsp";
		
		
	}
}





