package it.ecommerce.bookshop.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	private int id;
	
	private int qty;
	
	private BigDecimal subtotal;
	
	//bi-directional many-to-one association to BookToCartItem
	@OneToMany(mappedBy = "cartItem")
	private List<BookToCartItem> bookToCartItems;
	
	//bi-directional many-to-one association to Book
	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;
	
	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
	//bi-directional many-to-one association to ShoppingCart
	@ManyToOne
	@JoinColumn(name = "shopping_cart_id")
	private ShoppingCart shoppingCart;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public List<BookToCartItem> getBookToCartItems() {
		return bookToCartItems;
	}

	public void setBookToCartItems(List<BookToCartItem> bookToCartItems) {
		this.bookToCartItems = bookToCartItems;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	
	public BookToCartItem addBookToCartItem(BookToCartItem bookToCartItem) {
		getBookToCartItems().add(bookToCartItem);
		bookToCartItem.setCartItem(this);

		return bookToCartItem;
	}

	public BookToCartItem removeBookToCartItem(BookToCartItem bookToCartItem) {
		getBookToCartItems().remove(bookToCartItem);
		bookToCartItem.setCartItem(null);

		return bookToCartItem;
	}

	@Override
	public String toString() {
		return "CartItem [id=" + id + ", qty=" + qty + ", subtotal=" + subtotal + ", bookToCartItems=" + bookToCartItems
				+ ", book=" + book + ", order=" + order + ", shoppingCart=" + shoppingCart + "]";
	}
}