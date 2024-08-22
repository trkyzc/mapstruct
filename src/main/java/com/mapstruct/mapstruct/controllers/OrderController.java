package com.mapstruct.mapstruct.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mapstruct.mapstruct.entities.OrderDto;
import com.mapstruct.mapstruct.services.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderDto orderDTO) {
        try {
            orderService.createOrder(orderDTO);
            return new ResponseEntity<>("Order created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating order: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
   

}
