package com.sample.controller;

import java.util.Arrays;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sample.dao.Request;
import com.sample.dao.Response;

@RestController
@RequestMapping("/SimpleRestTemp")
public class Controller {

	@Autowired
	 RestTemplate restTemplate;
	
	@PostMapping(value = "/SimpleRestService", consumes = MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<?>  simpleResponse(@RequestBody Request requestJson) {
		 HttpHeaders headers = new HttpHeaders();
		 //RestTemplate restTemplate = new RestTemplate();
		 headers.setContentType(MediaType.APPLICATION_JSON);
		 String user = "shiva";
		 String password = "Shivassy@28";
		 String notEncoded = user + ":" + password;
		 String encodedAuth = Base64.getEncoder().encodeToString(notEncoded.getBytes());
		 System.out.println("Cread"+encodedAuth);
		 headers.add("Authorization", "Basic " + encodedAuth);
		 HttpEntity<Request> entity = new HttpEntity<Request>(requestJson,headers);
		 String url ="http://localhost:8091/SimplePostAPI/SimpleService";
		 ResponseEntity<Response> response = restTemplate.exchange(url, HttpMethod.POST, entity, Response.class);
		System.out.println("Successfully fetched from API");
	  return response;
	  
	  }
	 
}
