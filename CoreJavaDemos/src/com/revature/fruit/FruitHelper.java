package com.revature.fruit;

import static java.lang.System.*;

public class FruitHelper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Fruit f = new Fruit();
		f.setNumSeeds(5);
		System.out.println(f.hashCode());
		System.out.println(f.toString());
		System.out.println(f);
		
		Apple a = new Apple();
		System.out.println(a);
		
		out.println("wow, static imports are cool");
		
		Orange o = new Orange();
		Fruit[] fruitBowl = new Fruit[3];
		fruitBowl[0] = f;
		fruitBowl[1] = a;
		fruitBowl[2] = o;
		
		//this doesn't work! compiler checks declared type. 
		//fruitBowl[1].appleMethod();
		
		System.out.println(fruitBowl);
		
		countSeeds(5, 7.2, "seed1","seed2");
		countSeeds(5, 7.2, "seed1","seed2","seed3");
		
		SeedlessFruit seedless = new SeedlessFruit();
		System.out.println(seedless.getNumSeeds());
		seedless.setNumSeeds(5);
		System.out.println(seedless.getNumSeeds());
		Fruit sf = seedless;
		sf.setNumSeeds(5);
		System.out.println(sf.getNumSeeds());
		
	}
	
	//varargs: syntax is type... name, must be the last parameter
	//one vararg parameter per method. 
	public static void countSeeds (int a, Double b, String...seeds){
		for (String s : seeds){
			System.out.println(s);
		}
	}

}
