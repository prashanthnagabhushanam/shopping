package com.delta.group.shopping.services;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.delta.group.shopping.model.Fruit;
import com.delta.group.shopping.util.function.Offers;

public class ShoppingCartEvaluator implements ShoppingCart{

	
	private final Map<String,Offers> mappedOffers;
	
	public ShoppingCartEvaluator(Map<String, Offers> mappedOffers) {
		this.mappedOffers = mappedOffers;
	}

	@Override
	public BigDecimal calculateCost(List<Fruit> fruits) {
	List<BigDecimal> calculatedPriceList = new ArrayList<BigDecimal>();
		Map<String, List<Fruit>> groupedFruitsMap = fruits.stream().collect(Collectors.groupingBy(fruit ->fruit.getType()));
		groupedFruitsMap.forEach((type,groupedFruit) -> {
			BigDecimal groupedFruitPrice;
			if(mappedOffers != null && mappedOffers.containsKey(type)) {
				Offers offers=mappedOffers.get(type);
				groupedFruitPrice = offers.apply(groupedFruit);
			}else {
				groupedFruitPrice = groupedFruit.stream().map(fruit -> fruit.getPrice()).reduce(BigDecimal.ZERO, BigDecimal::add).round(new MathContext(2,RoundingMode.HALF_EVEN));
			}
			calculatedPriceList.add(groupedFruitPrice);
			});
		return calculatedPriceList.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	
}
