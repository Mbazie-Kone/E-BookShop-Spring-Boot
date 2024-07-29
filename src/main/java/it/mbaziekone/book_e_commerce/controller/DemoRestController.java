package it.mbaziekone.book_e_commerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {
	
	@GetMapping("/demo")
	@ResponseBody
	public String demoRestController() {
		return "Hello PermitAll!";
	}
	
	@GetMapping("/denied")
	@ResponseBody
	public String deniedRestController() {
		return "Hello DeniedAll!";
	}
	
	@GetMapping("/authe")
	@ResponseBody
	public String autheRestController() {
		return "Hello Authe!";
	}
}
