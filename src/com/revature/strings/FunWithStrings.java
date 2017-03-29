package com.revature.strings;

public class FunWithStrings {
	public static void main(String[] args) {
		/*char[] helloArray = { 'h', 'e', 'l', 'l', 'o' };
		String helloString = new String(helloArray);
		System.out.println(helloString);*/
		String s = new String("Hel");
		s=s.concat("log");
		s=s.substring(0,5);
		s= String.format("%s Worlds", s);
		if(s.endsWith("s"))s=s.replace('s', ' ');
		s=s.trim();
		
		s+='3';
		StringBuilder sb = new StringBuilder(s);
		StringBuffer bb = new StringBuffer(s);
		
		sb.deleteCharAt(11);
		bb.deleteCharAt(11);
		//doesnt do what is desired, replaces all non-letter characters with spaces instead of removing all non-whitespace, non-letter characters
		s=s.replaceAll("[^a-zA-Z ]+","");
		System.out.println(s);
		System.out.println(sb);
		System.out.println(bb);
	}
}
