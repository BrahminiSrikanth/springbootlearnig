package com.springboottransaction.management.service;

import com.springboottransaction.management.dto.OrderRequest;
import com.springboottransaction.management.dto.OrderResponse;

public interface OrderService {
	OrderResponse placeOrder(OrderRequest orderRequest);

}
