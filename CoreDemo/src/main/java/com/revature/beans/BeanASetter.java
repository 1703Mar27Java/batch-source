package com.revature.beans;

public class BeanASetter {
	private BeanB b;
	public void setB(BeanB b){
		this.b = b;
	}
	public void methodInBeanA(){
		System.out.println("BeanASetter");
		b.methodInBeanB();
	}
}
