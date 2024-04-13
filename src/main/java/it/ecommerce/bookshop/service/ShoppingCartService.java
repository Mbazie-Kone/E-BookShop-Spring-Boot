package it.ecommerce.bookshop.service;

import it.ecommerce.bookshop.model.ShoppingCart;

public interface ShoppingCartService {
	
	public ShoppingCart updateShopping(ShoppingCart shoppingCart);
	
	public void clearShoppingCart(ShoppingCart shoppingCart);
	
}