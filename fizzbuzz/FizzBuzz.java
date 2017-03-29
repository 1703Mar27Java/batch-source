package com.revature.fizzbuzz;

import java.io.*;
import java.util.Arrays;

public class FizzBuzz implements Serializable{
	//these will be serialized
	private int[] parameters;
	private String rangeSpelledOut;
	
	public FizzBuzz(){}
	
	public FizzBuzz(int[] parameters, String rso){
		super();
		this.parameters = parameters;
		this.rangeSpelledOut = rso;
	}

	public int[] getParameters() {
		return parameters;
	}

	public void setParameters(int[] parameters) {
		this.parameters = parameters;
	}

	public String getRangeSpelledOut() {
		return rangeSpelledOut;
	}

	public void setRangeSpelledOut(String rangeSpelledOut) {
		this.rangeSpelledOut = rangeSpelledOut;
	}

	@Override
	public String toString() {
		return "FizzBuzz [parameters=" + Arrays.toString(parameters) + ", rangeSpelledOut=" + rangeSpelledOut + "]";
	}
 
	
}
