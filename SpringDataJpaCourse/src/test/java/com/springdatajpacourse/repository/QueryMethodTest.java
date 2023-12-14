package com.springdatajpacourse.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springdatajpacourse.entity.Product;

@SpringBootTest
public class QueryMethodTest {

	@Autowired
	private ProductRepository productRepository;
	
	//@Test
	void findByNameMethod() {
		Product product = productRepository.findByName("product 1");
		//System.out.println(product.getId());
		System.out.println(product);
	}
	
	//@Test 
	void findByIdMethod() {
		Optional<Product> product=productRepository.findById(15L);
		if(product.get().getId()!=null) {
			System.out.println(product);
		}
	}
	
	//@Test
	void findByNameOrDescription() {
		List<Product> productList= productRepository.findByNameOrDescription("product 5", "null");
		productList.forEach(System.out::println);
	}
	
	//@Test
	void findByNameAndDescription() {
		List<Product> productList= productRepository.findByNameAndDescription("product 5", "null");
		productList.forEach(System.out::println);
	}
	
	//@Test
	void findDistintcByName() {
		Product product = productRepository.findDistinctByName("product 1");
		System.out.println("Retrieved product is"+product);
	}
	

	//@Test
	void findByPriceGreaterThan() {
		List<Product> productList = productRepository.findByPriceGreaterThan(new BigDecimal(100));
		System.out.println("Retrieved product list for price greater than is");
		productList.forEach(System.out::println);
	}
	
	
	@Test
	void findByNameContaining() {
		List<Product> productList = productRepository.findByNameContaining("product");
		System.out.println("Productlist containing");
		productList.forEach(System.out::println);
	}
	
	@Test
	void findByNameIn() {
		List<Product> productList = productRepository.findByNameIn(List.of("product 1","product 5","product 6"));
		productList.forEach(System.out::println);
	}
}
