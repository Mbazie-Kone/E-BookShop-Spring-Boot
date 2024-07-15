package it.ecommerce.bookshop.service.impl;

import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Service;

import it.ecommerce.bookshop.dto.Purchase;
import it.ecommerce.bookshop.dto.PurchaseResponse;
import it.ecommerce.bookshop.model.Customer;
import it.ecommerce.bookshop.model.Order;
import it.ecommerce.bookshop.model.OrderItem;
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
		Order order = purchase.getOrder();
		
		// generate tracking number
		String orderTrackingNumber = generateOrderTrackingNumber();
		order.setOrderTrackingNumber(orderTrackingNumber);
		
		// populate order with orderItems
		Set<OrderItem> orderItems = purchase.getOrderItems();
		orderItems.forEach(Item -> order.add(Item));
		
		// populate order with billingAddress and shippingAddress
		order.setBillingAddress(purchase.getBillingAddress());
		order.setShippingAddress(purchase.getShippingAddress());
		
		// populate customer with order
		Customer customer = purchase.getCustomer();
		customer.add(order);
		
		// save to the database
		customerRepository.save(customer);
		
		// return a response
		return new PurchaseResponse(orderTrackingNumber);
	}

	private String generateOrderTrackingNumber() {
		
		// generate a random UUID number (UUID version-4)
		// for details see: https://en.wikipedia.org/wiki/Universally_unique_identifier
		return UUID.randomUUID().toString();
	}
}
