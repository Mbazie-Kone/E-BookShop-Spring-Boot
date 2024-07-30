package it.mbaziekone.book_e_commerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AdminController {
	
	public String index() {
		
	}
	
	@PostMapping("/insert")
	public String createProduct() {
		
		return "index";
	}
	
}
