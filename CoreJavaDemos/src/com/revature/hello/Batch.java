package com.revature.hello;

public class Batch {
	
	private String greeting;

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	
	public void sumThing(int a, int b){
		int c = a+b;
		System.out.println(c);
	}
	
	public void sumThing(int a, int b, int c){
		int d = a+b+c;
		System.out.println(d);
	}

	@Override
	public String toString() {
		return "Batch [greeting=" + greeting + "]";
	}
	
	

}
