package codeChallenge;

import java.util.*;
import java.util.Scanner;
import java.io.*;

public class FizzBuzz {

	public static void main(String[] args) {
		
		int a;
		int b;
		int c;
		int d;
	Scanner keyboard = new Scanner(System.in);

	System.out.println("Type in the first integer: ");
		a = keyboard.nextInt();
		System.out.println("Type in the second integer: ");
		b = keyboard.nextInt();	
		System.out.println("Type in the third integer: ");
		c = keyboard.nextInt();
		System.out.println("Type in the fourth integer: ");
		d = keyboard.nextInt();
		
	int[] range = {a,b,c,d};
	Arrays.sort(range);
	System.out.println(Arrays.toString(range));
	
	
	
	keyboard.close();
		

	}
	
	

	@Override
	public String toString() {
		return "FizzBuzz [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}