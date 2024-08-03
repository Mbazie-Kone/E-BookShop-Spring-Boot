package it.mbaziekone.book_e_commerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormSecurityController {
	
	@GetMapping("/login")
	public String loginForm() {
		
		return "loginAdmin";
	}
}
