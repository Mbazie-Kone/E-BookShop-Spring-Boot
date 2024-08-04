package it.mbaziekone.book_e_commerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	
	@GetMapping("/")
	public String dashboard() {
		
		return "adminPortal";
	}
	
	@GetMapping("/loginAdmin")
	public String login() {

		return "loginAdmin";
	}
	
}