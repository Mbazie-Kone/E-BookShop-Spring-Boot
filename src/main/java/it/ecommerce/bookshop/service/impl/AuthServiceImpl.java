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
		
		return userRepository.save(user);
	}

	@Override
	public User login(String username, String password) {
		User user = userRepository.findByUsername(username).orElseThrow(()-> new RuntimeException("User not found"));
		if(passwordEncoder.matches(password, user.getPassword())) {
			return user;
		}
		else {
			throw new RuntimeException("Invalid credentials");
		}
	}

}
