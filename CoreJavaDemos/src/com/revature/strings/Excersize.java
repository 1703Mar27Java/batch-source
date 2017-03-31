package com.revature.strings;

public class Excersize {

	public static void main(String[] args) {
		String exampleString = "the quick brown fox jumps over the lazy dog";
		String exampleString2 = "tHe qUiCk BrOwn fOX JuMps oVEr the LaZy Dog";
		
		System.out.println(exampleString.indexOf('k'));
		System.out.println(exampleString.charAt(8));
		
		//compareTo returns 0 if compared strings are equal
		System.out.println(exampleString.compareTo(exampleString2));
		
		System.out.println(exampleString.compareToIgnoreCase(exampleString2));
		
		System.out.println(exampleString.startsWith("the quick brown fox"));
		
		StringBuilder builder = new StringBuilder(exampleString);
		StringBuffer buffer = new StringBuffer(exampleString);
		
		System.out.println(builder.lastIndexOf("dog"));
		System.out.println(buffer.lastIndexOf("dog"));
		
	}

}
