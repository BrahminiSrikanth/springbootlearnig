package com.springdatajpacourse.repository;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springdatajpacourse.entity.Address;
import com.springdatajpacourse.entity.Order;
import com.springdatajpacourse.entity.OrderItem;

@SpringBootTest
public class OneToManyMappingTest {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	//save order along with orderitms
	
	@Test
	public void saveOrderOneToMany() {
	
		Order order = new Order();
		order.setOrderTrackingNumber("100ABC");
		order.setStatus("In Progress");
		
		//create order item1
		OrderItem orderItem1 = new OrderItem();
		orderItem1.setProduct(productRepository.findById(4L).get());
		orderItem1.setQuantity(2);
		orderItem1.setPrice(orderItem1.getProduct().getPrice().multiply(new BigDecimal(2)));
		orderItem1.setImageUrl("image1.png");
		order.getOrderitems().add(orderItem1);
		
		//create orderitem2
		
		OrderItem orderItem2 = new OrderItem();
		orderItem2.setProduct(productRepository.findById(2L).get());
		orderItem2.setQuantity(2);
		orderItem2.setPrice(orderItem2.getProduct().getPrice().multiply(new BigDecimal(2)));
		orderItem2.setImageUrl("image2.png");
		order.getOrderitems().add(orderItem2);
		
		order.setTotalQunatity(2);
		order.setTotalPrice(order.getTotalamount());
		
		Address address = new Address();
		address.setCity("Pune");
		address.setState("Maharastra");
		address.setStreet("Kothrud");
		address.setZipCode("411047");
		address.setCountry("India");
		order.setBillingAddress(address);
		
		orderRepository.save(order);
		
	}
	
}
