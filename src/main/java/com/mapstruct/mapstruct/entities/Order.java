package com.mapstruct.mapstruct.entities;

import java.util.Date;

import lombok.Data;

@Data
public class Order {
	
	private Long id;
	private Date orderDate;
	private Customer customer;

}
