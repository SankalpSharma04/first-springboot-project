package com.example.springBoot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WelcomeService {

	@Value("${welcome.message}")
	private String msg;
	
	
	public String retrieveWelcomeMessage() {
		return msg;
		
	}
}