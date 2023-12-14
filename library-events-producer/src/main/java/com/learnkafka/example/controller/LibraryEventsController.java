package com.learnkafka.example.controller;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.learnkafka.example.domain.LibraryEventType;
import com.learnkafka.example.domain.libraryEvent;
import com.learnkafka.example.producer.LibraryEventProducer;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class LibraryEventsController {
	
 LibraryEventProducer libraryEventProducer;
	
	public LibraryEventsController(LibraryEventProducer libraryEventProducer) {
		this.libraryEventProducer = libraryEventProducer;
	}
	
	@PostMapping("/v1/libraryevent")
	public ResponseEntity<libraryEvent> postLibraryEvent(@RequestBody libraryEvent libraryEvent) throws JsonProcessingException, InterruptedException, ExecutionException, TimeoutException{
		
		//invoke kafka producer
		log.info("libraryEvent in controller call:{}", libraryEvent);
		//libraryEventProducer.sendLibraryEvent(libraryEvent);
		//libraryEventProducer.sendLibraryEvent_approach2(libraryEvent);
		libraryEventProducer.sendLibraryEvent_approach3(libraryEvent);
		log.info("After Publising libraryEvent:{}", libraryEvent);
		return ResponseEntity.status(HttpStatus.CREATED).body(libraryEvent);
		
	}
	

	@PutMapping("/v1/libraryevent")
	public ResponseEntity<?> putLibraryEvent(@Valid @RequestBody libraryEvent libraryEvent) throws JsonProcessingException, InterruptedException, ExecutionException, TimeoutException{
		
		//invoke kafka producer
		log.info("Put libraryEvent in controller call:{}", libraryEvent);
		 ResponseEntity<String> badrequest =validate(libraryEvent);
		 if(badrequest != null) {
			 return badrequest;
		 }
		libraryEventProducer.sendLibraryEvent_approach3(libraryEvent);
		log.info("After Publising Put libraryEvent:{}", libraryEvent);
		return ResponseEntity.status(HttpStatus.CREATED).body(libraryEvent);
		
	}

	private ResponseEntity<String> validate(libraryEvent libraryEvent) {
		if(libraryEvent.libraryEventId()==null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please Pass the Library EVent Id");
		}
		
		if(!libraryEvent.libraryEventType().equals(LibraryEventType.UPDATE)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Only Update EVent is Supported");
		}
		return null;
	}
}
