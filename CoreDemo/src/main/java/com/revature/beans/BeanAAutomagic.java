package com.revature.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanAAutomagic {
		@Autowired //@Inject is pretty much synonymous
		private BeanB b;
		
		public void methodInBeanA(){
			System.out.println("BeanAAutomagic");
			b.methodInBeanB();
		}
		

}
