package com.mapstruct.mapstruct.mappers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.mapstruct.mapstruct.entities.Customer;
import com.mapstruct.mapstruct.entities.CustomerDto;
import com.mapstruct.mapstruct.entities.Order;
import com.mapstruct.mapstruct.entities.OrderDto;

@Mapper(componentModel = "spring")
public interface OrderMapper {
	
	@Mapping(source ="customerDTO", target = "customer", qualifiedByName = "convertCustomerDtoToEntity")
	@Mapping(source = "orderDate", target = "orderDate", qualifiedByName = "stringToDate")
	Order toOrder(OrderDto orderDto);
	
	@Named("convertCustomerDtoToEntity")
	default Customer convertCustomerDtoToEntity(CustomerDto customerDto) {  //default: override etmeden kullanabilir. Kullanmak zorunda değil.
		if (customerDto == null) {
			return null;
		}
		
		Customer customer = new Customer();
		customer.setName(customerDto.getFullName());
		customer.setEmailAddress(customerDto.getEmail());
		customer.setPhoneNumber("0000000000");
		customer.setRegistrationDate(new Date());
		
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

}
