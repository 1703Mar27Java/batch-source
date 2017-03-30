package com.revature.fruit;

import static java.lang.System.*;

public class FruitHelper {

	public static void main(String[] args) {
		Fruit f = new Fruit();
		f.setNumSeeds(5);
		System.out.println(f.hashCode());

		System.out.println(f.toString());
		System.out.println(f);

		Apple a = new Apple();
		System.out.println(a);

		out.println("Wow static imports are cool");

		a = new Apple(6);
		out.println(a);

		Orange o = new Orange();
		Fruit[] fruitBowl = new Fruit[3];
		fruitBowl[0] = f;
		fruitBowl[1] = a;
		fruitBowl[2] = o;

		// This doesn't work! compiler checks declared type
		// fruitBowl[1].appleMethod();

		out.println(fruitBowl);

		countSeeds(5, 7.2, "seed1", "seed2");
		countSeeds(5, 7.2, "seed1", "seed2", "seed3");
		
		
		SeedlessFruit s=new SeedlessFruit();
		s.setNumSeeds(3);
		System.out.println(s.getNumSeeds());
		((Fruit)s).setNumSeeds(5);
		System.out.println(((Fruit)s).getNumSeeds());
	}

	// varargs: syntax is type.. name, must be the last parameter
	// one vararg parameter per method
	public static void countSeeds(int a, Double b, String... seeds) {
		for (String s : seeds) {
			System.out.println(s);
		}
	}

}
