package it.mbaziekone.book_e_commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.mbaziekone.book_e_commerce.model.security.Admin;
import it.mbaziekone.book_e_commerce.service.AdminService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	private final PasswordEncoder passwordEncoder;
	
	public AdminController(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	
	// Administrator dash board
	@GetMapping("/dashboard")
	public String dashPage(Model model) {
		
		model.addAttribute("hasErrors", false);
		
		return "dashboardAdmin";
	}
	
	// Administrator sign up
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("user") Admin admin, 
							   @RequestParam String password, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("hasErrors", true);
			
			return "loginAdmin";
		}
		
		// Encode the password
		admin.setPassword(passwordEncoder.encode(password));
		
		// Set a default role
		admin.setRole("ADMIN");
		
		// Save the user in the database
		adminService.saveAdmin(admin);
		
		return "redirect:/loginAdmin";
	}
	
	// Administrator Login 
	@GetMapping("/loginAdmin")
	public String login(Model model) {
		model.addAttribute("user", new Admin());
		
		return "loginAdmin";
	}
	
	// Administrator logout
	@PostMapping("/perform_logout")
	public String logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		if(authentication != null) {
			new SecurityContextLogoutHandler().logout(request, response, authentication);	
		}
		
		return "redirect:/loginAdmin?logout=true";
	}
	
}