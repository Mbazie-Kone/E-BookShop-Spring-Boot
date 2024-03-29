package it.ecommerce.bookshop.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "billing_addresses")
public class BillingAddress {
	
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
	
	public BillingAddress() {
		super();
	}

	public BillingAddress(String addressName, String street1, String street2, String city, String country, String state,
			String zipCode) {
		super();
		this.addressName = addressName;
		this.street1 = street1;
		this.street2 = street2;
		this.city = city;
		this.country = country;
		this.state = state;
		this.zipCode = zipCode;
	}

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

	@Override
	public String toString() {
		return "BillingAddress [id=" + id + ", addressName=" + addressName + ", street1=" + street1 + ", street2="
				+ street2 + ", city=" + city + ", country=" + country + ", state=" + state + ", zipCode=" + zipCode
				+ "]";
	}
}