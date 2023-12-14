package com.springbootsearch.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springbootsearch.restapi.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {

	@Query("SELECT p from Product p where p.name LIKE CONCAT('%',:query,'%') Or p.description LIKE CONCAT('%',:query,'%')")
	public List<Product> searchProducts(@Param("query")String query);
	
	@Query(value="SELECT * from products p where p.name LIKE CONCAT('%',:query,'%') Or p.description LIKE CONCAT('%',:query,'%'",nativeQuery=true)
	public List<Product> searchProductsSql(String query);
}
