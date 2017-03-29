package com.revature.Fruit;

public class Apple extends Fruit {
	public Apple(){
	}
	public Apple(int numSeeds){
		super(numSeeds);
	}
	public Apple(int numSeeds, int result){
		super(numSeeds,result);
	}
	// counts may be any number of int arguments -- example of var args
	public void countSeeds(int...counts)
	{
		int temp = 0;
		for(int i : counts){
			temp+=i;
		}
		setNumSeeds(temp);
	}
}
