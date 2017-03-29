package com.revature.fizzbuzz;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.io.File;

public class FizzBuzz {

	public static void main(String[] args) {
		FizzBuzzInfo fbi = getInput();
		String output = fizzBuzz(fbi);
		serializeObject("src/serializedThings/FizzBuzzSerial", fbi);
		writeToFile("src/writtenThings/FizzBuzzHumanReadable", output);
	}

	public static FizzBuzzInfo getInput() {
		System.out.println("Enter a range and 2 numbers. Format: min max a b");
		Scanner s = new Scanner(System.in);
		FizzBuzzInfo fbi = new FizzBuzzInfo(s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt());
		s.close();
		return fbi;
	}

	public static String fizzBuzz(FizzBuzzInfo fbi) {
		StringBuilder sb = new StringBuilder();
		int newLine = 0;
		for (int i = fbi.getMinValue(); i <= fbi.getMaxValue(); i++) {
			newLine++;
			if (i % fbi.getA() == 0 && i % fbi.getB() == 0) {
				sb.append("fizzbuzz ");
				System.out.print("fizzbuzz ");
			} else if (i % fbi.getA() == 0) {
				sb.append("fizz ");
				System.out.print("fizz ");
			} else if (i % fbi.getB() == 0) {
				sb.append("buzz ");
				System.out.print("buzz ");
			} else {
				sb.append(i + " ");
				System.out.print(i + " ");
			}

			if (newLine == 20) {
				sb.append('\n');
				System.out.println();
				newLine = 0;
			}

		}

		return sb.toString();
	}

	public static void serializeObject(String fileName, Object obj) {
		try {
			File serialFile = new File(fileName);
			serialFile.createNewFile();
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(serialFile));
			oos.writeObject(obj);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeToFile(String fileName, String out) {
		try {
			File humanReadableFile = new File(fileName);
			humanReadableFile.createNewFile();
			FileWriter fw = new FileWriter(humanReadableFile);
			fw.write(out);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
