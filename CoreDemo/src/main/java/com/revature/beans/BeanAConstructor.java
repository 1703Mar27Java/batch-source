package com.revature.beans;

public class BeanAConstructor {
	private BeanB b;
	
	public BeanAConstructor(){}
	
	public BeanAConstructor(BeanB b) {
		this();
		this.b = b;
	}
	
	public void methodInBeanA(){
		System.out.println("BeanAConstructor");
		b.methodInBeanB();
	}
}
