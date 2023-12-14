package com.javatechie.springdataredis.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.javatechie.springdataredis.hash.Customer;

@Repository
public class CustomerDAO {

	@Autowired
	private RedisTemplate template;
	
	private static final String HASH_KEY="Customer";
	public Customer addCustomer(Customer customer) {
		template.opsForHash().put(HASH_KEY, customer.getId(), customer);
		return customer;
		
	}
	
	public List<Customer> getAllCustomers(){
		return template.opsForHash().values(HASH_KEY);
	}
	
	public Customer getCustomer(int id) {
		return (Customer) template.opsForHash().get(HASH_KEY, id);
	}
	
	public String deletCustomer(int id) {
		template.opsForHash().delete(HASH_KEY, id);
		return "Customer "+id+"has been removed from system!";
	}
	
	public Customer updateCustomer(int id, Customer customer) {
		Customer existingCustomer = (Customer) template.opsForHash().get(HASH_KEY, id);
		if(existingCustomer != null) {
			existingCustomer.setFirstName(customer.getFirstName());
			existingCustomer.setLastName(customer.getLastName());
			existingCustomer.setEmail(customer.getEmail());
			existingCustomer.setPhone(customer.getPhone());
			existingCustomer.setDob(customer.getDob());
			template.opsForHash().put(HASH_KEY,id, existingCustomer);
			return existingCustomer;
		}else {
			throw new RuntimeException("Customer not Found!");
		}
		
	}
}
