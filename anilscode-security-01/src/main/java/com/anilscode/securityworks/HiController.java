package com.anilscode.securityworks;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {
	
	
	@GetMapping("/hi")
	public String sayHi() {
		return "Hi All";
	}
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello All";
	}
	
}
