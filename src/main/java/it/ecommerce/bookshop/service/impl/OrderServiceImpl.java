package it.ecommerce.bookshop.service.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.ecommerce.bookshop.model.BillingAddress;
import it.ecommerce.bookshop.model.Book;
import it.ecommerce.bookshop.model.CartItem;
import it.ecommerce.bookshop.model.Order;
import it.ecommerce.bookshop.model.Payment;
import it.ecommerce.bookshop.model.ShippingAddress;
import it.ecommerce.bookshop.model.ShoppingCart;
import it.ecommerce.bookshop.model.User;
import it.ecommerce.bookshop.repository.OrderRepository;
import it.ecommerce.bookshop.service.CartItemService;
import it.ecommerce.bookshop.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CartItemService cartItemService;

	@Override
	public synchronized Order addOrder(ShoppingCart shoppingCart, ShippingAddress shippingAddress, BillingAddress billingAddress,
			Payment payment, String shippingmethod, User user) {
		
		Order order = new Order();
		order.setBillingAddress(billingAddress);
		order.setOrderStatus("created");
		order.setPayment(payment);
		order.setShippingAddress(shippingAddress);
		order.setShippingMethod(shippingmethod);
		
		List<CartItem> cartItems = cartItemService.findByShoppingCart(shoppingCart);
		
		for (CartItem cartItem : cartItems) {
			Book book = cartItem.getBook();
			cartItem.setOrder(order);
			book.setInStockNumber(book.getInStockNumber() - cartItem.getQty());
		}
		
		order.setCartItems(cartItems);
		order.setOrderDate(Calendar.getInstance().getTime());
		order.setOrderTotal(shoppingCart.getGranTotal());
		
		shippingAddress.setOrder(order);
		
		billingAddress.setOrder(order);
		
		payment.setOrder(order);
		
		order.setUser(user);
		order = orderRepository.save(order);
		
		return order;
	}

	@Override
	public Order findOrderById(Long id) {
		
		return orderRepository.findById(id).orElse(null);
	}
}
