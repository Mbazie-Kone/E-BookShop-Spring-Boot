package it.ecommerce.bookshop.dto;

import it.ecommerce.bookshop.model.Address;
import it.ecommerce.bookshop.model.Customer;
import lombok.Data;

@Data
public class Purchase {
	
	private Customer customer;
	
	private Address shippingAddress;

}
