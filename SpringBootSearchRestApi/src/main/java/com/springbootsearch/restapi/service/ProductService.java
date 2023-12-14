package com.springbootsearch.restapi.service;

import java.util.List;

import com.springbootsearch.restapi.entity.Product;

public interface ProductService {
	List<Product> searchProducts(String query);
	Product createProduct(Product product);

}
