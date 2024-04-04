package it.ecommerce.bookshop.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


/**
 * The persistent class for the books_to_cart database table.
 * 
 */
@Entity
@Table(name = "books_to_cart")
public class BookToCartItem implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_to_cart_id")
	private Long id;
	
	//bi-directional many-to-one association to Book
	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;
	
	//bi-directional many-to-one association to CartItem
	@ManyToOne
	@JoinColumn(name = "cart_item_id")
	private CartItem cartItem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public CartItem getCartItem() {
		return cartItem;
	}

	public void setCartItem(CartItem cartItem) {
		this.cartItem = cartItem;
	}

	@Override
	public String toString() {
		return "BookToCartItem [id=" + id + ", book=" + book + ", cartItem=" + cartItem + "]";
	}
}