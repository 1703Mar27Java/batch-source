package com.revature.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Animal;
import com.revature.beans.Bear;
import com.revature.service.ForestService;

public class Driver {
	public static void main(String[] args){
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
	
		ForestService fc = (ForestService) ac.getBean("forestService");
		
		/*Animal a = fc.getRandomAnimal();
		System.out.println(a);*/
		
		Bear b = fc.getBearByName("Jake");
		System.out.println(b);
	
	
	}

}
