package com.tutorial.springboot.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.springboot.security.config.BasicWelcomeMessgaeProvider;

@RestController
public class WelcomeController {
	
	@Value("${welcome.message}")
	public String welcomeMessage;
	
	@Autowired
	private BasicWelcomeMessgaeProvider msgProvide;

	@GetMapping("/")
	public String welcome(){
		return welcomeMessage;
	}
	
	@GetMapping("/user")
	public String welcomeUser(){
		return msgProvide.getUserMessage();
	}
	
	@GetMapping("/admin")
	public String welcomeAdmin(){
		return msgProvide.getAdminMessage();
	}
}
