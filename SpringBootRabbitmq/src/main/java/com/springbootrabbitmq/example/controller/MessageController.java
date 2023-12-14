package com.springbootrabbitmq.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springbootrabbitmq.example.publisher.RabbitMqProducer;

@RestController
@RequestMapping("/api/v1")
public class MessageController {
	
	private RabbitMqProducer producer;
	
	public MessageController(RabbitMqProducer producer) {
		this.producer = producer;
	}
	
	@GetMapping("/publish")
	public ResponseEntity sendMessage(@RequestParam("message") String message) {
		producer.sendMessage(message);
		return ResponseEntity.ok("Message Sent To rabbtMq");		
	}
	
	

}
