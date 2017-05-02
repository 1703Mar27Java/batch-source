package com.revature.exceptions;

public class Main {

	public static void main(String[] args) {
		
		try {
			System.out.println("cat");
			String s = "hello world";
			s.length();
			System.out.println("dog");
		} catch (NullPointerException e){
			System.out.println("catch");
		} finally {
			System.out.println("finally");
		}
		
		try {
			doesThing();
		} catch (MyException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	static void doesThing() throws MyException {
		throw new MyException("throwing my exception");
	}

}


