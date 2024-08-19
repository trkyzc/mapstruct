package com.mapstruct.mapstruct.entities;

import lombok.Data;

@Data
public class OrderDto {
	
	private String orderId;
	private String orderDate;
	private CustomerDto customerDTO;

}
