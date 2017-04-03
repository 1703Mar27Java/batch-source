package com.revature.generic;

import java.util.List;

public class GenericDemo {

	
	
	public static void main(String[] args) {
		Person peter=new Person();
		peter.setName("Peter");
		/*String[] stringArray=new String[3];
		Person anotherPeter=(Person) someMethod(stringArray);*/
		//this is not good
		
		Person anotherPeter=someBetterMethod(peter);
		int someInt=someBetterMethod(3);
		

	}
//generics without using generics
	
	public static Object someMethod(Object o){
		return o;
	}
	
	public static <T> T someBetterMethod (T thing){
		return thing;
	}
	
	//generic with interface
	//iterable is an interface, and implementing classes can be used in foreach loops
	public static int someOtherMethod(List<Iterable> thing1){
		int j=0;
		for(Iterable i: thing1){
			j++;
		}
		return j;
	}
}
