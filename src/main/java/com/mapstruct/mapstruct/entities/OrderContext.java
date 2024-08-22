package com.mapstruct.mapstruct.entities;

public class OrderContext {
	
	private String region;
	private double discount;
	
	public OrderContext(String region, double discount) {
		this.region = region;
		this.discount = discount;
	}
	
	public String getRegion() {
		return region;
	}
	
	public void setRegion(String region) {
		this.region = region;
	}
	
	public double getDiscount() {
		return discount;
	}
	
	public void setDiscount(double discount) {
		this.discount = discount;
	}

}
