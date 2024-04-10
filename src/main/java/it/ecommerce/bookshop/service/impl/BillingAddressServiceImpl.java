package it.ecommerce.bookshop.service.impl;


import org.springframework.beans.factory.annotation.Autowired;

import it.ecommerce.bookshop.model.BillingAddress;
import it.ecommerce.bookshop.model.UserBilling;
import it.ecommerce.bookshop.repository.BillingAddressRepository;
import it.ecommerce.bookshop.service.BillingAddressService;

public class BillingAddressServiceImpl implements BillingAddressService {
	
	@Autowired
	private BillingAddressRepository billingAddressRepository;

	@Override
	public BillingAddress setByUserBilling(BillingAddress billingAddress, UserBilling userBilling) {
		
		billingAddress.setAddressName(userBilling.getUserBillingName());
		billingAddress.setStreet1(userBilling.getUserBillingStreet1());
		billingAddress.setStreet2(userBilling.getUserBillingStreet2());
		billingAddress.setCity(userBilling.getUserBillingCity());
		billingAddress.setState(userBilling.getUserBillingState());
		billingAddress.setCountry(userBilling.getUserBillingCountry());
		billingAddress.setZipCode(userBilling.getUserBillingZipCode());
		
		BillingAddress b = billingAddressRepository.save(billingAddress);
		
		return b;
	}
}
