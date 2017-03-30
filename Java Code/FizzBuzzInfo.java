package com.revature.FizzBuzz;

import java.io.Serializable;
import java.util.Arrays;

public class FizzBuzzInfo implements Serializable {

	private static final long serialVersionUID = -5237615957420857741L;

	public int param1;
	public int param2;
	public int range1;
	public int range2;
	public int[] range;

	public FizzBuzzInfo() {
	};

	public FizzBuzzInfo(int param1, int param2, int range1, int range2) {

		super();
		this.param1 = param1;
		this.param2 = param2;
		this.range1 = range1;
		this.range2 = range2;

	}

	public int getParam1() {
		return param1;
	}

	public void setParam1(int param1) {
		this.param1 = param1;
	}

	public int getParam2() {
		return param2;
	}

	public void setParam2(int param2) {
		this.param2 = param2;
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
		result = prime * result + param1;
		result = prime * result + param2;
		result = prime * result + range1;
		result = prime * result + range2;
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
		if (param1 != other.param1)
			return false;
		if (param2 != other.param2)
			return false;
		if (range1 != other.range1)
			return false;
		if (range2 != other.range2)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FizzBuzzInfo [param1=" + param1 + ", param2=" + param2 + ", range1=" + range1 + ", range2=" + range2
				+ ", range=" + Arrays.toString(range) + "]";
	};
	

}
