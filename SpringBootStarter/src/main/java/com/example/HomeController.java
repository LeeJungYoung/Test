package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController	
public class HomeController {

	// http://cusonar.tistory.com/2
	
	@RequestMapping("/") 
	public String home() {
		return "Hello World";
	}
}
