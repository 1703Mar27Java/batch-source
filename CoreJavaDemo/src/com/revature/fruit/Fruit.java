package com.revature.fruit;

public class Fruit {

	public Fruit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Fruit(int numSeeds){
		this.numSeeds=numSeeds;
	}
	
	public Fruit(String message){
		System.out.println(message);
	}
	
	public Fruit(int numSeeds,String message){
		this.numSeeds=numSeeds;
		System.out.println(message);
	}

	private int numSeeds;

	public void grow(){
		System.out.println("fruit is growing");
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numSeeds;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fruit other = (Fruit) obj;
		if (numSeeds != other.numSeeds)
			return false;
		return true;
	}

	public int getNumSeeds() {
		return numSeeds;
	}

	public void setNumSeeds(int numSeeds) {
		this.numSeeds = numSeeds;
	}

	@Override
	public String toString() {
		return "Fruit [numSeeds=" + numSeeds + "]";
	}

}
