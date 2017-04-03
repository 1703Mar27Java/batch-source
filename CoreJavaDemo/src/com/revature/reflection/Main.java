package com.revature.reflection;
import java.lang.reflect.Field;
import com.revature.io.Person;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException {
	Class clazz = Class.forName("com.revature.io.Person");

	System.out.println(clazz.getName());
	
	//print fields
	Field[] fields=clazz.getDeclaredFields();
	for(Field field : fields){
		System.out.println(field.getName());
	}
	
	Person joe=(Person) clazz.newInstance();
	System.out.println(joe);
	
	Field age= clazz.getDeclaredField("age");
	age.setAccessible(true);
	
	age.set(joe, -10000);
	
	System.out.println(joe);
	
	}

}
