package it.mbaziekone.book_e_commerce.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class AdminDto {
	
	@NotEmpty(message = "Username is required")
	private String username;
	
	@NotEmpty(message = "Password is required")
	@Size(min = 12, message = "Password must be at least 12 caracters long")
	private String password;
	
	@NotEmpty(message = "Confirm password is required")
	@Size(min = 12, message = "Confirm password must be at least 12 caracters long")
	private String confirmPassword;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
}