package com.delta.group.shopping.services;

import java.math.BigDecimal;
import java.util.List;

import com.delta.group.shopping.model.Fruit;

public interface ShoppingCart {

	public BigDecimal calculateCost(List<Fruit> fruits);
}
