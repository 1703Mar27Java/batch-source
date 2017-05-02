package com.revature.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BeanB implements InitializingBean, DisposableBean{
	
	private String message;
	
	public void setMessage(String message){
		this.message = message;
		System.out.println("setting message");
	}
	public void getMessage(){
		System.out.println("your message: "+message);
	}
	
	public void methodInBeanB() {
		System.out.println("BeanB");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("destroyed");
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet");
		
	}
	
	public void defaultInit(){
		System.out.println("default init");
	}
	
	
	public void defaultDestroy(){
		System.out.println("default destroy");
	}

}
