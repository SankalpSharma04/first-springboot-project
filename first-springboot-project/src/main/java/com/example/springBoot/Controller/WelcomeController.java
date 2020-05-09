package com.example.springBoot.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springBoot.configuration.BasicConfiguration;
import com.example.springBoot.service.WelcomeService;

@RestController
public class WelcomeController {

	@Autowired
	WelcomeService welcomeService;
	@Autowired
	private BasicConfiguration basicConfiguration;

	@RequestMapping("/welcome")
	public String Hello() {
		return welcomeService.retrieveWelcomeMessage();
	}

	@RequestMapping("/hello")
	public Map welcome() {
Map map=new HashMap();
map.put("message", basicConfiguration.getMessage());
map.put("number", basicConfiguration.getNumber());
map.put("value", basicConfiguration.isValue());


		return map;
	}

}
