package com.revature.adder;

import java.util.Scanner;

public class Adder {

	public static void main(String[] args) throws InvalidTypeEntryException {
		
		int choice;
		String value1, value2;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("What data type do you want?");
		System.out.println("");
		System.out.println("1: boolean");
		System.out.println("2: byte");
		System.out.println("3: char");
		System.out.println("4: short");
		System.out.println("5: int");
		System.out.println("6: long");
		System.out.println("7: float");
		System.out.println("8: double");
		
		choice = scan.nextInt();
		
		System.out.println("Enter the first value:");
		
		value1 = scan.nextLine();
		
		System.out.println("Enter the second value:");
		
		value2 = scan.nextLine();
		
		scan.close();
		
		switch(choice)
		{
			case 1:
				//the "+" sometimes symbol is used as the disjunction operator in mathematical logic
				//so "adding" two booleans is the "or" expression for both input values
				System.out.println(Boolean.parseBoolean(value1) || Boolean.parseBoolean(value2));
				break;
			case 2:
				//two bytes added is always and int, so this will print an int value
				System.out.println(Byte.parseByte(value1) + Byte.parseByte(value2));
				break;
			case 3:
				System.out.println(value1.charAt(0) + value2.charAt(0));
				break;
			case 4:
				System.out.println(Short.parseShort(value1) + Short.parseShort(value2));
				break;
			case 5:
				System.out.println(Integer.parseInt(value1) + Integer.parseInt(value2));
				break;
			case 6:
				System.out.println(Long.parseLong(value1) + Long.parseLong(value2));
				break;
			case 7:
				System.out.println(Float.parseFloat(value1) + Float.parseFloat(value2));
				break;
			case 8:
				System.out.println(Double.parseDouble(value1) + Float.parseFloat(value2));
				break;
			default:
				throw new InvalidTypeEntryException();
		}
	}
}

class InvalidTypeEntryException extends Exception
{
	/**
	 * Generated serial UID
	 */
	private static final long serialVersionUID = -2935643258228928604L;

	public InvalidTypeEntryException()
	{
		super("Invalid data type entry!");
	}
}
