package com.delta.group.shopping;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.delta.group.shopping.model.Apple;
import com.delta.group.shopping.model.Fruit;
import com.delta.group.shopping.model.Lime;
import com.delta.group.shopping.model.Melon;
import com.delta.group.shopping.util.function.BuyOneGetOneFree;
import com.delta.group.shopping.util.function.Offers;
import com.delta.group.shopping.util.function.ThreeForTwo;

public class MelonOffers {

	public static void main(String[] args) {
		Apple apple = new Apple();
		Melon melon = new Melon();
		Melon melon1 = new Melon();
		Melon melon2= new Melon();
		Melon melon3 = new Melon();
		Melon melon4= new Melon();
		Melon melon5= new Melon();
		Melon melon6= new Melon();
		List<Fruit>  fruits = new ArrayList<Fruit>();
		fruits.add(apple);
		fruits.add(melon);
		fruits.add(melon1);
		fruits.add(melon2);
		fruits.add(melon3);
		fruits.add(melon4);
		fruits.add(melon5);
		fruits.add(melon5);
		fruits.add(melon5);
		fruits.add(melon5);
		fruits.add(melon5);
		fruits.add(melon5);
		Offers offers = new BuyOneGetOneFree();

		List<Fruit>  limes = new ArrayList<Fruit>();
		limes.add(new Lime());
		limes.add(new Lime());
		limes.add(new Lime());
		limes.add(new Lime());
		limes.add(new Lime());
		limes.add(new Lime());
		
		System.out.println(offers.apply(fruits));
		System.out.println(new ThreeForTwo().apply(limes));
	}
}
