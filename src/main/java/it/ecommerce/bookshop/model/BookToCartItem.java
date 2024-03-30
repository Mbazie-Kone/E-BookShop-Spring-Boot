package it.ecommerce.bookshop.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books_to_cart")
public class BookToCartItem implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_to_cart_id")
	private int id;
	
	private Book book;
	
	private CartItem cartItem;

	public BookToCartItem() {
		super();
	}

	public BookToCartItem(Book book, CartItem cartItem) {
		super();
		this.book = book;
		this.cartItem = cartItem;
	}
}