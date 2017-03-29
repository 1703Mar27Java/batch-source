package com.revature.strings;

public class Exercise {

	public static void main(String[] args) {
		
		String str = "Hello";
		StringBuilder sbr = new StringBuilder(str);
		StringBuffer sbf = new StringBuffer(str);
		
		// 5 String methods
		System.out.println(str.contains("e"));
		System.out.println(str.concat(", World!"));
		System.out.println(str.length());
		System.out.println(str.indexOf('l'));
		System.out.println(str.isEmpty());
		
		// 1 StringBuilder method
		System.out.println(sbr.reverse());
		
		// 1 StringBuffer method
		System.out.println(sbf.reverse());

	}
}