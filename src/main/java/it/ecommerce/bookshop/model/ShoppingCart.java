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
 * The persistent class for the shopping_carts database table.
 * 
 */
@Entity
@Table(name = "shopping_carts")
public class ShoppingCart implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "shopping_cart_id")
	private int id;
	
	@Column(name = "grand_total")
	private BigDecimal granTotal;
	
	//bi-directional many-to-one association to CartItem
	@OneToMany(mappedBy = "shoppingCart")
	private List<CartItem> cartItems;
	
	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	//bi-directional many-to-one association to User
	@OneToMany(mappedBy = "shoppingCart")
	private List<User> users;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getGranTotal() {
		return granTotal;
	}

	public void setGranTotal(BigDecimal granTotal) {
		this.granTotal = granTotal;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public CartItem addCartItem(CartItem cartItem) {
		getCartItems().add(cartItem);
		cartItem.setShoppingCart(this);

		return cartItem;
	}

	public CartItem removeCartItem(CartItem cartItem) {
		getCartItems().remove(cartItem);
		cartItem.setShoppingCart(null);

		return cartItem;
	}
	
	public User addUser(User user) {
		getUsers().add(user);
		user.setShoppingCart(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setShoppingCart(null);

		return user;
	}

	@Override
	public String toString() {
		return "ShoppingCart [id=" + id + ", granTotal=" + granTotal + ", cartItems=" + cartItems + ", user=" + user
				+ ", users=" + users + "]";
	}
}