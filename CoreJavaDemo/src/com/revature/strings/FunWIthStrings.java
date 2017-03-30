package com.revature.strings;

public class FunWIthStrings {

	public static void main(String[] args) {
		//string literals can have 0 or more characters
		//strings literals are immutable, meaning they can not be changed
		//string pool: collection of unique strings on the heap
		//if we use a string literal "dog" 
		//compiler looks for "dog" in the string pool
		//if exists, returns a reference to that literal,
		//if not, creates a new literal in the pool
		//(string).equals compares the content, not the reference
		//== compare the reference

	char[] helloArray = {'h','e','l','l','o'};
	String helloString=new String(helloArray);
	System.out.println(helloString);
	
	String str= "hello";
	String str2=str;
	System.out.println(str.equals(str2));
	System.out.println(str==str2);
	str2="hello";
	System.out.println(str.equals(str2));
	System.out.println(str==str2);
	str2= new String("hello");
	System.out.println(str.equals(str2));
	System.out.println(str==str2);
	//sysout+ctrl+space
	
	//java.lang.StringBuilder
	/*
	 * mutable sequence of characters
	 * not threadsafe
	 */
	//java.lang.StringBuffer
/*
 * mutable sequence of characters
 * threadsafe
 * MUCH SLOWER
 */
	
	StringBuilder builder=new StringBuilder();
	builder.insert(0, "thisisastring");
	System.out.println(builder);
	builder.append("+moredata");
	System.out.println(builder);
	
	StringBuffer buffer=new StringBuffer();
	buffer.insert(0, "thisisastring");
	System.out.println(buffer);
	buffer.append("+moredata");
	System.out.println(buffer);
	
	
	System.out.println(str.indexOf('l'));
	System.out.println(str.charAt(1));
	System.out.println(str.compareTo(str2));
	System.out.println(str.compareTo("abcd"));
	System.out.println(str.compareTo("Z"));
	System.out.println(str.substring(2,4));
	System.out.println(str.contentEquals(builder));
	
	
	
	
	}

}
