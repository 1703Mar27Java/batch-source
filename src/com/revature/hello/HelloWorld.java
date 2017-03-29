package com.revature.hello;
import com.revature.Fruit.*;

public class HelloWorld {
	
	public static void main(String[] args){
		System.out.println("HelloWorld");
		//
		Batch b = new Batch();
		b.setGreeting("welcome to java");
		System.out.println(b.getGreeting());
		System.out.println(HelloWorld2.message2);
	}
}
class HelloWorld2{
	static String message2 = "another message";
}