package com.revature.weekOneChallenge;

public class GeneUtility {
	
	private StringBuilder startGene;
	private StringBuilder endGene;
	private StringBuilder[] geneBank;

	
	public StringBuilder getStartGene() {
		return startGene;
	}

	public void setStartGene(StringBuilder startGene) {
		this.startGene = startGene;
	}

	public StringBuilder getEndGene() {
		return endGene;
	}

	public void setEndGene(StringBuilder endGene) {
		this.endGene = endGene;
	}

	public StringBuilder[] getGeneBank() {
		return geneBank;
	}

	public void setGeneBank(StringBuilder[] geneBank) {
		this.geneBank = geneBank;
	}

	public GeneUtility()
	{
		
	}
	
	public GeneUtility(StringBuilder startGene, StringBuilder endGene, StringBuilder[] geneBank)
	{
		this.startGene = startGene;
		this.endGene = endGene;
		this.geneBank = geneBank;
	}
	


	int mutate(StringBuilder startGene, StringBuilder endGene, StringBuilder[]bank)
	{	
		if(startGene.equals(endGene)) return 0;
		
		int count = -1;
		
		int[] geneDiff= {1,1,1,1,1,1,1,1};
		for(int i = 0; i < 8; i++)
		{
			if(startGene.charAt(i) == endGene.charAt(i))
			{
				geneDiff[i] = 0;
			}
		}
		
		for(int j = 0; j < bank.length - 1; j++)
		{
			for(int k = 0; k < 8; k++)
			{
				if(bank[j].charAt(k) == endGene.charAt(k))
				{
					geneDiff[k]= 0;
					count++;
				}
			}
		}




		
		return count;
	}

}
