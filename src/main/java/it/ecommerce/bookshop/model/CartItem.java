package it.ecommerce.bookshop.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * The persistent class for the cart_items database table.
 * 
 */
@Entity
@Table(name = "cart_items")
public class CartItem implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_item_id")
	private Long id;
	
	private int qty;
	
	private BigDecimal subtotal;
	
	@OneToOne
	private Book book;
	
	@OneToMany(mappedBy = "cartItem")
	@JsonIgnore
	private List<BookToCartItem> bookToCartItems;
	
	@ManyToOne
	@JoinColumn(name = "shopping_cart_id")
	private ShoppingCart shoppingCart;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public List<BookToCartItem> getBookToCartItems() {
		return bookToCartItems;
	}

	public void setBookToCartItems(List<BookToCartItem> bookToCartItems) {
		this.bookToCartItems = bookToCartItems;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "CartItem [id=" + id + ", qty=" + qty + ", subtotal=" + subtotal + ", book=" + book
				+ ", bookToCartItems=" + bookToCartItems + ", shoppingCart=" + shoppingCart + ", order=" + order + "]";
	}
}