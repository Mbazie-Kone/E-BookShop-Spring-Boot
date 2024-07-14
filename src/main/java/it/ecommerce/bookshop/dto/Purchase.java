package it.ecommerce.bookshop.dto;

import java.util.Set;

import it.ecommerce.bookshop.model.Address;
import it.ecommerce.bookshop.model.Customer;
import it.ecommerce.bookshop.model.Order;
import it.ecommerce.bookshop.model.OrderItem;
import lombok.Data;

@Data
public class Purchase {
	
	private Customer customer;
	
	private Address shippingAddress;
	
	private Address billingAddress;
	
	private Order order;
	
	private Set<OrderItem> orderItems;

}
