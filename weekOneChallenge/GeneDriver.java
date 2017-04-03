package com.revature.weekOneChallenge;

public class GeneDriver {

	public static void main(String[] args) {
		StringBuilder startGene = new StringBuilder();
		StringBuilder endGene = new StringBuilder();
		
		StringBuilder bankOne = new StringBuilder();
		StringBuilder bankTwo = new StringBuilder();
		StringBuilder bankThree = new StringBuilder();
		StringBuilder[] bank = {bankOne, bankTwo, bankThree};
		
		
		GeneUtility gene = new GeneUtility(startGene, endGene, bank);
		
		System.out.println(gene.mutate(gene.getStartGene(), gene.getEndGene(), gene.getGeneBank()));

	}

}
