package it.mbaziekone.book_e_commerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class AdminController {
	
	@GetMapping("/loginAdmin")
	public String login() {

		return "loginAdmin";
	}
	
	@GetMapping
	public String dashboard() {
		
		return "adminPortal";
	}
	
}