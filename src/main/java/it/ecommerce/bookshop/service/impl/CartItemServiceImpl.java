package it.ecommerce.bookshop.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.ecommerce.bookshop.model.Book;
import it.ecommerce.bookshop.model.CartItem;
import it.ecommerce.bookshop.model.Order;
import it.ecommerce.bookshop.model.ShoppingCart;
import it.ecommerce.bookshop.model.User;
import it.ecommerce.bookshop.repository.BookToCartItemRepository;
import it.ecommerce.bookshop.repository.CartItemRepository;
import it.ecommerce.bookshop.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService {
	
	@Autowired
	private CartItemRepository cartItemRepository;
	
	@Autowired
	private BookToCartItemRepository bookToCartItemRepository;

	@Override
	public List<CartItem> findByShoppingCart(ShoppingCart shoppingCart) {
		
		return cartItemRepository.findByShoppingCart(shoppingCart);
	}

	@Override
	public List<CartItem> findByOrder(Order order) {
		
		return cartItemRepository.findByOrder(order);
	}

	@Override
	public CartItem findByCartItemId(Long id) {
		
		return cartItemRepository.findById(id).orElse(null);
	}

	@Override
	public CartItem addCartItem(CartItem cartItem) {
		
		return cartItemRepository.save(cartItem);
	}

	@SuppressWarnings("deprecation")
	@Override
	public CartItem updateCartItem(CartItem cartItem) {
		
		BigDecimal bigDecimal = new BigDecimal(cartItem.getBook().getOurPrice()).multiply(new BigDecimal(cartItem.getQty()));
		bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
		cartItem.setSubtotal(bigDecimal);
		
		cartItemRepository.save(cartItem);
		
		return cartItem;
	}

	@Override
	public CartItem addBookToCartItem(Book book, User user, int qty) {
		
		List<CartItem> cartItems = findByShoppingCart(user.getShoppingCart());
		
		for (CartItem cartItem : cartItems) {
			if(book.getId() == cartItem.getBook().getId()) {
				cartItem.setQty(cartItem.getQty() + qty);
				cartItem.setSubtotal(new BigDecimal(book.getOurPrice()).multiply(new BigDecimal(qty)));
				cartItemRepository.save(cartItem);
				
				return cartItem;
			}
		}
		
		
		return null;
	}

	@Override
	public void removeCartItem(CartItem cartItem) {
		
		bookToCartItemRepository.deleteByCartItem(cartItem);
		cartItemRepository.delete(cartItem);
	}
}