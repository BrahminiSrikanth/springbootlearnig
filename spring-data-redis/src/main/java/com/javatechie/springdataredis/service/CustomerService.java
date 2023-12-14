package com.javatechie.springdataredis.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.javatechie.springdataredis.hash.Customer;
import com.javatechie.springdataredis.repository.CustomerDAO;
import com.javatechie.springdataredis.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerService {
	
	@Autowired
	private CustomerDAO customerDao;
	
	private static final String CACHE_NAME="customers";
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Cacheable(value=CACHE_NAME)
	public List<Customer> getAllCustomers(){
		//return customerDao.getAllCustomers();
		log.info("CustomerService::getAllCustomers() Fetching record from db");
		return StreamSupport.stream(customerRepository.findAll().spliterator(), false).collect(Collectors.toList());
	}
	
	@CachePut(key="#customer.id",value=CACHE_NAME)
	public Customer saveCustomer(Customer customer) {
		log.info("CustomerService::saveCustomer() Inserting record to db");
		return customerRepository.save(customer);
	}
	
	@Cacheable(key="#id",value=CACHE_NAME)
	public Customer getCustomer(int id) {
		//return customerDao.getCustomer(id);
		log.info("CustomerService::getCustomer() Fetching record from db");
		return customerRepository.findById(id).get();
	}
	
	@CachePut(key="#customer.id",value=CACHE_NAME)
	public Customer updateCustomer(int id, Customer customer) {
		//return customerDao.updateCustomer(id, customer);
		log.info("CustomerService::UpdateCustomer() Fetching record from db");
		Customer existingCustomer = customerRepository.findById(id).get();
		existingCustomer.setFirstName(customer.getFirstName());
		existingCustomer.setLastName(customer.getLastName());
		existingCustomer.setEmail(customer.getEmail());
		existingCustomer.setPhone(customer.getPhone());
		existingCustomer.setDob(customer.getDob());
		return customerRepository.save(existingCustomer);
	}
	
	@CacheEvict(key="#id",value=CACHE_NAME)
	public String deleteCustomer(int id) {
		//return customerDao.deletCustomer(id);
		log.info("CustomerService::deleteustomer()  record from db");
		 customerRepository.deleteById(id);
		 return "customer removed";
	}
	
	

}
