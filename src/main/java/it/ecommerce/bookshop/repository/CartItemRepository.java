package it.ecommerce.bookshop.repository;

import org.springframework.data.repository.CrudRepository;

import it.ecommerce.bookshop.model.CartItem;

public interface CartItemRepository extends CrudRepository<CartItem, Long> {

}