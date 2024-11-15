package it.mbaziekone.book_e_commerce.model.dto;

import jakarta.validation.constraints.NotEmpty;

public class AdminDto {
	
	@NotEmpty(message = "Username is required")
	private String username;
	
	@NotEmpty(message = "Password is required")
	private String password;
	
	private String role;
}
