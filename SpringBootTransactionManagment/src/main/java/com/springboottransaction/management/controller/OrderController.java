package com.springboottransaction.management.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboottransaction.management.dto.OrderRequest;
import com.springboottransaction.management.dto.OrderResponse;
import com.springboottransaction.management.service.OrderService;

@RestController
@RequestMapping("/api/v1/placeorder")
public class OrderController {

	private OrderService orderService;
	
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@PostMapping
	public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest orderRequest){
		return ResponseEntity.ok(orderService.placeOrder(orderRequest));
	}
}
