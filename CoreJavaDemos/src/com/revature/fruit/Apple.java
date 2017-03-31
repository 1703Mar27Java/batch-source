package com.revature.fruit;

public class Apple extends Fruit {
	
	private int numSlices;
	
	private String breed;
	
	public Apple(int seeds, int slices, String breedType)
	{
		super(seeds);
		
		this.numSlices = slices;
		
		this.breed = breedType;
	}
	
	@Override
	public String toString()
	{
		return "Apple [numSeeds=" + numSeeds + " numSlices=" + numSlices + " breed=" + breed + "]";
	}
}
