package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.Home;
import com.example.home.HomeMapper;

@RestController	
public class HomeController {
	
	@Autowired HomeMapper homeMapper;
	
	@RequestMapping("/{name}") 
	public Home home(
			@PathVariable String name
			) {
		Home home = homeMapper.readHome(name);
		return home;
	}
}
