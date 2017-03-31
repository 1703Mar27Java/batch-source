package com.revature.fruit;

import static java.lang.System.*;

public class FruitHelper {

	public static void main(String[] args) {
		
		Fruit f = new Fruit(5);
		f.setNumSeeds(5);
		System.out.println(f.hashCode());
		System.out.println(f.toString());
		System.out.println(f);
		
		Apple a = new Apple(7, 5, "Red Delicious");
		System.out.println(a);
		
		out.println("static imports are cool");
		
		Orange o = new Orange(9);
		
		Fruit[] fruitBowl = new Fruit[3];
		fruitBowl[0] = f;
		fruitBowl[1] = a;
		fruitBowl[2] = o;
		
		System.out.println(fruitBowl);
		
		countSeeds("seed1", "seed2", "seed3");

	}
	
	//varargs: syntax is type an ellipsis then the name, must be last parameter
	//one vararg per parameter per method
	public static void countSeeds(String...seeds)
	{
		for(String s : seeds)
		{
			System.out.println(s);
		}
	}
}
