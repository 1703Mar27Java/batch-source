package com.revature.Fruit;
import static java.lang.System.*;

public class FruitHelper {
	public static void main(String[] args){
		Fruit f = new Fruit();
		f.setNumSeeds(35);
		System.out.println(f.hashCode());
		System.out.println(f.toString());
		
		Apple a = new Apple(3,9);
		System.out.println(a);
		System.out.println(a.hashCode());
		out.println("line");
	}
}
