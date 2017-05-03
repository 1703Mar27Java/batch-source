package com.revature.service;

import org.springframework.stereotype.Component;

@Component(value="bearService")
public class BearService {
	
	private Boolean bearFull = false;
	
	public boolean getBearFull(){
		return bearFull;
	}
	
	public void setBearFull(Boolean bearFull){
		this.bearFull = bearFull;
	}
	
	public void bearHibernates(){
		System.out.println("ZZZZZZZZZZZZ");
	}
	
	public void wakeUpBear(){
		System.out.println("waking up bear");
	}
	
	public void bearChasesYou(){
		System.out.println("AAAAHHHHHH!");
		System.out.println("Bear is chasing you!");
	}
	
	public void bearCatchesYou(){
		System.out.println("Hope he's not hungry");
	}

}
