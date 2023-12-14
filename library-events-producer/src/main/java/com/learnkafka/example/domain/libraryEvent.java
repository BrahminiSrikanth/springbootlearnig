package com.learnkafka.example.domain;

public record libraryEvent( 
	
	Integer libraryEventId,
	LibraryEventType libraryEventType,
	Book book
) {
	
}

