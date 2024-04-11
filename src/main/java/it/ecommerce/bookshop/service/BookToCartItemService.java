package it.ecommerce.bookshop.service;

import java.util.List;

import it.ecommerce.bookshop.model.BookToCartItem;

public interface BookToCartItemService {
	
	public BookToCartItem findBookToCartItemById(Long id);
	
	public List<BookToCartItem> findAllBookToCartItem();
	
	public BookToCartItem addBookToCartItem(BookToCartItem bookToCartItem);
	
	public BookToCartItem updateBookToCartItem(BookToCartItem bookToCartItem);
	
	public void deleteBookToCartItem(BookToCartItem bookToCartItem);
	
}