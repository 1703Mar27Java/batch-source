package com.Revature.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class FizzBuzz {

	public static void main(String[] args) {
		String filename = "src/serializedThings/Fizzbuzz";
		String filename2 = "src/serializedThings/FizzBuzzPlain";
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter beginning of range: ");
		int startRange = scan.nextInt();
		System.out.println("Enter end range: ");
		int endRange = scan.nextInt();
		System.out.println("Enter a (fizz): ");
		int a = scan.nextInt();
		System.out.println("Enter b (buzz): ");
		int b = scan.nextInt();

		FizzBuzzInfo fbi = new FizzBuzzInfo(startRange, endRange, a, b);
		fbi.doFizzBuzz();
		fbi.writeToFile(filename2);
		//fbi.writeObject(filename, fbi);
		//fbi.readObject(filename);
	}

	static void readObject(String filename) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
			Object obj = ois.readObject();
			System.out.println(obj);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	

}
