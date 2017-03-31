package com.revature.strings;

public class FunWithStrings {

	public static void main(String[] args) {
		//string literals can have 0 or more characters
		//strings are immutable
		//string pool: collection of unique strings in the heap
		//if we use a string literal "dog"
		//the compiler looks for "dog" in the string pool
		//if not, it creates a new literal in the pool
		//(string).equals compares content, not the reference
		//== compares the reference
		
		
		char[] helloArray = {'h', 'e', 'l', 'l', 'o'};
		String helloString = new String(helloArray);
		System.out.println(helloString);
		
		String str = "hello";
		String str2 = str;
		
		System.out.println(str.equals(str2));
		System.out.println(str == str2);
		
		str2 = "hello";
		
		System.out.println(str == str2);
		
		str2 = new String("hello");
		
		System.out.println(str == str2);
		
		//sysout+ctrl+space
		
		//java.lang.Stringbuilder
		/*
		 * mutable sequence of characters
		 * Stringbuilder is not thread safe
		 * preferred when not multithreading
		 */
		
		//java.lang.StringBugger
		/*
		 * mutable sequence of characters
		 * is threadsafe
		 * MUCH SLOWER than Stringbuilder
		 */
	}

}
