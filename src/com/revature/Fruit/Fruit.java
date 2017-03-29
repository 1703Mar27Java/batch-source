package com.revature.Fruit;
class Fruit{
	private int numSeeds;
	private int result;
	public Fruit(){
		result = 1;
	}
	public Fruit(int numSeeds)
	{
		this.numSeeds=numSeeds;
	}
	public Fruit(int numSeeds, int result){
		this(numSeeds);
		this.result = result;
	}
	@Override
	public String toString() {
		return "Fruit [numSeeds=" + numSeeds + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
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
	public void grown(){
		System.out.println("fruit is growing");
	}
}