package it.ecommerce.bookshop.service.impl;

import org.springframework.stereotype.Service;

import it.ecommerce.bookshop.model.security.User;
import it.ecommerce.bookshop.repository.UserRepository;
import it.ecommerce.bookshop.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {
	
	private UserRepository userRepository;
	
	@Override
	public User signup(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
