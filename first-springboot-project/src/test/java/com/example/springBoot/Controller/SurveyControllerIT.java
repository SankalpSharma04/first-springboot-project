package com.example.springBoot.Controller;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.example.springBoot.Application;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class, webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
class SurveyControllerIT {

	@LocalServerPort
	private int port;
	

	
	@Test
	void test() {
		/* fail("Not yet implemented"); */
		String url="http://localhost:" +port
				+"/surveys/Survey1/question/Question1";
		
		TestRestTemplate trest=new TestRestTemplate();
		//String output=trest.getForObject(url, String.class);
		
		HttpHeaders header=new HttpHeaders();
		//header.setAccept(MediaType.APPLICATION_JSON));
		
		HttpEntity entity=new HttpEntity<String>(null,header);
		
	ResponseEntity<String> response=trest.exchange(url, HttpMethod.GET, entity, String.class);
		
		System.out.println("port"+ response);
		
		
	}

}
