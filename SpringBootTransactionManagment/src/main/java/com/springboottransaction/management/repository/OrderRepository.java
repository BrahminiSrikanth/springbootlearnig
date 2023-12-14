package com.springboottransaction.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboottransaction.management.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Long> {

}
