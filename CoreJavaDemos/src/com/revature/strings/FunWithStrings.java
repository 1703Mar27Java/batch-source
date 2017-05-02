package com.revature.strings;

import java.util.Arrays;

public class FunWithStrings {

	public static void main(String[] args) {
		//string literals can have O or more characters 
		//strings are immutable
		//string pool: collection of unique strings on the heap 
		//if we use a string literal "dog"
		//compiler looks for "dog" in the string pool
		//if exists, returns a reference to that literal, 
		//if not, creates a new literal in the pool 
		//(string).equals compares the content, not the reference
		//== compares the reference 
		
		char[] helloArray = {'h','e','l','l','o'};
		String helloString = new String(helloArray);
		System.out.println(helloString);
		
		String str = "hello";
		String str2 = str;
		System.out.println(str.equals(str2));
		System.out.println(str==str2);
		str2 = "hello";
		System.out.println(str.equals(str2));
		System.out.println(str==str2);
		str2 = new String("hello");
		System.out.println(str.equals(str2));
		System.out.println(str==str2);
		//sysout+ctrl+space
		
		//indexOf
		String str3 = "the quick brown fox jumps over the lazy dog";
		System.out.println(str3.indexOf('k'));
		
		//isEmpty
		System.out.println(str3.isEmpty());
		
		//format
		String s = "hello";
		s = String.format("%s world", s);
		System.out.println(s);
	
		//toUppercase
		String s1 = "have a nice day";
		System.out.println(s1.toUpperCase());
		
		//charAt
		String s2 = "this is a test string";
		System.out.println("the second character is "+s2.charAt(1));
		
		//split
		String s3 = "  hello world";
		String[] returned = s3.split(" ");
		System.out.println(Arrays.toString(returned));
		
		//contains
		String s4 = "submarine";
		System.out.println(s4.contains("sub"));
		
		//substring
		String s5 = "thisisastring";
		System.out.println(s5.substring(4,5));
		
		//concat
		String s6 = "hello";
		String s7 = "world";
		System.out.println(s6.concat(s7));
		
		//getChars
		String s8  = "aloha";
		char[] array = new char[5];
		s8.getChars(0,2,array,1);
		System.out.println(array);
		
		//replace
		String s9 = "I am a string :)";
		String s10 = s9.replace(')','(');
		System.out.println(s10);
		
		//StringBuffer
		StringBuffer sb = new StringBuffer("doom");
		sb.reverse();
		System.out.println(sb);
		
		//StringBuilder
		StringBuilder sbuild = new StringBuilder("doom");
		sbuild.reverse();
		System.out.println(sbuild);
		
		//getBytes
		String s11 = "racecar";
		System.out.println(s11.getBytes());
		
		
		
		//java.lang.StringBuilder
		/*
		 * mutable sequence of characters
		 * not threadsafe
		 * preferred 
		 */
		//java.lang.StringBuffer
		/*
		 * mutable sequence of characters
		 * threadsafe 
		 * MUCH SLOWER
		 */
		
	}

}
