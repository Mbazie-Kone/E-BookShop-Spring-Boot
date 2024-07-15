package it.ecommerce.bookshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.ecommerce.bookshop.dto.Purchase;
import it.ecommerce.bookshop.dto.PurchaseResponse;
import it.ecommerce.bookshop.repository.CustomerRepository;
import it.ecommerce.bookshop.service.CheckoutService;

@Service
public class CheckoutServiceImpl implements CheckoutService {
	
	private CustomerRepository customerRepository;
	
	public CheckoutServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public PurchaseResponse placeOrder(Purchase purchase) {
		// TODO Auto-generated method stub
		return null;
	}

}
