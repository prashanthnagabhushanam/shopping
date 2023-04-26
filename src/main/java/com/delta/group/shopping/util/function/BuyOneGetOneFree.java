package com.delta.group.shopping.util.function;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

import com.delta.group.shopping.model.Fruit;
import com.delta.group.shopping.model.Melon;

public class BuyOneGetOneFree implements Offers {

	private final DecimalFormat decfor = new DecimalFormat("0.00"); 
	
	@Override
	public BigDecimal apply(List<Fruit> fruits) {
		if(fruits == null || fruits.size() == 0) {
			return new BigDecimal(0d);
		}
		List<BigDecimal> prices = fruits.stream().filter(fruit -> fruit instanceof Melon).distinct().map(melon -> melon.getPrice()).collect(Collectors.toList());
		int size = (int)Math.ceil(prices.size()/2f);
		return new BigDecimal(decfor.format(prices.stream().limit(size).reduce(BigDecimal.ZERO, BigDecimal::add).round(new MathContext(2,RoundingMode.HALF_EVEN))));

	}
}
