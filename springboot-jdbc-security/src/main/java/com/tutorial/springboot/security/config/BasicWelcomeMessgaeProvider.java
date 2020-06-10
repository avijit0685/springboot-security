package com.tutorial.springboot.security.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("welcome")
public class BasicWelcomeMessgaeProvider {

	private String message;
	private String userMessage;
	private String adminMessage;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUserMessage() {
		return userMessage;
	}
	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}
	public String getAdminMessage() {
		return adminMessage;
	}
	public void setAdminMessage(String adminMessage) {
		this.adminMessage = adminMessage;
	}
	
}
