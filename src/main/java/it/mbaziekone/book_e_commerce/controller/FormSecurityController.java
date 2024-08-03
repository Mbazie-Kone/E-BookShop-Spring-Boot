package it.mbaziekone.book_e_commerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class FormSecurityController {
	
	@GetMapping("/")
	public String loginForm() {
		
		return "loginAdmin";
	}
}
