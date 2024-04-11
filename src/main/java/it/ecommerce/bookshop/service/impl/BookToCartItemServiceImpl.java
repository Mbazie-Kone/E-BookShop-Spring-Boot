package it.ecommerce.bookshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.ecommerce.bookshop.model.BookToCartItem;
import it.ecommerce.bookshop.repository.BookToCartItemRepository;
import it.ecommerce.bookshop.service.BookToCartItemService;

@Service
public class BookToCartItemServiceImpl implements BookToCartItemService {
	
	@Autowired
	private BookToCartItemRepository bookToCartItemRepository;

	@Override
	public BookToCartItem findBookToCartItemById(Long id) {
		
		BookToCartItem bookToCartItem = bookToCartItemRepository.findById(id).orElse(null);
		
		return bookToCartItem;
	}

	@Override
	public List<BookToCartItem> findAllBookToCartItem() {
		
		List<BookToCartItem> bookToCartItems = (List<BookToCartItem>) bookToCartItemRepository.findAll();
		
		return bookToCartItems;
	}

	@Override
	public BookToCartItem addBookToCartItem(BookToCartItem bookToCartItem) {
		
		BookToCartItem btci = bookToCartItemRepository.save(bookToCartItem);
		
		return btci;
	}

	@Override
	public BookToCartItem updateBookToCartItem(BookToCartItem bookToCartItem) {
		
		BookToCartItem btci = bookToCartItemRepository.save(bookToCartItem);
		
		return btci;
	}

	@Override
	public void deleteBookToCartItem(BookToCartItem bookToCartItem) {
		
		bookToCartItemRepository.delete(bookToCartItem);
	}

}