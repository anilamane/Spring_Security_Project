package com.anilscode.securityworks;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ByeController {
	
	@GetMapping("/bye")
	public String syaBye() {
		return "Bye All !";
	}

}
