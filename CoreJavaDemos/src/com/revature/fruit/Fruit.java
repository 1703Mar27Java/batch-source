package com.revature.fruit;

public class Fruit {
	protected int numSeeds;
	
	public Fruit(int seeds)
	{
		this.numSeeds = seeds;
	}

	public int getNumSeeds() {
		return numSeeds;
	}

	public void setNumSeeds(int numSeeds) {
		this.numSeeds = numSeeds;
	}
	
	public void grow()
	{
		System.out.println("fruit is growing!");
	}

	//expected behavior
	//if two objects are equal according to .equals(), calling
	//hashCode() on each should return the same int value
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

	@Override
	public String toString() {
		return "Fruit [numSeeds=" + numSeeds + "]";
	}
}
