package it.ecommerce.bookshop.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_shipping")
public class UserShipping implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_shipping_id")
	private int id;
	
	@Column(name = "user_shipping_name")
	private String userShippingName;
	
	@Column(name = "user_shipping_street_1")
	private String userShippingStreet1;
	
	@Column(name = "user_shipping_street_2")
	private String userShippingStreet2;
	
	@Column(name = "user_shipping_city")
	private String userShippingCity;
	
	@Column(name = "user_shipping_country")
	private String userShippingCountry;
	
	@Column(name = "user_shipping_zip_code")
	private String userShippingZipCode;
	
	@Column(name = "user_shipping_state")
	private String userShippingState;
	
	@Column(name = "user_shipping_default")
	private boolean userShippingDefault;
}