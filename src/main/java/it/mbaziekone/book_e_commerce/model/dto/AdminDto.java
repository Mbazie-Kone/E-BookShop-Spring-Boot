package it.mbaziekone.book_e_commerce.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class AdminDto {
	
	@NotEmpty(message = "Username is required")
	private String username;
	
	@NotEmpty(message = "Password is required")
	@Size(min = 12, message = "Password must be at least 12 caracters long")
	private String password;
	
	private String role;
}
