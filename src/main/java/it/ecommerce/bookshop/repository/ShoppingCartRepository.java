package it.ecommerce.bookshop.repository;

import org.springframework.data.repository.CrudRepository;

import it.ecommerce.bookshop.model.ShoppingCart;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {

}