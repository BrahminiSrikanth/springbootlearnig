package com.brahmini.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
@EnableConfigServer
@SpringBootApplication
public class LibraryEventsConsumer1Application {

	public static void main(String[] args) {
		SpringApplication.run(LibraryEventsConsumer1Application.class, args);
	}

}
