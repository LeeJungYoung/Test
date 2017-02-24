package com.example;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.Home;

@RestController	
public class HomeController {

	// http://cusonar.tistory.com/2
	
	@RequestMapping("/{name}/{message}") 
	public Home home(
			@PathVariable String name,
			@PathVariable String message
			) {
		Home home = new Home();
		home.setName(name);
		home.setMessage(message);
		return home;
	}
}
