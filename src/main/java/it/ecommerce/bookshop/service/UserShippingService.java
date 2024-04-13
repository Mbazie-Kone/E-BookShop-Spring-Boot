package it.ecommerce.bookshop.service;

import it.ecommerce.bookshop.model.UserShipping;

public interface UserShippingService {
	
	public UserShipping findById(Long id);
	
	public void deleteById(Long id);
		
}