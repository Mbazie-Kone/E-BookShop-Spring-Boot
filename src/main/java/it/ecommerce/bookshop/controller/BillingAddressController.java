package it.ecommerce.bookshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import it.ecommerce.bookshop.service.BillingAddressService;


@Controller
@RequestMapping("/billing_address")
public class BillingAddressController {
	
	@Autowired
	BillingAddressService billingAddressService;
	
	
	
}