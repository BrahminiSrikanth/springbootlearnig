package com.springdatajpacourse.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springdatajpacourse.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
	//retruns found product entry by name as seacrch criteria,if name not found returns null
	public Product findByName(String name);
	
	public Optional<Product> findById(Long id);
	
	List<Product> findByNameOrDescription(String name, String description);
	
	List<Product> findByNameAndDescription(String name, String description);
	
	//Distinct example
	//rerturns distinct prodcut entry, if no product entry is found retrun null
	Product findDistinctByName(String name);
	
	//GreaterThan
	
	List<Product> findByPriceGreaterThan(BigDecimal price);
	
	
	//Containing
	List<Product> findByNameContaining(String name);
	
	//In
	
	List<Product> findByNameIn(List<String> names);
	
	//Define JPQL Query using @Query annotation with indexed or position paramters
	@Query("SELECT p from Product p where p.name = ?1 or p.description = ?2")
	Product findByNameOrDescriptionJPQLIndexparam(String name, String description);

	@Query("SELECT p from Product p where p.name=:name or p.description=:description")
	Product findBYNameOrDescriptionUsingNamedParam(@Param("name")String name, @Param("description")String description);

	//Define Native Sql Query using Find By name or description
	@Query(value=" select * from products p where p.name=? or p.description=?",nativeQuery=true)
	Product findByNameOrDescriptionNativeSqlQuery(String name, String description);
	

	//Define Native Sql Query using Find By name or description params
	@Query(value=" select * from products p where p.name=:name or p.description=:description",nativeQuery=true)
	Product findByNameOrDescriptionParamsNativeSqlQuery(@Param("name")String name, @Param("description")String description);

	//Define Named Queries
	
	Product findByPrice(@Param("price")String price);
	
	//Define Named Native Sql Query
	@Query(nativeQuery = true)
	Product findByDescription(@Param("description")String description);
}
