package com.revature.service;

import org.springframework.stereotype.Component;

@Component(value="tigerService")
public class TigerService {
	
	private Boolean tigerFull = true; //tigers eat before they nap

	public void wakeUpTiger(){
		System.out.println("waking up tiger!");
	}
	
	public void tigerChasesYou(){
		System.out.println("AAAAHHHHHH!");
		System.out.println("Tiger is chasing you!");
	}
	
	public void tigerCatchesYou(){
		System.out.println("Hope he's not hungry");
	}

	public Boolean getTigerFull() {
		return tigerFull;
	}

	public void setTigerFull(Boolean tigerFull) {
		this.tigerFull = tigerFull;
	}
	
}
