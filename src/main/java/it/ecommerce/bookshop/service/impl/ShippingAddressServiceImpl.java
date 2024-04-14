package it.ecommerce.bookshop.service.impl;

import org.springframework.stereotype.Service;

import it.ecommerce.bookshop.model.ShippingAddress;
import it.ecommerce.bookshop.model.UserShipping;
import it.ecommerce.bookshop.service.ShippingAddressService;

@Service
public class ShippingAddressServiceImpl implements ShippingAddressService {

	@Override
	public ShippingAddress setByUserShipping(UserShipping userShipping, ShippingAddress shippingAddress) {
		
		shippingAddress.setShippingAddressName(userShipping.getUserShippingName());
		shippingAddress.setShippingAddressStreet1(userShipping.getUserShippingStreet1());
		shippingAddress.setShippingAddressStreet2(userShipping.getUserShippingStreet2());
		shippingAddress.setShippingAddressCity(userShipping.getUserShippingCity());
		shippingAddress.setShippingAddressState(userShipping.getUserShippingState());
		shippingAddress.setShippingAddressCountry(userShipping.getUserShippingCountry());
		shippingAddress.setShippingAddressZipCode(userShipping.getUserShippingZipCode());
		
		return shippingAddress;
	}

}
