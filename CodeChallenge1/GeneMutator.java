package com.Revature.CodeChallenge1;

public class GeneMutator {
	private String start;
	private String end;
	private String[] bank;

	public GeneMutator(String s, String e, String[] b) {
		start = s;
		end = e;
		bank = b;
	}

	//recursively modifies starting string character by character
	public int countMutations(String s, int i) { 
		int numMutations = 0;
		if (s.equals(end)) {
			return numMutations;
		}
		if (s.charAt(i) != end.charAt(i)) {
			System.out.println(s.charAt(i) + " not equal to " + end.charAt(i) + " at index " + i);
			// mutates string s by only 1 character
			String mutated = s.substring(0, i)+end.charAt(i)+s.substring(i + 1, s.length());
			System.out.println("mutation: " + mutated);
			
			if (inBank(mutated)) {
				// if so, repeat process for mutated string
				numMutations = 1 + countMutations(mutated, 0);
			}else{
				//if not, go to next character
				numMutations = countMutations(s, i+1);
			}
		}else{
			numMutations = countMutations(s, i+1);
		}
		return numMutations;
	}

	public boolean inBank(String s) {
		for (int i = 0; i < bank.length; i++) {
			if (s.equals(bank[i])) {
				return true;
			}
		}
		return false;
	}

}
