package com.revature.control;

import java.util.Scanner;

public class Exercise {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String dataType, num1, num2;
		
		System.out.print("Enter Datatype: ");
		dataType = sc.next();
		sc.nextLine();
		
		System.out.print("Numeric Value 1 = ");
		num1 = sc.next();
		sc.nextLine();
		
		System.out.print("Numeric Value 2 = ");
		num2 = sc.next();
		sc.nextLine();
		
		System.out.print("Value 1 + Value 2 = ");
		switch (dataType) {
		case "byte": System.out.println(Byte.parseByte(num1) + Byte.parseByte(num2)); break;
		case "short": System.out.println(Short.parseShort(num1) + Short.parseShort(num2)); break;
		case "int": System.out.println(Integer.parseInt(num1) + Integer.parseInt(num2)); break;
		case "long": System.out.println(Long.parseLong(num1) + Long.parseLong(num2)); break;
		case "float": System.out.println(Float.parseFloat(num1) + Float.parseFloat(num2)); break;
		case "double": System.out.println(Double.parseDouble(num1) + Double.parseDouble(num2)); break;
		default: System.out.println("Invalid input"); break; 
		}
		
		sc.close();

	}
}