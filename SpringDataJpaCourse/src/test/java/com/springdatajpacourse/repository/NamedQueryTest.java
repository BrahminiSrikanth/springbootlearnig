package com.springdatajpacourse.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springdatajpacourse.entity.Product;

@SpringBootTest
public class NamedQueryTest {
	
	@Autowired
	private ProductRepository productRepository;
	
	//@Test
	void testNamedJpqlQuery() {
		Product product= productRepository.findByPrice("100.00");
		System.out.println("Named JPQL query is :"+product);
		
	}
	
	@Test
	void testNamednativeQuery() {
		Product product= productRepository.findByDescription("Test Product");
		System.out.println("Named Native query is :"+product);
		
	}

}
