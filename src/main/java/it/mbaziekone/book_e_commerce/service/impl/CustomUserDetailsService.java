package it.mbaziekone.book_e_commerce.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import it.mbaziekone.book_e_commerce.model.security.Admin;
import it.mbaziekone.book_e_commerce.repository.AdminRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Admin admin = adminRepository.findByUsername(username);
		if(admin == null) {
			throw new UsernameNotFoundException("User not found");
		}
		
		return User.builder()
				.username(admin.getUsername())
				.password(admin.getPassword())
				.roles(admin.getRole())
				.build();
	}

}