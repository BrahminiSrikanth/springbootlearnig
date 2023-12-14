package com.springbootrabbitmq.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootrabbitmq.example.dto.User;
import com.springbootrabbitmq.example.publisher.RabbitMqJsonProducer;

@RestController
@RequestMapping("/api/v1")
public class MessageJsonController {
	
	private RabbitMqJsonProducer jsonProducer;
	
	public MessageJsonController(RabbitMqJsonProducer jsonProducer) {
		this.jsonProducer=jsonProducer;
	}
	
	@PostMapping("/publish")
	public ResponseEntity<String> sendJsonMessage(@RequestBody User user){
		jsonProducer.senJsonMessage(user);
		return ResponseEntity.ok("Json message sent to rabbitMq....");
	}

}
