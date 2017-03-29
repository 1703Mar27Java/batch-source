package com.revature.io;

import java.io.*;
import java.util.Scanner;

public class Serialize {

	public static void main(String[] args) {

		// String fileName = "src/serializedThings/PersonDemo";

		// Person person = new Person("john", 23, "123456789");
		// writeObject(fileName, person);
		// readObject(fileName);

		Scanner sc = new Scanner(System.in);
		int minRange = sc.nextInt();
		int maxRange = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();

		String fizzBuzzFile = "src/serializedThings/FizzBuzzParameters";
		FizzBuzzInfo fbi = new FizzBuzzInfo(minRange, maxRange, a, b);

		/////////////////////////////////////////// EXAMPLE ASSIGNMENT/////////////////////////////////////////////////////////////////////////////////////////////////
		
		for (int i = minRange; i < maxRange; i++) {
			if (i % a == 0 && i % b == 0)
				System.out.println(" fizzbuzz ");
			else if (i % a == 0)
				System.out.println(" fizz ");
			else if (i % b == 0)
				System.out.println(" buzz ");
			else
				System.out.println(Integer.toString(i));
		}

		//writeObject(fizzBuzzFile, fbi);
		readObject(fizzBuzzFile);
		
		

		/*
		 * try (FileWriter fw = new FileWriter(fizzBuzzFile)) {
		 * 
		 * for (int i = minRange; i < maxRange; i++) { if (i % a == 0 && i % b
		 * == 0) fw.write(" fizzbuzz "); else if (i % a == 0)
		 * fw.write(" fizz "); else if (i % b == 0) fw.write(" buzz "); else
		 * fw.write(Integer.toString(i)); }
		 * 
		 * fw.write(fbi.toString()); } catch (IOException e) {
		 * e.printStackTrace(); }
		 * 
		 * try (FileReader fr = new FileReader(fizzBuzzFile)) { String loaded =
		 * new String(); fr.rea System.out.println(loaded); } catch
		 * (FileNotFoundException e) { e.printStackTrace(); } catch (IOException
		 * e) { e.printStackTrace(); }
		 */

	}

	static void writeObject(String fileName, Object obj) {

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
			oos.writeObject(obj);
			System.out.println(obj);

		} catch (IOException e) {
			e.printStackTrace();
		}

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
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
