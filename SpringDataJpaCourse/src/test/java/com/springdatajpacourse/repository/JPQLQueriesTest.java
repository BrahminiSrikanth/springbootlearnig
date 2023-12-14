package com.springdatajpacourse.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springdatajpacourse.entity.Product;

@SpringBootTest
public class JPQLQueriesTest {
	
	@Autowired
	private ProductRepository productRepository;
	
	//@Test
	void testJpqlQueryByNameOrDescription() {
		
		Product product = productRepository.findByNameOrDescriptionJPQLIndexparam("product 1","Test Product");
		System.out.println("Retireved product by using JPQL query is"+product);
	}
	
	//@Test
	void testJpqlQueryByNameOrDescriptionusingNameParam() {
		
		Product product = productRepository.findBYNameOrDescriptionUsingNamedParam("product 1","Test Product");
		System.out.println("Retireved product by using JPQL query is"+product);
	}
	
	//@Test
	void testNativeSqlQuery() {
		Product product = productRepository.findByNameOrDescriptionNativeSqlQuery("product 1", "Test Product");
		System.out.println("Retireved product by using Native sql query is"+product);
	}
	
	@Test
	void testNativeSqlQueryusingnamedParams() {
		Product product = productRepository.findByNameOrDescriptionParamsNativeSqlQuery("product 1", "Test Product");
		System.out.println("Retireved product by using Native sql query is"+product);
	}

}
