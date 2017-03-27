package com.revature.hello;

public class HelloWorld {

	static final String THIS_IS_A_CONSTANT = "this is a constant";

	public static void main(String[] args) {
		System.out.println("HelloWorld");

		// Classes and projects: pascal casing FirstSecondThird
		// Methods and variables: camel casing firstSecondThird

		
		  Batch b = new Batch(); b.setGreeting("Welcome to Java");
		 /*
		 * System.out.println(b.getGreeting()); b.sumThing(3, 4); b.sumThing(3,
		 * 4, 5); //we can access static members using the class name
		 * System.out.println(HelloWorld2.message2);
		 */
		
		//format your code: ctrl+shift+f
		
		Object o = new Object();
		System.out.println(o.toString()); //best practices to override this! 
		System.out.println(b.toString());
	}

}

// we can put more than one class in a file! It just can't be public
class HelloWorld2 {
	static String message2 = "another message";
}