package com.revature.MavenDemos;

public class StringCalculator {
/*
 * Requirement 1: create a String Calculator with a method
 * int Add(String numbers)
 * This method can take 0,1, or 2 numbers and will return their sum
 * Requirement 2: returns 0 for empty string
 * Requirement 3: returns same number for 1 argument
 * Requirement 4: trims out whitespace before attempting to add
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int add(String numbers){
		int sum=0;
	numbers=numbers.replaceAll("\\s+","");
	String[] numbersArray=numbers.split(",");
	if(numbersArray.length>2){
		//this is a terrible exception message
		throw new RuntimeException("too much pancake mix");
		
	}
	else{
	
		for(String number:numbersArray){
			//this will throw an unchecked (runtime) exception
			if(!number.equals("")){
			sum+=Integer.parseInt(number);
			}
			else{
				continue; //allow for consecutive commas
			}
		}
	}
		return sum;
	}

}
