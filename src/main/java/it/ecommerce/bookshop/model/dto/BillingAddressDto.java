package it.ecommerce.bookshop.model.dto;

import jakarta.validation.constraints.NotEmpty;

public class BillingAddressDto {
	
	@NotEmpty(message = "The address name is required")
	private String addressName;
	
	@NotEmpty(message = "The street is required")
	private String street1;
	
	private String street2;
	
	@NotEmpty(message = "The city is required")
	private String city;
	
	@NotEmpty(message = "The country is required")
	private String country;
	
	@NotEmpty(message = "The state is required")
	private String state;
	
	@NotEmpty(message = "The zip code is required")
	private String zipCode;

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
}