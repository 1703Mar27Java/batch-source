package com.revature.io;

import java.io.*;

public class FizzBuzzInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7040299110065156214L;
	int value1, value2, range1, range2;
	
	public FizzBuzzInfo(){}
	
	public FizzBuzzInfo(int value1, int value2, int range1, int range2){
		super();
		this.value1 = value1;
		this.value2 = value2;
		this.range1 = range1;
		this.range2 = range2;
	}

	public int getValue1() {
		return value1;
	}

	public void setValue1(int value1) {
		this.value1 = value1;
	}

	public int getValue2() {
		return value2;
	}

	public void setValue2(int value2) {
		this.value2 = value2;
	}

	public int getRange1() {
		return range1;
	}

	public void setRange1(int range1) {
		this.range1 = range1;
	}

	public int getRange2() {
		return range2;
	}

	public void setRange2(int range2) {
		this.range2 = range2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + range1;
		result = prime * result + range2;
		result = prime * result + value1;
		result = prime * result + value2;
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
		if (range1 != other.range1)
			return false;
		if (range2 != other.range2)
			return false;
		if (value1 != other.value1)
			return false;
		if (value2 != other.value2)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FizzBuzzInfo [value1=" + value1 + ", value2=" + value2 + ", range1=" + range1 + ", range2=" + range2
				+ "]";
	}
	
}
