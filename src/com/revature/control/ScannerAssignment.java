package com.revature.control;

import java.util.Scanner;

public class ScannerAssignment {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Short count = 0;
		String[] bank = new String[3];
		while (count < 3) {
			bank[count] = s.next();
			++count;
		}
		s.close();
		switch (bank[0].toLowerCase()) {
		case "byte":
			System.out.println(Byte.parseByte(bank[1]) + Byte.parseByte(bank[2]));
			break;
		case "short":
			System.out.println(Short.parseShort(bank[1]) + Short.parseShort(bank[2]));
			break;
		case "int":
			System.out.println(Integer.parseInt(bank[1]) + Integer.parseInt(bank[2]));
			break;
		case "long":
			System.out.println(Long.parseLong(bank[1]) + Long.parseLong(bank[2]));
			break;
		case "float":
			System.out.println(Float.parseFloat(bank[1]) + Float.parseFloat(bank[2]));
			break;
		case "double":
			System.out.println(Double.parseDouble(bank[1]) + Double.parseDouble(bank[2]));
			break;
		default:
			System.out.println("Invalid argument");
			break;
		}
	}
}
