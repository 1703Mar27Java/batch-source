package com.revature.hello;

public class HelloWorld {

	// no constant keyword exists in Java but variables can be made both Static
	// and Final
	// to make them constants. Constants use ALLCAPS and underscores between
	// words
	static final String THIS_IS_A_CONSTANT = "this is a constant";

	public static void main(String[] args) {

		System.out.println("Hello World!");

		// Classes and projects: Pascal casing (e.g. FirstSecondThird)
		// Methods and variables: camel casing (e.g. firstSecondThird)
		
		Batch b = new Batch(); b.setGreeting("Welcome to Java!");
		/* System.out.println(b.getGreeting()); 
		 * b.sumThing(3, 4);
		 * b.sumThing(3, 4, 5);
		 */

		// we can access static members using the class name
		System.out.println(HelloWorld2.message2);

		// format your code: ctrl+shift+f
		
		Object o = new Object();
		System.out.println(o.toString()); //best practice to override this!
		System.out.println(b.toString());
		
		com.revature.fruit.Apple a = new com.revature.fruit.Apple(10, 5, "Gala");
		
		System.out.println(a.toString());
	}

}

// example of a secondary class
class HelloWorld2 {
	static String message2 = "Have a nice day!";
}
