package it.ecommerce.bookshop.dto;

import lombok.NonNull;

public class PurchaseResponse {
	
	@NonNull
	private String orderTrackingNumber;

	public String getOrderTrackingNumber() {
		return orderTrackingNumber;
	}

	public void setOrderTrackingNumber(String orderTrackingNumber) {
		this.orderTrackingNumber = orderTrackingNumber;
	}

}