package it.ecommerce.bookshop.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.ecommerce.bookshop.model.BillingAddress;
import it.ecommerce.bookshop.model.UserBilling;
import it.ecommerce.bookshop.repository.BillingAddressRepository;
import it.ecommerce.bookshop.service.BillingAddressService;

@Service
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
		
		return billingAddress;
		
	}

	@Override
	public BillingAddress addBillingAddress(BillingAddress billingAddress) {
		
		BillingAddress bAddress = billingAddressRepository.save(billingAddress);
		
		return bAddress;
	}

	@Override
	public BillingAddress updateBillingAddress(BillingAddress billingAddress) {
		
		BillingAddress bAddress = billingAddressRepository.save(billingAddress);
		
		return bAddress;
	}

	@Override
	public void deleteBillingAddress(BillingAddress billingAddress) {
		
		billingAddressRepository.delete(billingAddress);
	}

	@Override
	public BillingAddress findByBillingAddressId(Long id) {
		
		BillingAddress billingAddress = billingAddressRepository.findById(id).orElse(null);
		
		return billingAddress;
	}

	@Override
	public List<BillingAddress> findAllBillingAddresses() {
		
		List<BillingAddress> billingAddresses = billingAddressRepository.findAll();
		
		return billingAddresses;
	}
}
