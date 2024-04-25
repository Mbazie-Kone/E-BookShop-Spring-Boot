package it.ecommerce.bookshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	
	@GetMapping("/demoDemo")
	public String demoDemo() {
		
		return "demo";
	}
}
