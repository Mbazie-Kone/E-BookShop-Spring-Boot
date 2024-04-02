package it.ecommerce.bookshop.model;

import java.io.Serializable;
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
 * The persistent class for the shipping_addresses database table.
 * 
 */
@Entity
@Table(name = "shipping_addresses")
public class ShippingAddress implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "shipping_address_id")
	private int id;
	
	@Column(name = "shipping_address_name")
	private String shippingAddressName;
	
	@Column(name = "shipping_address_street_1")
	private String shippingAddressStreet1;
	
	@Column(name = "shipping_address_street_2")
	private String shippingAddressStreet2;
	
	@Column(name = "shipping_address_city")
	private String shippingAddressCity;
	
	@Column(name = "shipping_address_country")
	private String shippingAddressCountry;
	
	@Column(name = "shipping_address_state")
	private String shippingAddressState;
	
	@Column(name = "shipping_address_zip_code")
	private String shippingAddressZipCode;
	
	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy = "shippingAddress")
	private List<Order> orders;
	
	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShippingAddressName() {
		return shippingAddressName;
	}

	public void setShippingAddressName(String shippingAddressName) {
		this.shippingAddressName = shippingAddressName;
	}

	public String getShippingAddressStreet1() {
		return shippingAddressStreet1;
	}

	public void setShippingAddressStreet1(String shippingAddressStreet1) {
		this.shippingAddressStreet1 = shippingAddressStreet1;
	}

	public String getShippingAddressStreet2() {
		return shippingAddressStreet2;
	}

	public void setShippingAddressStreet2(String shippingAddressStreet2) {
		this.shippingAddressStreet2 = shippingAddressStreet2;
	}

	public String getShippingAddressCity() {
		return shippingAddressCity;
	}

	public void setShippingAddressCity(String shippingAddressCity) {
		this.shippingAddressCity = shippingAddressCity;
	}

	public String getShippingAddressCountry() {
		return shippingAddressCountry;
	}

	public void setShippingAddressCountry(String shippingAddressCountry) {
		this.shippingAddressCountry = shippingAddressCountry;
	}

	public String getShippingAddressState() {
		return shippingAddressState;
	}

	public void setShippingAddressState(String shippingAddressState) {
		this.shippingAddressState = shippingAddressState;
	}

	public String getShippingAddressZipCode() {
		return shippingAddressZipCode;
	}

	public void setShippingAddressZipCode(String shippingAddressZipCode) {
		this.shippingAddressZipCode = shippingAddressZipCode;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setShippingAddress(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setShippingAddress(null);

		return order;
	}

	@Override
	public String toString() {
		return "ShippingAddress [id=" + id + ", shippingAddressName=" + shippingAddressName
				+ ", shippingAddressStreet1=" + shippingAddressStreet1 + ", shippingAddressStreet2="
				+ shippingAddressStreet2 + ", shippingAddressCity=" + shippingAddressCity + ", shippingAddressCountry="
				+ shippingAddressCountry + ", shippingAddressState=" + shippingAddressState
				+ ", shippingAddressZipCode=" + shippingAddressZipCode + ", orders=" + orders + ", order=" + order
				+ "]";
	}
}