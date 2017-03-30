package com.revature.generic;

import java.util.List;

public class GenericDemo {

	public static void main(String[] args) {
		Person peter = new Person();
		peter.setName("Peter");
		/* String[] stringArray = new String[3];
		Person anotherPeter = (Person) someMethod(stringArray); */
		//this is not good 
		
		Person anotherPeter = someBetterMethod(peter,4);
		
		//this will no longer compile! 
		//int someInt = someBetterMethod(peter,4);
		
		
	}
	
	//generics without using generics 
	public static Object someMethod(Object o){
		return o;
	}
	
	public static <A,B> A someBetterMethod (A thing1, B thing2){
		System.out.println(thing1.toString());
		return thing1;
	}
	
	//generic with interface
	//Iterable is an interface, and implementing classes can be used in foreach loops 
	public static int someOtherMethod (List<Iterable> thing1){
		int j = 0;
		for(Iterable i : thing1){
			j++;
		}
		return j;
	}

}
