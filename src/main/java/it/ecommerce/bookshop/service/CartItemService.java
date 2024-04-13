package it.ecommerce.bookshop.service;

import java.util.List;

import it.ecommerce.bookshop.model.Book;
import it.ecommerce.bookshop.model.CartItem;
import it.ecommerce.bookshop.model.Order;
import it.ecommerce.bookshop.model.ShoppingCart;
import it.ecommerce.bookshop.model.User;

public interface CartItemService {
	
	public List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);
	
	public List<CartItem> findByOrder(Order order);
	
	public CartItem findByCartItemId(Long id);
	
	public CartItem addCartItem(CartItem cartItem);
	
	public CartItem updateCartItem(CartItem cartItem);
	
	public CartItem addBookToCartItem(Book book, User user, int qty);
	
	public void removeCartItem(CartItem cartItem);
	
}