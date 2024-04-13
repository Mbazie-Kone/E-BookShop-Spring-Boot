package it.ecommerce.bookshop.service;

import it.ecommerce.bookshop.model.ShippingAddress;
import it.ecommerce.bookshop.model.UserShipping;

public interface ShippingAddressService {
	
	public ShippingAddress setByUserShipping(UserShipping userShipping, ShippingAddress shippingAddress);
	
}