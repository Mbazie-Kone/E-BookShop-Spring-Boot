package it.mbaziekone.book_e_commerce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.mbaziekone.book_e_commerce.model.security.Admin;
import it.mbaziekone.book_e_commerce.repository.AdminRepository;
import it.mbaziekone.book_e_commerce.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public void saveAdmin(Admin admin) {	
		adminRepository.save(admin);
	}

	@Override
	public Admin findByUsername(String username) {
		
		return adminRepository.findByUsername(username);
	}
}