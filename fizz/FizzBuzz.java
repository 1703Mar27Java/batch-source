package com.Revature.Fizz;

import java.io.*;
import java.util.Scanner;
import static java.lang.System.*;

public class FizzBuzz {

	public static void main(String[] args) {
		Scanner scan = new Scanner(in);
		boolean exit = false;
		int n1 = 0, n2 = 0, n3 = 0, n4 = 0;

		// ask for params
		while (!exit) {
			out.println("Please input Parameter One:");
			n1 = scan.nextInt();
			out.println("Please input Parameter Two:");
			n2 = scan.nextInt();
			out.println("Please input Parameter Three:");
			n3 = scan.nextInt();
			out.println("Please input Parameter Four:");
			n4 = scan.nextInt();
			if (n1 < n2)
				exit = true; // allows exit from loop if params are right format
			else
				out.println("Parameter One MUST be less than Parameter Two\n");
		}
		scan.close();

		// File IO
		String fileSerial = "src/com/Revature/Fizz/FizzBuzzOutput";
		String fileOutput = "src/com/Revature/Fizz/FizzBuzzSerialized";
		FizzBuzzInfo FBI = new FizzBuzzInfo(n1, n2, n3, n4);
		writeObject(fileSerial, FBI);

		try {
			FileWriter fr = new FileWriter(fileOutput, false);
			// fizzbuzz algo
			for (int i = n1; i <= n2; i++) {
				if (i % n3 == 0) {
					out.print("fizz");
					fr.write("fizz");
				}
				if (i % n4 == 0) {
					out.print("buzz");
					fr.write("buzz");
				}
				if (i % n3 != 0 && i % n4 != 0) {
					out.print(i);
					fr.write(new Integer(i).toString());
				}
				out.print(" ");
				fr.write(" ");
			}
			out.println();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// helper methods
	static void writeObject(String file, Object obj) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(obj);
			System.out.println(obj);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void readObject(String file) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
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
