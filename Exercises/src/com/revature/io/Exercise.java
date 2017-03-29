package com.revature.io;

import java.io.*;
import java.util.Scanner;

public class Exercise {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int minRange, maxRange, a, b;
		String textFilename = "src/com/revature/io/Files/FizzBuzzOutput";		
		String serialFilename = "src/com/revature/io/Files/FizzBuzzSerialized";	
		
		System.out.print("Enter minimum range = ");
		minRange = sc.nextInt();			
		System.out.print("Enter maximum range = ");
		maxRange = sc.nextInt();			
		System.out.print("Enter a = ");
		a = sc.nextInt();			
		System.out.print("Enter b = ");
		b = sc.nextInt();
		sc.close();
		
		FizzBuzzInfo fz = new FizzBuzzInfo(minRange, maxRange, a, b);
		
		writeFizzBuzz(textFilename, fz);
		readFizzBuzz(textFilename);
		writeSerializedObject(serialFilename, fz);
		readSerializedObject(serialFilename);
	}
	
	static void writeFizzBuzz(String filename, FizzBuzzInfo fz) {
		try(FileWriter fw = new FileWriter(filename)) {
			int min = fz.getMinRange();
			int max = fz.getMaxRange();
			int a = fz.getA();
			int b = fz.getB();
			
			for (int i = min; i <= max; i++) {
				if (i % a == 0 && i % b == 0) {
					fw.write("fizzbuzz");
				} else if (i % a == 0) {
					fw.write("fizz");
				} else if (i % b == 0) {
					fw.write("buzz");
				} else {
					fw.write(Integer.toString(i));
				}
				fw.write(System.lineSeparator());
			}
			fw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void readFizzBuzz(String filename) {
		try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
			String output;
			while ((output = bufferedReader.readLine()) != null) {
				System.out.println(output);
		    }
		    bufferedReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void writeSerializedObject(String filename, Object obj) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
			oos.writeObject(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void readSerializedObject(String filename) {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
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