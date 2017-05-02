package com.revature.beans;

public class BeanAByType {
	
	private BeanB b;
	public void setB(BeanB b){
		this.b = b;
	}
	public void methodInBeanA(){
		System.out.println("BeanAByType");
		b.methodInBeanB();
	}

}
