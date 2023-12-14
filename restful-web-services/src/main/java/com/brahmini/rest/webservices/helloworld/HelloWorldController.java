package com.brahmini.rest.webservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@GetMapping(path="hello-world/path-variable/{name}")
	public HelloWorldBean HelloWorld(@PathVariable String name) {
	//	return new HelloWorldBean("Hell World "+name);
		return new HelloWorldBean(String.format(" HelloWorld %s", name));
	}

}
