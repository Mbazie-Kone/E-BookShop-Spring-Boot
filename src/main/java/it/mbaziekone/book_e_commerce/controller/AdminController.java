package it.mbaziekone.book_e_commerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class AdminController {
	
	@GetMapping
	@ResponseBody
	public String index() {
		return "I'm Index";
	}
	
	@GetMapping("/insert")
	public String findAllProducts() {
		
		return "insertForm";
	}
	
}
