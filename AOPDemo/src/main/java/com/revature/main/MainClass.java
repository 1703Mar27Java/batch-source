package com.revature.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.service.BearService;
import com.revature.service.TigerService;

public class MainClass {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		BearService bs = (BearService) context.getBean("bearService");
		
		bs.bearHibernates();
		
		bs.wakeUpBear();
		
		bs.bearChasesYou();
		
		bs.bearCatchesYou();
		
		TigerService ts = (TigerService) context.getBean("tigerService");
		
		ts.wakeUpTiger();
		
		ts.tigerChasesYou();
		
		ts.tigerCatchesYou();
		
	}

}
