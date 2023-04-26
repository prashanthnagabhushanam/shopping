package com.delta.group.shopping.util.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.delta.group.shopping.model.Fruit;
import com.delta.group.shopping.model.Lime;

public class ThreeForTwoTest {

	private final DecimalFormat decfor = new DecimalFormat("0.00");
	
	private List<Fruit> getList(int size){
		final List<Fruit> returnedFruit = new ArrayList<Fruit>();
		for (int i=0;i<size;i++) {
			returnedFruit.add(new Lime());
		}
	return returnedFruit;
	}
	
	@Test
	public void testNoFruit() {
		BigDecimal calculatedPrice = new ThreeForTwo().apply(getList(0));
		assertNotNull(calculatedPrice);
		assertEquals(calculatedPrice, new BigDecimal(0d));
	}
	
	@Test
	public void testOneFruit() {
		BigDecimal calculatedPrice = new ThreeForTwo().apply(getList(1));
		assertNotNull(calculatedPrice);
		assertEquals(calculatedPrice, new BigDecimal(decfor.format(0.15d)));
	}
	
	@Test
	public void testTwoFruit() {
		BigDecimal calculatedPrice = new ThreeForTwo().apply(getList(2));
		assertNotNull(calculatedPrice);
		assertEquals(calculatedPrice, new BigDecimal(decfor.format(0.3d)));
	}
	
	@Test
	public void testThreeFruit() {
		BigDecimal calculatedPrice = new ThreeForTwo().apply(getList(3));
		assertNotNull(calculatedPrice);
		assertEquals(calculatedPrice, new BigDecimal(decfor.format(0.3d)));
	}
	
	@Test
	public void testFourFruit() {
		BigDecimal calculatedPrice = new ThreeForTwo().apply(getList(4));
		assertNotNull(calculatedPrice);
		assertEquals(calculatedPrice, new BigDecimal(decfor.format(0.45d)));
	}
	
	@Test
	public void testFiveFruit() {
		BigDecimal calculatedPrice = new ThreeForTwo().apply(getList(5));
		assertNotNull(calculatedPrice);
		assertEquals(calculatedPrice, new BigDecimal(decfor.format(0.60d)));
	}
	
	@Test
	public void testSixFruit() {
		BigDecimal calculatedPrice = new ThreeForTwo().apply(getList(6));
		assertNotNull(calculatedPrice);
		assertEquals(calculatedPrice, new BigDecimal(decfor.format(0.60d)));
	}
	
	@Test
	public void testTwentyFruit() {
		BigDecimal calculatedPrice = new ThreeForTwo().apply(getList(20));
		assertNotNull(calculatedPrice);
		assertEquals(calculatedPrice, new BigDecimal(decfor.format(2.1d)));
	}
	
	@Test
	public void test69Fruit() {
		BigDecimal calculatedPrice = new ThreeForTwo().apply(getList(69));
		assertNotNull(calculatedPrice);
		assertEquals(calculatedPrice, new BigDecimal(decfor.format(6.9d)));
	}
}
