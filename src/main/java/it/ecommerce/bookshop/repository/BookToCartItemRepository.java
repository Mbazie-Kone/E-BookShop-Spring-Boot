package it.ecommerce.bookshop.repository;

import org.springframework.data.repository.CrudRepository;

import it.ecommerce.bookshop.model.BookToCartItem;

public interface BookToCartItemRepository extends CrudRepository<BookToCartItem, Long> {

}