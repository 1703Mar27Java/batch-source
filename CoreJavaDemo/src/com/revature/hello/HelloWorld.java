package com.revature.hello;
import com.revature.fruit.*;
public class HelloWorld {
	private static String THIS_IS_A_CONSTANT = "this is a constant";

	public static void main(String[] args) {
		System.out.println("Hello World");

		Batch b = new Batch();
		b.setGreeting("Welcome to Java");
		System.out.println(b.getGreeting());

		System.out.println(HelloWorld2.message2);
		b.sumThing(3, 4);
		b.sumThing(3, 4, 5);

		
		//format your code ctrl shift f
		
		Object o= new Object();
		System.out.println(o.toString()); //best practice is to override this!
		System.out.println(b.toString());
		
	}

}

// we can put more than one class in a file it just can't be public
class HelloWorld2 {
	static String message2 = "";
}