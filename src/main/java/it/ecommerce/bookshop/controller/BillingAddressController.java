package it.ecommerce.bookshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import it.ecommerce.bookshop.model.BillingAddress;
import it.ecommerce.bookshop.service.BillingAddressService;

@Controller
@RequestMapping("/billing")
public class BillingAddressController {
	
	@Autowired
	private BillingAddressService billingAddressService;
	
	@GetMapping("/")
	@ResponseBody
	public List<BillingAddress> prova() {
		
		return billingAddressService.getAdresses() ;
	}
}