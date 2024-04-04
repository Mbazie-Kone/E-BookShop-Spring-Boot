package it.ecommerce.bookshop.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.ecommerce.bookshop.model.CartItem;
import it.ecommerce.bookshop.model.Order;
import it.ecommerce.bookshop.model.ShoppingCart;

public interface CartItemRepository extends CrudRepository<CartItem, Long> {
	
	public List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);
	
	public List<CartItem> findByOrder(Order order);
	
}