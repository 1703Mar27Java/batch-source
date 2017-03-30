package com.revature.fruit;

public class Apple extends Fruit {
	
	public Apple(){
		super();
	}
	
	public Apple(int numSeeds){
		super(numSeeds);
	}

	@Override
	public void grow() {
		// TODO Auto-generated method stub
		super.grow();
	}

	public Apple(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public Apple(int numSeeds, String message) {
		super(numSeeds, message);
		// TODO Auto-generated constructor stub
	}
	
	public int appleMethod(){
		return 7;
	}

}
