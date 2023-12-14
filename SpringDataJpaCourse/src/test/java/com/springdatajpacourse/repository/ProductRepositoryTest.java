package com.springdatajpacourse.repository;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springdatajpacourse.entity.Product;

@SpringBootTest
public class ProductRepositoryTest {
	
	@Autowired
	private ProductRepository productRepository;
	
	//@Test
	void saveMthod() {
		
		//create product
		Product product = new Product();
	    product.setName("product 1");
	    product.setSku("100ABCS");
	    product.setPrice(new BigDecimal(100));
	    product.setActive(true);
	    product.setImageUrl("product1.png");
	    product.setDescription("Test Product");
	    //save product
	    Product savedObject = productRepository.save(product);
	    //display product info
	    System.out.println(savedObject.getId());
	    System.out.println(savedObject.toString());
	    
		
	}
	
	//@Test
	void updateUsingSaveMethod() {
		//find or retrieve an entity by id
		Product product = productRepository.findById((long) 1).get();
		//update product info
		product.setName("Updated Product 1");
		product.setDescription("Updated Product Description");
		//update an entity
		productRepository.save(product);
	}
	

	//@Test
	void findById() {
		Long id =1L;
		Product product= productRepository.findById(id).get();
		
	}
	
	@Test
	void saveAll() {
		Product product2 = new Product();
	    product2.setName("product 1");
	    product2.setSku("100ABC4");
	    product2.setPrice(new BigDecimal(110));
	    product2.setActive(true);
	    product2.setImageUrl("product1.png");
		product2.setDescription("product1 Description");
	    
	    Product product3 = new Product();
	    product3.setName("product 2");
	    product3.setSku("120ABDE");
	    product3.setPrice(new BigDecimal(120));
	    product3.setActive(true);
	    product3.setImageUrl("product2.png");
	    product3.setDescription("product2 Description");
	    productRepository.saveAll(List.of(product2,product3));
	    
	}
	
	//@Test
	void findall() {
		List<Product> productslist=productRepository.findAll();
		productslist.forEach(System.out::println);
	}
	
	//@Test
	void deleteById() {
		
	Long id =1L;
	productRepository.deleteById(id);
		
	}
	
	//@Test
	void deleteByEntity() {
			//find and entity by id
		Product product = productRepository.findById(3L).get();
		//delete
		productRepository.delete(product);
					
	}
	
	//@Test
	void deleteAll() {
		productRepository.deleteAll();
	}
	
	//@Test
	void deleteAllById() {
	List<Product> productList = productRepository.findAll();
	productRepository.deleteAll(productList);
	}
	
	//@Test
	void CountMethod() {
		Long count = productRepository.count();
		System.out.println("Count is :"+count);
	}
	
	//@Test
	void existByid() {
		boolean result = productRepository.existsById(15L);
		System.out.println(result);
		boolean result1 = productRepository.existsById(169L);
		System.out.println(result1);
	}
}
