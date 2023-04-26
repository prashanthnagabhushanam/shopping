package com.delta.group.shopping.util.function;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

import com.delta.group.shopping.model.Fruit;
import com.delta.group.shopping.model.Lime;

public class ThreeForTwo implements Offers {

	private final DecimalFormat decfor = new DecimalFormat("0.00");  
	
	@Override
	public BigDecimal apply(List<Fruit> fruits) {
		if(fruits == null || fruits.size() == 0) {
			return new BigDecimal(0d);
		}
		List<BigDecimal> prices = fruits.stream().filter(fruit -> fruit instanceof Lime).distinct().map(lime -> lime.getPrice()).collect(Collectors.toList());
		int modulusValue = Math.floorMod(prices.size(), 3);
		int reminderValue = (int)Math.ceil(prices.size()/3);
		return new BigDecimal(decfor.format(prices.stream().limit(modulusValue+reminderValue*2).reduce(BigDecimal.ZERO, BigDecimal::add)));

	}

}
