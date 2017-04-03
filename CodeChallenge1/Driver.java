package com.Revature.CodeChallenge1;

import java.util.Scanner;

public class Driver {
	public static void main(String[] args){
		String start = 	"AACCGGTT";
		String end = 	"AAACGGTA";
		String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter starting gene: ");
		start = scan.next();
		
		System.out.println("Enter end gene: ");
		end = scan.next();
		
		System.out.println("Enter bank size: ");
		int bankSize = scan.nextInt();
		bank = new String[bankSize];
		
		for(int i = 0; i<bankSize;i++){
			System.out.println("Enter gene " + i + " into bank: ");
			bank[i] = scan.next();
		}
		System.out.println("\n*****PERFORMING MUTATIONS*****\n");
		GeneMutator splicer = new GeneMutator(start, end, bank);
		System.out.println("\nnumber of mutations: " + splicer.countMutations(start,0));
	}
}
