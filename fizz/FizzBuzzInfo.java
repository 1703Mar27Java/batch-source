package com.Revature.Fizz;

import java.io.*;

public class FizzBuzzInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6398842710522460077L;
	int n1, n2, n3, n4;
	
	
	//Constructors
	public FizzBuzzInfo(){}
	public FizzBuzzInfo(int n1, int n2, int n3, int n4){
		super();
		this.n1=n1;
		this.n2=n2;
		this.n3=n3;
		this.n4=n4;
	}
	//Getters/Setters
	public int getN1() {
		return n1;
	}

	public void setN1(int n1) {
		this.n1 = n1;
	}

	public int getN2() {
		return n2;
	}

	public void setN2(int n2) {
		this.n2 = n2;
	}

	public int getN3() {
		return n3;
	}

	public void setN3(int n3) {
		this.n3 = n3;
	}

	public int getN4() {
		return n4;
	}

	public void setN4(int n4) {
		this.n4 = n4;
	}
	@Override
	public String toString() {
		return "FizzBuzzInfo [n1=" + n1 + ", n2=" + n2 + ", n3=" + n3 + ", n4=" + n4 + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + n1;
		result = prime * result + n2;
		result = prime * result + n3;
		result = prime * result + n4;
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
		if (n1 != other.n1)
			return false;
		if (n2 != other.n2)
			return false;
		if (n3 != other.n3)
			return false;
		if (n4 != other.n4)
			return false;
		return true;
	}
	
}
