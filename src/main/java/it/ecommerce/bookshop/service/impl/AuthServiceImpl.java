package it.ecommerce.bookshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import it.ecommerce.bookshop.model.security.User;
import it.ecommerce.bookshop.repository.UserRepository;
import it.ecommerce.bookshop.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public User signup(String username, String password) {
		if(userRepository.findByUsername(username).isPresent()) {
			throw new RuntimeException("User already exists");
		}
		User user = new User();
		user.setUsername(username);;
		user.setPassword(passwordEncoder.encode(password));
		user.setRole("ADMIN");
	}

	@Override
	public User login(String username, String password) {
		
	}

}
