package it.ecommerce.bookshop.repository;

import org.springframework.data.repository.CrudRepository;

import it.ecommerce.bookshop.model.BookToCartItem;
import it.ecommerce.bookshop.model.CartItem;


public interface BookToCartItemRepository extends CrudRepository<BookToCartItem, Long> {
	
	public void deleteByCartItem(CartItem cartItem);

}