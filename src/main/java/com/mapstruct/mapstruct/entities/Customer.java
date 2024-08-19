package com.mapstruct.mapstruct.entities;

import java.util.Date;

import lombok.Data;

@Data
public class Customer {
	
	private Long id;
    private String name;
    private String emailAddress;
    private String phoneNumber; 
    private Date registrationDate; 

}
