package com.example.spring.security.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldResource {

	@GetMapping("/helloworld")
	public String helloWorld() {
		return "Hello World";
	}
}
