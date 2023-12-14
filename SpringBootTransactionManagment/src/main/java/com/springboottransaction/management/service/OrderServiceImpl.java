package com.springboottransaction.management.service;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboottransaction.management.dto.OrderRequest;
import com.springboottransaction.management.dto.OrderResponse;
import com.springboottransaction.management.entity.Order;
import com.springboottransaction.management.entity.Payment;
import com.springboottransaction.management.exception.PaymentException;
import com.springboottransaction.management.repository.OrderRepository;
import com.springboottransaction.management.repository.PaymentRepository;


@Service
public class OrderServiceImpl implements OrderService {

	private OrderRepository orderRepository;
	private PaymentRepository paymentRepository;
	
	public OrderServiceImpl(OrderRepository orderRepository,PaymentRepository paymentRepository) {
		this.orderRepository=orderRepository;
		this.paymentRepository=paymentRepository;
	}


	@Transactional()
	public OrderResponse placeOrder(OrderRequest orderRequest) {
		Order order = orderRequest.getOrder();
		order.setStatus("INPROGRESS");
		order.setOrderTrackingNumber(UUID.randomUUID().toString());
		orderRepository.save(order);
		Payment payment = orderRequest.getPayment();
		if(!payment.getType().equals("DEBIT")) {
		throw new PaymentException("payment card type do not support");	
		} 
		payment.setOrderId(order.getId());
		paymentRepository.save(payment);
		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
		orderResponse.setStatus(order.getStatus());
		orderResponse.setMessgae("SUCCESS");
		return orderResponse;
	}
}
