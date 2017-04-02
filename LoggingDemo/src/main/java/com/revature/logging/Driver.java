package com.revature.logging;

public class Driver {

	public static void main(String[] args) {
		System.out.println("Hello World");
		LoggingClass logger = new LoggingClass();
		logger.someMethod();
		//log4j.properties should be in src/main/java, NOT the com.revature.logging package 
		
		try{
			exceptionThrowingGarbage();
		} catch (Exception e){
			logger.giveFatal(e);
		}
		
	}
	
	public static void exceptionThrowingGarbage() {
		int i = 5/0;
	}

}