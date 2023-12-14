package com.springbootsearch.restapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springbootsearch.restapi.entity.Product;
import com.springbootsearch.restapi.repository.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductRepository productRepository;
	
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> searchProducts(String query) {
		//
		return productRepository.searchProducts(query);
	}

	@Override
	public Product createProduct(Product product) {
		
		return productRepository.save(product);
	}
	

}
