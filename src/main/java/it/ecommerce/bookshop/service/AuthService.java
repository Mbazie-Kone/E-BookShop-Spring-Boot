package it.ecommerce.bookshop.service;

import it.ecommerce.bookshop.model.security.User;

public interface AuthService {
	
	public User signup(String username, String password);
}
