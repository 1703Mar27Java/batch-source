package com.revature.fizzbuzzProject;

import java.util.*;

public class FizzbuzzHelper {

	public static void main(String[] args) {
		
		int userInput = 0;
		Scanner scan = new Scanner(System.in);
		String pOJOFileName = "src/SerializedThings/fizzBuzzPOJO";
		String outputFileName = "src/SerializedThings/fizzBuzzOutput";
		FizzbuzzInfo fizzy = new FizzbuzzInfo();
		boolean userCheck = true; //used to check if user enters integers
		boolean rangeCheck = true; //used to check if user enters a valid range
		
		
		while(rangeCheck) //repeat first two loops until valid range is entered
		{
			while(userCheck)
			{
				try
				{
					System.out.print("Enter integer for beginning of range: ");
					userInput = Integer.parseInt(scan.nextLine());
					fizzy.setLowRange(userInput);
					System.out.println();
					userCheck = false;
				}
				
				catch(NumberFormatException e)
				{
					System.out.println("Not an integer. Try again\n");
				}	
			}
			
			userCheck = true;
			while(userCheck)
			{
				try
				{
					System.out.print("Enter integer for end of range: ");
					userInput = Integer.parseInt(scan.nextLine());
					fizzy.setHighRange(userInput);
					System.out.println();
					userCheck = false;
				}
				
				catch(NumberFormatException e)
				{
					System.out.println("Not an integer. Try again\n");
				}
			}
			
			if(fizzy.getLowRange() > fizzy.getHighRange())
			{
				System.out.println("Not a valid range.  Start over.\n");
				userCheck = true;
			}
			else
			{
				rangeCheck = false;
			}
		}

		
		userCheck = true;
		while(userCheck)
		{
			try
			{
				System.out.print("Enter integer for fizz value: ");
				userInput = Integer.parseInt(scan.nextLine());
				fizzy.setFizz(userInput);
				System.out.println();
				userCheck = false;
			}
			
			catch(NumberFormatException e)
			{
				System.out.println("Not an integer. Try again\n");
			}
		
		}
		
		userCheck = true;
		while(userCheck)
		{
			try
			{
				System.out.print("Enter integer for buzz value: ");
				userInput = Integer.parseInt(scan.nextLine());
				fizzy.setBuzz(userInput);
				System.out.println();
				userCheck = false;
			}
			
			catch(NumberFormatException e)
			{
				System.out.println("Not an integer. Try again\n");
			}
		}
		
		fizzy.FizzBuzzMath();
		fizzy.SaveTheFizz(pOJOFileName, fizzy);
		fizzy.SaveTheBuzz(outputFileName, fizzy);
		
		scan.close();
	
	}

}
