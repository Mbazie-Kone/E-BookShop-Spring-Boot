package it.ecommerce.bookshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.ecommerce.bookshop.model.UserShipping;
import it.ecommerce.bookshop.repository.UserShippingRepository;
import it.ecommerce.bookshop.service.UserShippingService;

@Service
public class UserShippingServiceImpl implements UserShippingService {
	
	@Autowired
	private UserShippingRepository userShippingRepository;

	@Override
	public UserShipping findById(Long id) {
		
		return userShippingRepository.findById(id).orElse(null);
		
	}

	@Override
	public void deleteById(Long id) {
		
		userShippingRepository.deleteById(id);
		
	}
}