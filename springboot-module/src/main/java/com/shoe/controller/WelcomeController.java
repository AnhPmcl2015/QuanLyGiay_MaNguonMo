package com.shoe.controller;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";

}