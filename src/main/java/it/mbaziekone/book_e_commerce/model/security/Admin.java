package it.mbaziekone.book_e_commerce.model.security;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "administrators")
public class Admin implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true, name = "user_name")
	@Size(min = 6, message = "Username must be at least 6 characters long")
	private String username;
	
	@Column(nullable = false, name = "pass_word")
	@Size(min = 8, message = "Password must be at least 8 characters long")
	private String password;
	
	@Column(nullable = false, name = "confirm_password")
	@Size(min = 8, message = "Password must be at least 8 characters long")
	private String confirmPassword;
	
	@Column(nullable = false)	
	private String role;

	public Admin() {
		
	}

	public Admin(String username, String password, String role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}

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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
}
