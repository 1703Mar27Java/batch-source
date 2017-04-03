package com.revature.week1;

import java.util.Scanner;

public class Week1Challenge {

	public static void main(String[] args) {
		Scanner genes = new Scanner(System.in);
		StringBuilder build = new StringBuilder();
		char[] gene = new char[7];
		
		
		System.out.print("Please enter a 8 char-long string");
		System.out.println("which includes either A, C, G, T");
		
		for(int i = 0; i < 8; i++)
		{
			System.out.println("Start: " +(gene = genes.next().toString()));
		}
		
		for(int i = 0; i < 8; i++)
		{
			System.out.println("End: " +(gene = genes.next().toString(0)));
		}
		
		
	} 

}
