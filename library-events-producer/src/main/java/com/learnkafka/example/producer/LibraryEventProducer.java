package com.learnkafka.example.producer;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learnkafka.example.domain.libraryEvent;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LibraryEventProducer {

 KafkaTemplate<Integer,String> kafkaTemplate;

 ObjectMapper objectmapper;

@Value("${spring.kafka.topic}")
private String topic;
	
public LibraryEventProducer(KafkaTemplate<Integer,String> kafkaTemplate,ObjectMapper objectmapper)
{
		this.kafkaTemplate = kafkaTemplate;
		this.objectmapper = objectmapper;
}

//Asynchronous approach
public void sendLibraryEvent(libraryEvent libraryEvent) throws JsonProcessingException {
	var key = libraryEvent.libraryEventId();
	// objectmapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
	var value = objectmapper.writeValueAsString(libraryEvent);
	var completableFuture = kafkaTemplate.send(topic,key,value);
	completableFuture.whenComplete( (sendResult,throwable) -> {
		if(throwable!=null) {
			handleFailure(key,value,throwable);
			
		}else {
			handleSuccess(key,value, sendResult);
		}
		
	});
			
			
			
}

//Synchronous approach
public SendResult sendLibraryEvent_approach2(libraryEvent libraryEvent) throws JsonProcessingException, InterruptedException, ExecutionException, TimeoutException {
	var key = libraryEvent.libraryEventId();
	// objectmapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
	var value = objectmapper.writeValueAsString(libraryEvent);
	var sendResult = kafkaTemplate.send(topic,key,value).get(3, TimeUnit.SECONDS);
	handleSuccess(key,value, sendResult);
	return sendResult;			
}

//Approach3
public void sendLibraryEvent_approach3(libraryEvent libraryEvent) throws JsonProcessingException {
	var key = libraryEvent.libraryEventId();
	// objectmapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
	var value = objectmapper.writeValueAsString(libraryEvent);
	
	var ProducerRecord = buildProducerRecord(key,value);
	var completableFuture = kafkaTemplate.send(ProducerRecord);
	completableFuture.whenComplete( (sendResult,throwable) -> {
		if(throwable!=null) {
			handleFailure(key,value,throwable);
			
		}else {
			handleSuccess(key,value, sendResult);
		}
		
	});
			
			
			
}



private ProducerRecord<Integer, String> buildProducerRecord(Integer key, String value) {
	List<Header> recordHeaders = List.of(new RecordHeader("event-source","Scanner".getBytes()));
	return new ProducerRecord<>(topic,null,key,value,recordHeaders);
	
}

private void handleSuccess(Integer key, String value, SendResult<Integer, String> sendResult) {
log.info("Event Successfully published for given key {} , value {} with the partition {} is",key,value,sendResult.getRecordMetadata().partition());
	
}

private void handleFailure(Integer key, String value, Throwable throwable) {
	log.error("Execption is {} while publishing the event with the key {} and  value {} is ",throwable,key,value);
	
}
}
