package com.revature.codechallenge;

import java.util.LinkedList;
import java.util.List;

public class Mutation {

	private static String startGene = new String("AACCGGTT");
	private static String endGene = new String("ATGCGGTA");
	private static List<String> geneBank = new LinkedList<>();

	public static void main(String[] args) {

		Logic newLogic = new Logic();
		System.out.println("Start: " + startGene);
		System.out.println("End: " + endGene);
		System.out.println("Number of mutations: " + newLogic.MutationCount(startGene, endGene, geneBank));
	}

}

class Logic {
	public int MutationCount(String startGene, String endGene, List<String> geneBank) {

		// Counter for the total of mutations required to match the End Gene
		int counter = 0;
		StringBuilder gene = new StringBuilder();
		gene.append(startGene);
		geneBank.add(startGene);

		// If Start and End are equal
		// return 0 cause there is no mutation
		if (startGene.equalsIgnoreCase(endGene)) {
			geneBank.add(endGene);
			System.out.println(geneBank);
			return 0;
		}

		// If either of the Strings have no gene
		// return -1 cause there is nothing to mutation to or from
		if (startGene.isEmpty() || endGene.isEmpty())
			return -1;

		// While the mutated string does not equal the end string
		while (endGene.compareTo(gene.toString()) != 0) {
			for (int i = 0; i < startGene.length(); i++) {
				if (!(startGene.charAt(i) == endGene.charAt(i))) {
					counter++;
					gene.setCharAt(i, endGene.charAt(i));
					geneBank.add(gene.toString());
				}
			}
		}

		// Print out our entire geneBank to see the changes
		System.out.println(geneBank);
		return counter;
	}
}