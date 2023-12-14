package com.springboottransaction.management.dto;

import com.springboottransaction.management.entity.Order;
import com.springboottransaction.management.entity.Payment;

import lombok.Data;
@Data
public class OrderRequest {
	private Order order;
	private Payment payment;

}
