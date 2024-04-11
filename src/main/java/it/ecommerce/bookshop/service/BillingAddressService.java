package it.ecommerce.bookshop.service;


import java.util.List;

import it.ecommerce.bookshop.model.BillingAddress;
import it.ecommerce.bookshop.model.UserBilling;

public interface BillingAddressService {
	
	public BillingAddress setByUserBilling(BillingAddress billingAddress, UserBilling userBilling);
	
	public BillingAddress addBillingAddress(BillingAddress billingAddress);
	
	public BillingAddress updateBillingAddress(BillingAddress billingAddress);
	
	public void deleteBillingAddress(BillingAddress billingAddress);
	
	public BillingAddress findByBillingAddressId(Long id);
	
	public List<BillingAddress> findAllBillingAddresses();
	
}