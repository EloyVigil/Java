package com.eloy.daikichiroutes;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/daikichi")
public class DaikichiController {
	@RequestMapping("")
	public String index() {
		return "WELCOME!";
	}
	
	@RequestMapping("/today")
	public String today() {
		return "Today you will find luck in all your endeavors!";
	}
	
	@RequestMapping("/tomorrow")
	public String tomorrow() {
		return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
	}

	
    @RequestMapping("/travel/{destination}")
    public String travel(@PathVariable("destination") String destination){
	    return "Congratulations! You will soon be going to " + destination +"!";
	    }

    @RequestMapping("/lotto/{num}")
    public String lotto(@PathVariable("num") String num){
	    int checkNum = Integer.parseInt(num);
    	if(checkNum % 2 == 0) {
	    	return "You will take a grand journey in the near future, but be wary of tempting offers";
	    }
	    
	    else {
	    	return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends";
	    }
    }

 
    }


	
	
	
	


