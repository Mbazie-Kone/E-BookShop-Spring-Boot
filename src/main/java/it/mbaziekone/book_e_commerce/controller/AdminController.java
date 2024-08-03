package it.mbaziekone.book_e_commerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@GetMapping
	public String dashboard() {
		
		return "adminPortal";
	}
	
	@GetMapping("/products")
	public String findAllProducts() {
		
		return "insertForm";
	}
	
}
