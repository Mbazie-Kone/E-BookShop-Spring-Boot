package it.ecommerce.bookshop.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


/**
 * The persistent class for the billing_addresses database table.
 * 
 */
@Entity
@Table(name = "billing_addresses")
public class BillingAddress implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private int id;
	
	@Column(name = "address_name")
	private String addressName;
	
	@Column(name = "street_1")
	private String street1;
	
	@Column(name = "street_2")
	private String street2;
	
	private String city;
	
	private String country;
	
	private String state;
	
	@Column(name = "zip_code")
	private String zipCode;
	
	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="order_id")
	private Order order;
	
	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy = "billingAddress")
	private List<Order> orders;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public String getStreet1() {
		return street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setBillingAddress(this);
		
		return order;
	}
	
	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setBillingAddress(null);
		
		return order;
	}

	@Override
	public String toString() {
		return "BillingAddress [id=" + id + ", addressName=" + addressName + ", street1=" + street1 + ", street2="
				+ street2 + ", city=" + city + ", country=" + country + ", state=" + state + ", zipCode=" + zipCode
				+ ", order=" + order + ", orders=" + orders + "]";
	}
}