package com.revature.scopes;

class SuperClass {
	int x = 10;
	static int y = 20;
	
	public void getNumber() {
		System.out.println(50);
	}
}

class SubClass extends SuperClass {
	//SubClass hides SuperClass variables with same names
	int x = 30;
	static int y = 40;
	
	public void getNumber()
	{
		System.out.println(60);
	}
	
	public void doSubClassThing()
	{
		System.out.println("doing thing");
	}
}

public class Shadowing {
	public static void main(String[] args) {
		SubClass subClass = new SubClass();
		
		System.out.println(subClass.x);
		System.out.println(SubClass.y);
		
		SuperClass superClass = subClass; //implicit upcast
		
		System.out.println(superClass.x);
		System.out.println(SuperClass.y);
		
		//what about instance methods?
		
		subClass.getNumber();
		superClass.getNumber();
		
		//polymorphic override of instance method
		
		subClass.doSubClassThing();
		//at compile time, JVM looks at declared type only
		//so this cast is necessary
		((SubClass) superClass).doSubClassThing();
		
		SuperClass anotherSuper = new SuperClass();
		SubClass anotherSub = (SubClass) anotherSuper;
		
		//this will result in a class cast exception
		//unlike superClass it was not originally cast up from a subClass
		anotherSub.doSubClassThing();
	}
}
