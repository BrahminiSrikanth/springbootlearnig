package com.springdatajpacourse.repository;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springdatajpacourse.entity.Address;
import com.springdatajpacourse.entity.Order;

@SpringBootTest
public class OneoOneBidirectionalMappingTest {
	
	@Autowired
	private AddressRepository addressRespository;
	
	//@Test
	public void saveAddressMethod() {
		Order order = new Order();
		order.setOrderTrackingNumber("1000ABC");
		order.setTotalQunatity(5);
		order.setTotalPrice(new BigDecimal(1000));
		order.setStatus("IN PROGRESS");
		
		Address address = new Address();
		address.setCity("Pune");
		address.setState("Maharastra");
		address.setStreet("Kothrud");
		address.setZipCode("411047");
		address.setCountry("India");
		
		order.setBillingAddress(address);
		address.setOrder(order);
		addressRespository.save(address);
	}
	
	    @Test
		public void updateOrderMethod() {
	    	Address address = addressRespository.findById(1L).get();
	    	address.setZipCode("411048");
	    	address.getOrder().setStatus("DELIVERED");
	    	addressRespository.save(address);

		}
		

}
