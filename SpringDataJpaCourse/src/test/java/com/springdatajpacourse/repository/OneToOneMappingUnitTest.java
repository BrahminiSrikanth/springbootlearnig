package com.springdatajpacourse.repository;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springdatajpacourse.entity.Address;
import com.springdatajpacourse.entity.Order;

@SpringBootTest
public class OneToOneMappingUnitTest {

	@Autowired
	private OrderRepository orderRepository;
	
	@Test
	public void saveOrderMethod() {
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
		
		orderRepository.save(order);
	}
	
	//@Test
	public void updateOrderMethod() {
		Order order= orderRepository.findById(1L).get();
		order.setStatus("DELIVERED");
		order.getBillingAddress().setZipCode("411087");
		orderRepository.save(order);
	}
	
	//@Test
	public void deleteOrderMethod() {
		orderRepository.deleteById(1L);
	}
	
	@Test
	public void getOrderMetod() {
		Order order = orderRepository.findById(2L).get();
		System.out.println(order.toString());
	}
}
