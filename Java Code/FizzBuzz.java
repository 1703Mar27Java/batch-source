package com.revature.FizzBuzz;

import java.io.*;
import java.util.Scanner;

public class FizzBuzz {

	public static void main(String[] args) {

		FizzBuzzInfo info = new FizzBuzzInfo();

		Scanner input = new Scanner(System.in);

		System.out.println("Enter 2 numbers to serve as a range each followed by enter");

		System.out.println("Enter the lower number in the range");
		info.range1 = input.nextInt();
		System.out.println("Enter the higher number in the range");
		info.range2 = input.nextInt();

		System.out.println("Enter a Number to change Multiples to Fizz");
		info.param1 = input.nextInt();
		System.out.println("Enter a Number to change Multiples to Buzz");
		info.param2 = input.nextInt();

		info.range = new int[info.range2];
		StringBuilder stringB = new StringBuilder();

		for (int i = info.range1; i < info.range2; i++) {
			if (i % info.param1 == 0 && i % info.param2 == 0) {
				stringB.append("fizzbuzz ");
			} else if (i % info.param2 == 0) {
				stringB.append("buzz ");
			} else if (i % info.param1 == 0) {
				stringB.append("fizz ");
			} else {
				stringB.append(i + " ");
			}

		}

		String out = stringB.toString();

		serializeObject("src/seriaizedThings/FizzBuzzFile", out);
		writeToFile("src/seriaizedThings/FizzBuzzReadableFile", out);
		System.out.println(out);

	}

	public static void serializeObject(String fileName, Object obj) {
		try {
			File serial = new File(fileName);
			serial.createNewFile();
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(serial));
			oos.writeObject(obj);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeToFile(String fileName, String out) {
		try {
			File readableFile = new File(fileName);
			readableFile.createNewFile();
			FileWriter fw = new FileWriter(readableFile);
			fw.write(out);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
