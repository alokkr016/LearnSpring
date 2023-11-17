package com.example.CarService.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 1. getAttendent method returns string "attendent" for Attendent page.
 2. Also, it accepts attendentId of type String and object of type ModelMap as argument.
 3. Use @PathVariable annotation accordingly.
**/

@Controller
public class attendentController {
    
	  @GetMapping("/attendent/{attendentId}")
    public String getAttendent(@PathVariable String attendentId, ModelMap model) {
        // Example: Set some attributes in the model
        model.addAttribute("attendantId", attendentId);
        model.addAttribute("attendantName", "TEST 123"); // Replace with actual service call
        model.addAttribute("speciality", "Engine,BodyShop"); // Replace with actual service call
        
        return "attendent";
    }	
	
}
