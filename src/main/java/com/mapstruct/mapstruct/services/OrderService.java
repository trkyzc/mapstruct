package com.mapstruct.mapstruct.services;

import org.springframework.stereotype.Service;

import com.mapstruct.mapstruct.entities.Order;
import com.mapstruct.mapstruct.entities.OrderContext;
import com.mapstruct.mapstruct.entities.OrderDto;
import com.mapstruct.mapstruct.mappers.OrderMapper;

@Service
public class OrderService {
	
	private final OrderMapper orderMapper;
	
	public OrderService(OrderMapper orderMapper) {
		this.orderMapper = orderMapper;
	}
	
	public void createOrder(OrderDto orderDto) {
		OrderContext orderContext = new OrderContext("North Region", 0.1); 
		Order order = orderMapper.toOrder(orderDto, orderContext);
		System.out.println("Order created: " + order);
	}

}
