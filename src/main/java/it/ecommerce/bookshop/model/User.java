package it.ecommerce.bookshop.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import it.ecommerce.bookshop.model.security.UserRole;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import it.ecommerce.bookshop.model.security.*;

/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name = "users")
public class User implements UserDetails, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;
	
	@Column(name = "first_name")
	private String fistName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "username")
	private String userName;
	
	@Column(name = "password")
	private String passWord;
	
	private String email;
	
	private String phone;
	
	private boolean enabled = true;
	
	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Order> orders;
	
	//bi-directional many-to-one association to PasswordResetToken
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL)
	private List<PasswordResetToken> passwordResetTokens;
	
	//bi-directional many-to-one association to ShoppingCart
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<ShoppingCart> shoppingCarts;
	
	//bi-directional many-to-one association to UserPayment
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<UserPayment> userPayments;
	
	//bi-directional many-to-one association to UserRole
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	private List<UserRole> userRoles;
	
	//bi-directional many-to-one association to UserShipping
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<UserShipping> userShippings;
	
	//bi-directional many-to-one association to ShoppingCart
	@ManyToOne
	@JoinColumn(name = "shopping_cart_id")
	private ShoppingCart shoppingCart;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFistName() {
		return fistName;
	}

	public void setFistName(String fistName) {
		this.fistName = fistName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<ShoppingCart> getShoppingCarts() {
		return shoppingCarts;
	}

	public void setShoppingCarts(List<ShoppingCart> shoppingCarts) {
		this.shoppingCarts = shoppingCarts;
	}

	public List<UserPayment> getUserPayments() {
		return userPayments;
	}

	public void setUserPayments(List<UserPayment> userPayments) {
		this.userPayments = userPayments;
	}

	public List<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public List<UserShipping> getUserShippings() {
		return userShippings;
	}

	public void setUserShippings(List<UserShipping> userShippings) {
		this.userShippings = userShippings;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getPassWord() {
		return passWord;
	}
	
	public List<PasswordResetToken> getPasswordResetTokens() {
		return passwordResetTokens;
	}

	public void setPasswordResetTokens(List<PasswordResetToken> passwordResetTokens) {
		this.passwordResetTokens = passwordResetTokens;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setUser(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setUser(null);

		return order;
	}
	
	public ShoppingCart addShoppingCart(ShoppingCart shoppingCart) {
		getShoppingCarts().add(shoppingCart);
		shoppingCart.setUser(this);

		return shoppingCart;
	}

	public ShoppingCart removeShoppingCart(ShoppingCart shoppingCart) {
		getShoppingCarts().remove(shoppingCart);
		shoppingCart.setUser(null);

		return shoppingCart;
	}
	
	public UserPayment addUserPayment(UserPayment userPayment) {
		getUserPayments().add(userPayment);
		userPayment.setUser(this);

		return userPayment;
	}

	public UserPayment removeUserPayment(UserPayment userPayment) {
		getUserPayments().remove(userPayment);
		userPayment.setUser(null);

		return userPayment;
	}
	
	public UserRole addUserRole(UserRole userRole) {
		getUserRoles().add(userRole);
		userRole.setUser(this);

		return userRole;
	}

	public UserRole removeUserRole(UserRole userRole) {
		getUserRoles().remove(userRole);
		userRole.setUser(null);

		return userRole;
	}
	
	public UserShipping addUserShipping(UserShipping userShipping) {
		getUserShippings().add(userShipping);
		userShipping.setUser(this);

		return userShipping;
	}

	public UserShipping removeUserShipping(UserShipping userShipping) {
		getUserShippings().remove(userShipping);
		userShipping.setUser(null);

		return userShipping;
	}
	
	public PasswordResetToken addPasswordResetToken(PasswordResetToken passwordResetToken) {
		getPasswordResetTokens().add(passwordResetToken);
		passwordResetToken.setUser(this);

		return passwordResetToken;
	}

	public PasswordResetToken removePasswordResetToken(PasswordResetToken passwordResetToken) {
		getPasswordResetTokens().remove(passwordResetToken);
		passwordResetToken.setUser(null);

		return passwordResetToken;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> authorities = new HashSet<>();
		userRoles.forEach(ur -> authorities.add(new Authority(ur.getRole().getName())));
		
		return authorities ;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return null;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", fistName=" + fistName + ", lastName=" + lastName + ", userName=" + userName
				+ ", passWord=" + passWord + ", email=" + email + ", phone=" + phone + ", enabled=" + enabled + "]";
	}
}