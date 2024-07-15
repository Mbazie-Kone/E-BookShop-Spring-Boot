package it.ecommerce.bookshop.dto;

import java.util.Objects;

public class PurchaseResponse {
	
	private String orderTrackingNumber;

	public String getOrderTrackingNumber() {
		return orderTrackingNumber;
	}

	public void setOrderTrackingNumber(String orderTrackingNumber) {
		this.orderTrackingNumber = orderTrackingNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderTrackingNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PurchaseResponse other = (PurchaseResponse) obj;
		return Objects.equals(orderTrackingNumber, other.orderTrackingNumber);
	}

	@Override
	public String toString() {
		return "PurchaseResponse [orderTrackingNumber=" + orderTrackingNumber + "]";
	}

}