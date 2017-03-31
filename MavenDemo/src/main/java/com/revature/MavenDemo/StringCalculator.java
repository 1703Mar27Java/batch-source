package com.revature.MavenDemo;

public class StringCalculator 
{
	
	/*
	 * Requirement 1: create a string calculator with a method
	 * int Add(String numbers)
	 * The method can take 0, 1 or 2 numbers and will return their sum
	 * 
	 * Requirement 2: Returns 0 for empty string
	 * 
	 * Requirement 3: Returns same number if 1 number used for argument
	 * 
	 * Requirement 4: Trims whitespace out of input
	 */
	public static void main(String[] args) 
	{
		//
	}
	
	public static int add(String numbers)
	{
		int sum = 0;
		
		//trim whitespace
		numbers = numbers.replaceAll("\\s+", "");
		
		//split by comma
		String[] numbersArray = numbers.split(",");
		
		if(numbersArray.length > 2)
		{
			throw new RuntimeException("Too many input numbers!");
		}
		else
		{
			for(String number : numbersArray)
			{
				if(!number.equals(""))
				{
					//this will throw an unchecked (runtime) exception
					sum += Integer.parseInt(number);
				}
				else
				{
					continue;
				}
			}
		}
		
		return sum;
	}

}
