package it.ecommerce.bookshop.model;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart_items")
public class CartItem implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_item_id")
	private int id;
	
	private int qty;
	
	private BigDecimal subtotal;
	
	private Book book;
	
	private ShoppingCart shoppingCart;
	
	private Order order;

	public CartItem() {
		super();
	}

	public CartItem(int qty, BigDecimal subtotal, Book book, ShoppingCart shoppingCart, Order order) {
		super();
		this.qty = qty;
		this.subtotal = subtotal;
		this.book = book;
		this.shoppingCart = shoppingCart;
		this.order = order;
	}
}