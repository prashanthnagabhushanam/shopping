package com.delta.group.shopping.util.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.delta.group.shopping.model.Fruit;
import com.delta.group.shopping.model.Melon;

public class BuyOneGetOneFreeTest {

	private final DecimalFormat decfor = new DecimalFormat("0.00");

	private List<Fruit> getList(int size) {
		final List<Fruit> returnedFruit = new ArrayList<Fruit>();
		for (int i = 0; i < size; i++) {
			returnedFruit.add(new Melon());
		}
		return returnedFruit;
	}

	@Test
	public void testNoFruit() {
		BigDecimal calculatedPrice = new BuyOneGetOneFree().apply(getList(0));
		assertNotNull(calculatedPrice);
		assertEquals(calculatedPrice, new BigDecimal(0));
	}

	@Test
	public void testOneFruit() {
		BigDecimal calculatedPrice = new BuyOneGetOneFree().apply(getList(1));
		assertNotNull(calculatedPrice);
		assertEquals(calculatedPrice, new BigDecimal(decfor.format(0.5d)));
	}

	@Test
	public void testTwoFruit() {
		BigDecimal calculatedPrice = new BuyOneGetOneFree().apply(getList(2));
		assertNotNull(calculatedPrice);
		assertEquals(calculatedPrice, new BigDecimal(decfor.format(0.5d)));
	}

	@Test
	public void testSevenFruit() {
		BigDecimal calculatedPrice = new BuyOneGetOneFree().apply(getList(7));
		assertNotNull(calculatedPrice);
		assertEquals(calculatedPrice, new BigDecimal(decfor.format(2.0)));
	}
}
