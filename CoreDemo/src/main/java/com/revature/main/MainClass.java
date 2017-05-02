package com.revature.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.*;

public class MainClass {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		/*BeanASetter beanA1 = (BeanASetter) context.getBean("beanASetter");
		beanA1.methodInBeanA();
		
		BeanAConstructor beanA2 = (BeanAConstructor) context.getBean("beanAConstructor");
		beanA2.methodInBeanA();
		
		BeanAByType beanA3 = (BeanAByType) context.getBean("beanAByType");
		beanA3.methodInBeanA();
		
		BeanAByName beanA4 = (BeanAByName) context.getBean("beanAByName");
		beanA4.methodInBeanA();
		
		BeanAAutomagic beanA5 = (BeanAAutomagic) context.getBean("beanAAutomagic");
		beanA5.methodInBeanA();*/
		
		/*BeanASetter test = new BeanASetter();
		BeanB testb = new BeanB();
		test.setB(testb);
		test.methodInBeanA();*/
		BeanB lifeBean = (BeanB) context.getBean("beanB");
		lifeBean.methodInBeanB();
		lifeBean.getMessage();
		
		//((AbstractApplicationContext)context).close();

	}

}
