package com.springdatajpacourse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springdatajpacourse.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Long>{
	
	Order findByorderTrackingNumber(String orderTrackingNumber);

}
