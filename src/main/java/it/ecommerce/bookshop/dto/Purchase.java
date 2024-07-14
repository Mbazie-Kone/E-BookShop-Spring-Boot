package it.ecommerce.bookshop.dto;

import it.ecommerce.bookshop.model.Address;
import it.ecommerce.bookshop.model.Customer;
import it.ecommerce.bookshop.model.Order;
import lombok.Data;

@Data
public class Purchase {
	
	private Customer customer;
	
	private Address shippingAddress;
	
	private Address billingAddress;
	
	private Order order;

}
