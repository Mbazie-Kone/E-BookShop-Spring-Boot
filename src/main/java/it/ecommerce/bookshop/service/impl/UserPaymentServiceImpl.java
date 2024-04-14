package it.ecommerce.bookshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.ecommerce.bookshop.model.UserPayment;
import it.ecommerce.bookshop.repository.UserPaymentRepository;
import it.ecommerce.bookshop.service.UserPaymentService;

@Service
public class UserPaymentServiceImpl implements UserPaymentService {
	
	@Autowired
	private UserPaymentRepository userPaymentRepository;

	@Override
	public UserPayment findById(Long id) {
			
		return userPaymentRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		
		userPaymentRepository.deleteById(id);

	}
}