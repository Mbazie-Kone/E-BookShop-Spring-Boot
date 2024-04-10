package it.ecommerce.bookshop.service;


import org.springframework.stereotype.Service;

import it.ecommerce.bookshop.model.BillingAddress;
import it.ecommerce.bookshop.model.UserBilling;

@Service
public interface BillingAddressService {
	
	public BillingAddress setByUserBilling(BillingAddress billingAddress, UserBilling userBilling);
	
}