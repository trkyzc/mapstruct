package com.mapstruct.mapstruct.mappers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.mapstruct.mapstruct.entities.Customer;
import com.mapstruct.mapstruct.entities.CustomerDto;
import com.mapstruct.mapstruct.entities.Order;
import com.mapstruct.mapstruct.entities.OrderContext;
import com.mapstruct.mapstruct.entities.OrderDto;

@Mapper(componentModel = "spring")
public interface OrderMapper {
	

	@Mapping(source ="customerDTO", target = "customer", qualifiedByName = "convertCustomerDtoToEntity")
	@Mapping(source = "orderDate", target = "orderDate", qualifiedByName = "stringToDate")
	@Mapping(target = "totalPrice", expression = "java(applyDiscount(orderDto.getTotalPrice(), context.getDiscount()))")
	Order toOrder(OrderDto orderDto, @Context OrderContext context);
	
	@Named("convertCustomerDtoToEntity")
	default Customer convertCustomerDtoToEntity(CustomerDto customerDto, @Context OrderContext orderContext) {  //default: override etmeden kullanabilir. Kullanmak zorunda değil.
		if (customerDto == null) {
			return null;
		}
		
		Customer customer = new Customer();
		customer.setName(customerDto.getFullName());
		customer.setEmailAddress(customerDto.getEmail());
		customer.setPhoneNumber("0000000000");
		customer.setRegistrationDate(new Date());
		customer.setRegion(orderContext.getRegion());
		
		return customer;
	}
	
	@Named("stringToDate")
	default Date stringToDate(String date) {
		
		try {
			return new SimpleDateFormat("dd-MM-yyyy").parse(date);
		}
		catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Named("applyDiscount")
	default double applyDiscount(double totalPrice, double discount) {
		return totalPrice - (totalPrice*discount);
	}

}
