package it.mbaziekone.book_e_commerce.model.dto;

import java.util.Objects;
import java.util.Set;

import it.mbaziekone.book_e_commerce.model.Address;
import it.mbaziekone.book_e_commerce.model.Customer;
import it.mbaziekone.book_e_commerce.model.Order;
import it.mbaziekone.book_e_commerce.model.OrderItem;

public class Purchase {
	
private Customer customer;
	
	private Address shippingAddress;
	
	private Address billingAddress;
	
	private Order order;
	
	private Set<OrderItem> orderItems;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public int hashCode() {
		return Objects.hash(billingAddress, customer, order, orderItems, shippingAddress);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Purchase other = (Purchase) obj;
		return Objects.equals(billingAddress, other.billingAddress) && Objects.equals(customer, other.customer)
				&& Objects.equals(order, other.order) && Objects.equals(orderItems, other.orderItems)
				&& Objects.equals(shippingAddress, other.shippingAddress);
	}

	@Override
	public String toString() {
		return "Purchase [customer=" + customer + ", shippingAddress=" + shippingAddress + ", billingAddress="
				+ billingAddress + ", order=" + order + ", orderItems=" + orderItems + "]";
	}
}
