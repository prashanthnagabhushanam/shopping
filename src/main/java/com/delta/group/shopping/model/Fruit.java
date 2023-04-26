package com.delta.group.shopping.model;

import java.math.BigDecimal;

public abstract class Fruit {

	private BigDecimal price;
	
	private String type;
	
	public Fruit() {
		// TODO Auto-generated constructor stub
	}
	
	public BigDecimal getPrice() {
		return price;
	}

	public Fruit(BigDecimal price, String type) {
		this.price = price;
		this.type = type;
	}

	public String getType() {
		return type;
	}
	
	
}
