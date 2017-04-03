package com.revature.MavenDemos;

import org.junit.Test;

import static junit.framework.Assert.*;

public class StringCalculatorTest {

	@Test(expected = RuntimeException.class)
	public final void moreThanTwoThrowsException(){
		StringCalculator.add("1,2,3");
	}
	@Test
	public final void twoNumberReturnsSum(){
		int sum=StringCalculator.add("1,2");
		assertEquals(3, sum);
	}
	@Test(expected=RuntimeException.class)
	public final void nonNumberInputThrowsException(){
		StringCalculator.add("hello");
	}
	
	@Test
	public final void zeroForEmptyString(){
		assertEquals(0,StringCalculator.add(""));
	}
	@Test
	public final void oneParameterReturnsItself(){
		assertEquals(4,StringCalculator.add("4"));
	}
	@Test
	public final void handlesWhiteSpace(){
		assertEquals(5,StringCalculator.add("\t 3 , 2 "));
	}
	
	
	
	
}
