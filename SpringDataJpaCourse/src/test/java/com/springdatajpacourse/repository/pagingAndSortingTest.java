package com.springdatajpacourse.repository;

import java.util.List;

//import org.hibernate.mapping.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.springdatajpacourse.entity.Product;

@SpringBootTest
public class pagingAndSortingTest {
	@Autowired
	private ProductRepository productRepository;

	//@Test
	void pagination() {
		int pageNo = 0;
		int pageSize = 5;
		//create Pageable object
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		//findall method and pass pageable instance
		Page<Product> page = productRepository.findAll(pageable);
		List<Product> products = page.getContent();
		products.forEach(System.out::println);
		//total pages
		System.out.println("no of pages are"+page.getTotalPages());
		//total elemnts
		System.out.println(" Total no of elements are"+page.getTotalElements());
		//no of elments	
		System.out.println("No of elements are"+page.getNumberOfElements());
		//size
		System.out.println("size of pages are"+page.getSize());
		//last
		System.out.println("Is Last "+page.isLast());
		//first
		System.out.println("Is First "+page.isFirst());
	}
	
	//@Test
	void sorting() {
		String sortBy = "price";
		String sortDir = "desc";
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
		List<Product> products = productRepository.findAll(sort);
		System.out.println("Demo of Sorting");
		products.forEach(System.out::println);
		
	}
	
	//@Test
	void sortingByMultipleFields() {
		
		String sortByName = "name";
		String sortByDesc = "description";
		String sortDir = "desc";
		Sort sortByNamefield = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(sortByName).ascending():Sort.by(sortByName).descending();
		Sort sortByDescfield = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(sortByDesc).ascending():Sort.by(sortByDesc).descending();
		Sort groupBysort = sortByNamefield.and(sortByDescfield);
		List<Product> products = productRepository.findAll(groupBysort);
		products.forEach(System.out::println);
			
	}
	
	//Pageable and sorting
	@Test
	void TestPaginationAndSortingTogether() {
		System.out.println("Using Pagination and sorting");
		int pageNo = 0;
		int pageSize = 5;
		String sortByName = "name";
		String sortByDesc = "description";
		String sortDir = "desc";
		Sort sortByNamefield = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(sortByName).ascending():Sort.by(sortByName).descending();
		Sort sortByDescfield = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(sortByDesc).ascending():Sort.by(sortByDesc).descending();
		Sort groupBysort = sortByNamefield.and(sortByDescfield);
		Pageable pageable = PageRequest.of(pageNo, pageSize,groupBysort);
		Page<Product> page = productRepository.findAll(pageable);
		List<Product> products = page.getContent();
		products.forEach(System.out::println);
		//total pages
		System.out.println("no of pages are"+page.getTotalPages());
		//total elemnts
		System.out.println(" Total no of elements are"+page.getTotalElements());
		//no of elments	
		System.out.println("No of elements are"+page.getNumberOfElements());
		//size
		System.out.println("size of pages are"+page.getSize());
		//last
		System.out.println("Is Last "+page.isLast());
		//first
		System.out.println("Is First "+page.isFirst());
		
		
		
	}
	
}
