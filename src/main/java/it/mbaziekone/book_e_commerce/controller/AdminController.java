package it.mbaziekone.book_e_commerce.controller;

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
import it.mbaziekone.book_e_commerce.repository.AdminRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@Controller
public class AdminController {
	
	private final AdminRepository adminRepository;
	
	private final PasswordEncoder passwordEncoder;
	
	public AdminController(AdminRepository adminRepository, PasswordEncoder passwordEncoder) {
		this.adminRepository = adminRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("user") Admin admin, BindingResult bindingResult, @RequestParam String password, 
			@RequestParam String confirmPassword, Model model) {
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("validError", true);
		}
		
		// Check if the user name is already taken
		if(adminRepository.findByUsername(admin.getUsername())!= null ) {
			model.addAttribute("error", true);
		}
		else if(!password.equals(confirmPassword)) {
			model.addAttribute("errorPassword", true);
			
		}
		
		// Encode the passwords
		admin.setPassword(passwordEncoder.encode(password));
		
		// Set a default role
		admin.setRole("ADMIN");
		
		// Save the user in the database
		adminRepository.save(admin);
		
		// Redirect to the login page
		return "redirect:/loginAdmin";
		
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