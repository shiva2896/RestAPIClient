package com.sample.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(value={ "com.sample"} )
public class ApplicationRest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 SpringApplication.run(ApplicationRest.class, args);
	}

	@Bean
	   public RestTemplate getRestTemplate() {
	      return new RestTemplate();
	   }
	
}
