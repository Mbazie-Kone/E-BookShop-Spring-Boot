package it.ecommerce.bookshop.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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
	
	private Order order;

	public ShippingAddress() {
		super();
	}

	public ShippingAddress(String shippingAddressName, String shippingAddressStreet1, String shippingAddressStreet2,
			String shippingAddressCity, String shippingAddressCountry, String shippingAddressState,
			String shippingAddressZipCode, Order order) {
		super();
		this.shippingAddressName = shippingAddressName;
		this.shippingAddressStreet1 = shippingAddressStreet1;
		this.shippingAddressStreet2 = shippingAddressStreet2;
		this.shippingAddressCity = shippingAddressCity;
		this.shippingAddressCountry = shippingAddressCountry;
		this.shippingAddressState = shippingAddressState;
		this.shippingAddressZipCode = shippingAddressZipCode;
		this.order = order;
	}
}