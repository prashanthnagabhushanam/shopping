package com.delta.group.shopping.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.delta.group.shopping.model.Apple;
import com.delta.group.shopping.model.Banana;
import com.delta.group.shopping.model.Fruit;
import com.delta.group.shopping.model.Lime;
import com.delta.group.shopping.model.Melon;
import com.delta.group.shopping.util.function.BuyOneGetOneFree;
import com.delta.group.shopping.util.function.Offers;
import com.delta.group.shopping.util.function.ThreeForTwo;

public class ShoppingCartEvaluatorTest {

	
	ShoppingCart shoppingCart;
	
	private final DecimalFormat decfor = new DecimalFormat("0.00");  
	
	@BeforeEach
	public void setup() {
		Map<String,Offers> mappedOffers = new Hashtable<String, Offers>();
		mappedOffers.put("Melon", new BuyOneGetOneFree());
		mappedOffers.put("Lime", new ThreeForTwo());
		shoppingCart = new ShoppingCartEvaluator(mappedOffers);
	}
	
	private List<Fruit> generateData(int apple, int banana,int melon,int lime){
		final List<Fruit> returnedFruit = new ArrayList<Fruit>();
		for (int i=0;i<apple;i++) {
			returnedFruit.add(new Apple());
		}
		for (int i=0;i<banana;i++) {
			returnedFruit.add(new Banana());
		}
		for (int i=0;i<melon;i++) {
			returnedFruit.add(new Melon());
		}
		for (int i=0;i<lime;i++) {
			returnedFruit.add(new Lime());
		}
		return returnedFruit;
	}
	
	
	@Test
	public void testNoData() {
		List<Fruit> fruits = generateData(0, 0, 0, 0);
		BigDecimal calculatedPrice = shoppingCart.calculateCost(fruits);
		assertNotNull(calculatedPrice);
		assertEquals(calculatedPrice, new BigDecimal(0d));
	}
	
	@Test
	public void testAppleBanana() {
		List<Fruit> fruits = generateData(1, 1, 0, 0);
		BigDecimal calculatedPrice = shoppingCart.calculateCost(fruits);
		assertNotNull(calculatedPrice);
		assertEquals(calculatedPrice, new BigDecimal(decfor.format(0.55d)));
	}
	
	@Test
	public void testTwoAppleBanana() {
		List<Fruit> fruits = generateData(2, 1, 0, 0);
		BigDecimal calculatedPrice = shoppingCart.calculateCost(fruits);
		assertNotNull(calculatedPrice);
		assertEquals(calculatedPrice, new BigDecimal(decfor.format(0.90d)));
	}
	
	@Test
	public void testTwoAppleBananaMelon() {
		List<Fruit> fruits = generateData(2, 1, 1, 0);
		BigDecimal calculatedPrice = shoppingCart.calculateCost(fruits);
		assertNotNull(calculatedPrice);
		assertEquals(calculatedPrice, new BigDecimal(decfor.format(1.40d)));
	}
	
	@Test
	public void test2Apple1Banana2Melon6Lime() {
		List<Fruit> fruits = generateData(2, 1, 2, 6);
		BigDecimal calculatedPrice = shoppingCart.calculateCost(fruits);
		assertNotNull(calculatedPrice);
		assertEquals(calculatedPrice, new BigDecimal(decfor.format(2.00)));
	}
	
	@Test
	public void test12Apple27Banana31Melon69Lime() {
		List<Fruit> fruits = generateData(12, 27, 31, 69);
		BigDecimal calculatedPrice = shoppingCart.calculateCost(fruits);
		assertNotNull(calculatedPrice);
		assertEquals(calculatedPrice, new BigDecimal(decfor.format(24.50)));
	}
	
	@Test
	public void test120Apple127Banana321Melon649Lime() {
		List<Fruit> fruits = generateData(120, 127, 321, 649);
		BigDecimal calculatedPrice = shoppingCart.calculateCost(fruits);
		assertNotNull(calculatedPrice);
		assertEquals(calculatedPrice, new BigDecimal(decfor.format(211.95)));
	}
	//
}
