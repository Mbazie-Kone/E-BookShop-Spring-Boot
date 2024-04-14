package it.ecommerce.bookshop.service;

import it.ecommerce.bookshop.model.BillingAddress;
import it.ecommerce.bookshop.model.Order;
import it.ecommerce.bookshop.model.Payment;
import it.ecommerce.bookshop.model.ShippingAddress;
import it.ecommerce.bookshop.model.ShoppingCart;
import it.ecommerce.bookshop.model.User;

public interface OrderService {
	
	public Order addOrder(ShoppingCart shoppingCart, ShippingAddress shippingAddress, 
			BillingAddress billingAddress, Payment payment, String shippingmethod, User user);
	
	public Order findOrderById(Long id);
	
}