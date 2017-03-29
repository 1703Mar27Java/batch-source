package com.revature.fizzbuzz;

import java.io.Serializable;

public class FizzBuzzInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2135248125814529402L;
	private int minValue;
	private int maxValue;
	private int a;
	private int b;

	public FizzBuzzInfo(int minValue, int maxValue, int a, int b) {
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.a = a;
		this.b = b;
	}

	public int getMinValue() {
		return minValue;
	}

	public void setMinValue(int minValue) {
		this.minValue = minValue;
	}

	public int getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
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
		result = prime * result + maxValue;
		result = prime * result + minValue;
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
		if (maxValue != other.maxValue)
			return false;
		if (minValue != other.minValue)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FizzBuzzInfo [minValue=" + minValue + ", maxValue=" + maxValue + ", a=" + a + ", b=" + b + "]";
	}

}
