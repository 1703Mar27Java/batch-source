package com.revature.minmutation;

import java.util.Arrays;

public class MutationUtility {

	private String start;
	private String end;
	private String[] bank;
	String defaultStart = "AACCGGTT";
	String defaultEnd = "AAACGGTA";
	String[] defaultBank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
	
	public MutationUtility (String start, String end, String[] bank) {
		this.start = start;
		this.end = end;
		this.bank = bank;
		
		if ((start.length() < 8) || (end.length() < 8)) {
			this.start = defaultStart;
			this.end = defaultEnd;
			this.bank = defaultBank;			
		}	
	}
	
	public void Result () {
		String current = start;
		int mutations = 0;
		for (int i = 0; i < bank.length; i++) {
			if (current != end) {
				int count = 0;
				for (int j = 0; j < current.length(); j++) {
					if (!(current.charAt(j) == bank[i].charAt(j))) {
						count++;
					}
				}
				if (count == 1) {
					current = bank[i];
					mutations++;
				}
			} else {
				break;
			}
		}
		System.out.println("start: " + start);
		System.out.println("end: " + end);
		System.out.println("bank: " + Arrays.toString(bank));
		
		System.out.println("return: " + mutations);
	}
}
