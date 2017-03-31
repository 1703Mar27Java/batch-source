package com.revature.generic;
import com.revature.io.Person;

public class GenericDemo {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Person peter = new Person();
		peter.setName("Peter");
		/*
		 * This is not good:
		 * 
		 * String[] stringArray = new String[3];
		 * Person anotherPeter = (Person) someMethod(stringArray);
		 */
		
		Person anotherPeter = someBetterMethod(peter);
		
		int someInt = someBetterMethod(3);
		
	}
	
	public static Object someMethod(Object o)
	{
		return o;
	}
	
	public static <T> T someBetterMethod(T thing)
	{
		return thing;
	}
	
	/*
	public static int someOtherMethod (List<Iterable> thing1)
	{
		int j = 0;
		
		for(Iterable i : thing1)
		{
			j++;
		}
		
		return j;
	}
	*/

 }
