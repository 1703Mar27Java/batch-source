package com.revature.beans;

public class BeanAByName {
	
	private BeanB beanB; //this must match the name of the injected class in metadata
	public void setBeanB(BeanB beanB){
		this.beanB = beanB;
	}
	public void methodInBeanA(){
		System.out.println("BeanAByName");
		beanB.methodInBeanB();
	}


}
