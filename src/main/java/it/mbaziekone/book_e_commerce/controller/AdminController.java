package it.mbaziekone.book_e_commerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AdminController {
	
	@GetMapping
	public String index() {
		
		return "adminPortal";
	}
	
	@GetMapping("/products")
	public String findAllProducts(Model model) {
		
		return "insertForm";
	}
	
}
