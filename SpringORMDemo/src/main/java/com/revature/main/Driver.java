package com.revature.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.*;
import com.revature.dao.*;

public class Driver {
	
	public static void main(String[] args){
		
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Dao dao = (Dao) ac.getBean("myDao");
		
		List<Bear> bears = dao.getBears();
		
		System.out.println(bears);
		
	/*Cave c = new Cave("tempusercave3");
		Bear b = new Bear("Jake", 40, c);
		
		dao.makeBear(b);*/
		
		ac.close();
	}

}
