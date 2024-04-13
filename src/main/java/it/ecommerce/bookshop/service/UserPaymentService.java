package it.ecommerce.bookshop.service;

import it.ecommerce.bookshop.model.UserPayment;

public interface UserPaymentService {
	
	public UserPayment findById(Long id);
	
	public void deleteById(Long id);
	
}