package it.ecommerce.bookshop.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.ecommerce.bookshop.model.CartItem;
import it.ecommerce.bookshop.model.ShoppingCart;
import it.ecommerce.bookshop.repository.ShoppingCartRepository;
import it.ecommerce.bookshop.service.CartItemService;
import it.ecommerce.bookshop.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
	
	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;

	@Override
	public ShoppingCart updateShopping(ShoppingCart shoppingCart) {
		
		BigDecimal cartTotal = new BigDecimal(0);
		List<CartItem> cartItems = cartItemService.findByShoppingCart(shoppingCart);
		
		for (CartItem cartItem : cartItems) {
			if(cartItem.getBook().getInStockNumber() > 0) {
				cartItemService.updateCartItem(cartItem);
				cartTotal = cartTotal.add(cartItem.getSubtotal());
			}
		}
		
		shoppingCart.setGranTotal(cartTotal);
		shoppingCartRepository.save(shoppingCart);
		
		return shoppingCart;
	}

	@Override
	public void clearShoppingCart(ShoppingCart shoppingCart) {
		
		List<CartItem> cartItems = cartItemService.findByShoppingCart(shoppingCart);
		
		for (CartItem cartItem : cartItems) {
			cartItem.setShoppingCart(null);
			cartItemService.addCartItem(cartItem);
		}
		
		shoppingCart.setGranTotal(new BigDecimal(0));
		shoppingCartRepository.save(shoppingCart);
	}
}
