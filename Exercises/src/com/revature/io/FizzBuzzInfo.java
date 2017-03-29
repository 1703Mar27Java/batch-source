package com.revature.io;

import java.io.Serializable;

public class FizzBuzzInfo implements Serializable {
	
	public FizzBuzzInfo() {};
	
	public FizzBuzzInfo(int minRange, int maxRange, int a, int b) {
		super();
		this.minRange = minRange;
		this.maxRange = maxRange;
		this.a = a;
		this.b = b;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 7407699073618198322L;
	private int minRange;
	private int maxRange;
	private int a;
	private int b;
	@Override
	public String toString() {
		return "FizzBuzzInfo [minRange=" + minRange + ", maxRange=" + maxRange + ", a=" + a + ", b=" + b + "]";
	}
	public int getMinRange() {
		return minRange;
	}
	public void setMinRange(int minRange) {
		this.minRange = minRange;
	}
	public int getMaxRange() {
		return maxRange;
	}
	public void setMaxRange(int maxRange) {
		this.maxRange = maxRange;
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + a;
		result = prime * result + b;
		result = prime * result + maxRange;
		result = prime * result + minRange;
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
		FizzBuzzInfo other = (FizzBuzzInfo) obj;
		if (a != other.a)
			return false;
		if (b != other.b)
			return false;
		if (maxRange != other.maxRange)
			return false;
		if (minRange != other.minRange)
			return false;
		return true;
	}

}
