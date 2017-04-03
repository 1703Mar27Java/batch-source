package com.revature.minmutation;

import java.util.Scanner;

public class MutationDriver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String start;
		String end;
		String[] bank;
		int bankSize;

		System.out.print("Enter start: ");
		start = sc.nextLine();			
		System.out.print("Enter end: ");
		end = sc.nextLine();			
		System.out.print("Enter bank size: ");
		bankSize = sc.nextInt();
		sc.nextLine();
		bank = new String[bankSize];
		for (int i = 0; i < bank.length; i++) {
			System.out.print("Enter bank gene " + (i+1) + ": ");
			bank[i] = sc.nextLine();						
		}
		sc.close();
		
		MutationUtility mu = new MutationUtility(start, end, bank);
		mu.Result();

	}

}
