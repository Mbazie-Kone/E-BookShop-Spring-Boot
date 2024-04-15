package it.ecommerce.bookshop.service;


import it.ecommerce.bookshop.model.BillingAddress;
import it.ecommerce.bookshop.model.UserBilling;

public interface BillingAddressService {
	
	public BillingAddress setByUserBilling(UserBilling userBilling,BillingAddress billingAddress);
	
}