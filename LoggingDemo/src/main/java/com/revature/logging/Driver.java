package com.revature.logging;

public class Driver
{
	public static void main(String[] args)
	{
		System.out.println("Hello world!");
		LoggingClass logger = new LoggingClass();
		logger.someMethod();
		
		//log4j.properties should be in src/main/java, not the package itself
		
		try
		{
			exceptionThrowingGarbage();
		}
		catch(Exception e)
		{
			logger.giveFatal(e);
		}
	}
	
	public static void exceptionThrowingGarbage()
	{
		@SuppressWarnings("unused")
		int i = 5 / 0;
	}
}
