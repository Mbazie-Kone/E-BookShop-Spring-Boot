package it.ecommerce.bookshop.service.impl;

import org.springframework.stereotype.Service;

import it.ecommerce.bookshop.dto.Purchase;
import it.ecommerce.bookshop.dto.PurchaseResponse;
import it.ecommerce.bookshop.model.Order;
import it.ecommerce.bookshop.repository.CustomerRepository;
import it.ecommerce.bookshop.service.CheckoutService;
import jakarta.transaction.Transactional;

@Service
public class CheckoutServiceImpl implements CheckoutService {
	
	private CustomerRepository customerRepository;
	
	public CheckoutServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	@Transactional
	public PurchaseResponse placeOrder(Purchase purchase) {
		
		// retrieve the order info from dto
		Order order = purchase.getOrder()
		
		// generate tracking number
		
		// populate order with orderItems
		
		// populate order with billingAddress and shippingAddress
		
		// populate customer with order
		
		// save to the database
		
		// return a response
		return null;
	}

}
