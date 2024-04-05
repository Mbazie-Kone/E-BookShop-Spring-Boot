package it.ecommerce.bookshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.ecommerce.bookshop.model.BillingAddress;
import it.ecommerce.bookshop.repository.BillingAddressRepository;

@Service
public class BillingAddressService {
	
	@Autowired
	private BillingAddressRepository billingAddressRepository;
	
	public List<BillingAddress> getAdresses() {
		
		return (List<BillingAddress>) billingAddressRepository.findAll();
	}
	
}