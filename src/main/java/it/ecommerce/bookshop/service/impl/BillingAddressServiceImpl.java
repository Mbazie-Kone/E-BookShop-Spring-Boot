package it.ecommerce.bookshop.service.impl;

import org.springframework.stereotype.Service;

import it.ecommerce.bookshop.model.BillingAddress;
import it.ecommerce.bookshop.model.UserBilling;
import it.ecommerce.bookshop.service.BillingAddressService;

@Service
public class BillingAddressServiceImpl implements BillingAddressService {

	@Override
	public BillingAddress setByUserBilling(BillingAddress billingAddress, UserBilling userBilling) {
		
		billingAddress.setAddressName(userBilling.getUserBillingName());
		billingAddress.setStreet1(userBilling.getUserBillingStreet1());
		billingAddress.setStreet2(userBilling.getUserBillingStreet2());
		billingAddress.setCity(userBilling.getUserBillingCity());
		billingAddress.setState(userBilling.getUserBillingState());
		billingAddress.setCountry(userBilling.getUserBillingCountry());
		billingAddress.setZipCode(userBilling.getUserBillingZipCode());
		
		return billingAddress;
		
	}
}
