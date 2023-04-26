package com.delta.group.shopping.util.function;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Predicate;

import com.delta.group.shopping.model.Fruit;

@FunctionalInterface
public interface Offers {

	BigDecimal apply(List<Fruit> fruits);
}
