package com.revature.scanner;

import java.util.Scanner;

public class ScannerAssignment {

	private static String dataType = "int";
	private static String val1 = "0";
	private static String val2 = "0";
	private static String result = "invalid data type";

	public static String Scan() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a dataType for a numeric value");
		dataType = scanner.next();
		System.out.println("Enter the first value");
		val1 = scanner.next();
		System.out.println("Enter the second value");
		val2 = scanner.next();
		scanner.close();
		Add();
		return result;
	}

	private static void Add() {
		try {
			switch (dataType.toUpperCase()) {
			case "INTEGER":
			case "INT":
				result = String.valueOf(Integer.parseInt(val1) + Integer.parseInt(val2));
				break;
			case "DOUBLE":
				result = String.valueOf(Double.parseDouble(val1) + Double.parseDouble(val2));
				break;
			case "FLOAT":
				result = String.valueOf(Float.parseFloat(val1) + Float.parseFloat(val2));
				break;
		
			default:
				result = "invalid data type";
			}
		} catch (NumberFormatException e) {
			result = "One of your values did not match the dataType";
		} finally {
		}
	}

	public static void main(String[] args) {
		System.out.println("Your result after adding your two values is: " + ScannerAssignment.Scan());

	}

}
