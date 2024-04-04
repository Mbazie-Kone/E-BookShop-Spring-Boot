package it.ecommerce.bookshop.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


/**
 * The persistent class for the orders database table.
 * 
 */
@Entity
@Table(name = "orders")
public class Order implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Long id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "order_date")
	private Date orderDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "shipping_date")
	private Date shippingDate;
	
	@Column(name = "shipping_method")
	private String shippingMethod;
	
	@Column(name = "order_status")
	private String orderStatus;
	
	@Column(name = "order_total")
	private BigDecimal orderTotal;
	
	//bi-directional many-to-one association to BillingAddress
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<BillingAddress> billingAddresses;
	
	//bi-directional many-to-one association to CartItem
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<CartItem> cartItems;
	
	//bi-directional many-to-one association to BillingAddress
	@ManyToOne
	@JoinColumn(name = "billing_address_id")
	private BillingAddress billingAddress;
	
	//bi-directional many-to-one association to Payment
	@ManyToOne
	@JoinColumn(name = "payment_id")
	private Payment payment;
	
	//bi-directional many-to-one association to ShippingAddres
	@ManyToOne
	@JoinColumn(name = "shipping_address_id")
	private ShippingAddress shippingAddress;
	
	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	//bi-directional many-to-one association to Payment
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<Payment> payments;
	
	//bi-directional many-to-one association to ShippingAddress
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<ShippingAddress> shippingAddresses;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getShippingDate() {
		return shippingDate;
	}

	public void setShippingDate(Date shippingDate) {
		this.shippingDate = shippingDate;
	}

	public String getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public BigDecimal getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(BigDecimal orderTotal) {
		this.orderTotal = orderTotal;
	}

	public List<BillingAddress> getBillingAddresses() {
		return billingAddresses;
	}

	public void setBillingAddresses(List<BillingAddress> billingAddresses) {
		this.billingAddresses = billingAddresses;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public List<ShippingAddress> getShippingAddresses() {
		return shippingAddresses;
	}

	public void setShippingAddresses(List<ShippingAddress> shippingAddresses) {
		this.shippingAddresses = shippingAddresses;
	}
	
	public BillingAddress addBillingAddress(BillingAddress billingAddress) {
		getBillingAddresses().add(billingAddress);
		billingAddress.setOrder(this);

		return billingAddress;
	}

	public BillingAddress removeBillingAddress(BillingAddress billingAddress) {
		getBillingAddresses().remove(billingAddress);
		billingAddress.setOrder(null);

		return billingAddress;
	}
	
	public ShippingAddress addShippingAddress(ShippingAddress shippingAddress) {
		getShippingAddresses().add(shippingAddress);
		shippingAddress.setOrder(this);

		return shippingAddress;
	}

	public ShippingAddress removeShippingAddress(ShippingAddress shippingAddress) {
		getShippingAddresses().remove(shippingAddress);
		shippingAddress.setOrder(null);

		return shippingAddress;
	}
	
	public CartItem addCartItem(CartItem cartItem) {
		getCartItems().add(cartItem);
		cartItem.setOrder(this);

		return cartItem;
	}

	public CartItem removeCartItem(CartItem cartItem) {
		getCartItems().remove(cartItem);
		cartItem.setOrder(null);

		return cartItem;
	}
	
	public Payment addPayment(Payment payment) {
		getPayments().add(payment);
		payment.setOrder(this);

		return payment;
	}

	public Payment removePayment(Payment payment) {
		getPayments().remove(payment);
		payment.setOrder(null);

		return payment;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderDate=" + orderDate + ", shippingDate=" + shippingDate + ", shippingMethod="
				+ shippingMethod + ", orderStatus=" + orderStatus + ", orderTotal=" + orderTotal + ", billingAddresses="
				+ billingAddresses + ", cartItemts=" + cartItems + ", billingAddress=" + billingAddress + ", payment="
				+ payment + ", shippingAddress=" + shippingAddress + ", user=" + user + ", payments=" + payments
				+ ", shippingAddresses=" + shippingAddresses + "]";
	}
}