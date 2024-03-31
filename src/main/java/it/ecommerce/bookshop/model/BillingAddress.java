package it.ecommerce.bookshop.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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
	
}