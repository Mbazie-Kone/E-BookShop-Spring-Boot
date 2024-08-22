package it.mbaziekone.book_e_commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.mbaziekone.book_e_commerce.model.security.Admin;
import it.mbaziekone.book_e_commerce.repository.AdminRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class AdminController {
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new Admin());
		
		return "register";
	}
	
	@PostMapping("/register")
	public String registerUser(@ModelAttribute("user") Admin admin, Model model) {
		// Check if the user name is already taken
		if(adminRepository.findByUsername(admin.getUsername())!= null) {
			model.addAttribute("Error!", "Username already in use");
		}
		
		return "register";
	}
	
	@GetMapping("/loginAdmin")
	public String login() {

		return "loginAdmin";
	}
	
	@PostMapping("/perform_logout")
	public String logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		if(authentication != null) {
			new SecurityContextLogoutHandler().logout(request, response, authentication);	
		}
		
		return "redirect:/loginAdmin?logout=true";
	}
	
}