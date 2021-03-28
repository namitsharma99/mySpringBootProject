package com.example.mySpringBootProject.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MySpringBootService {

	private String message = "Hello from the inner service class!";
	
	@Value("${myVariables.name}")
	private String fromName;

	public String fetchMessage() {
		return message + " Designed by " + fromName;
	}

}
