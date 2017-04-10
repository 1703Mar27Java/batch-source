package com.revature.BankAssignment.exceptions;

class Overdraft extends Exception{
	public Overdraft() {
		super("You do not have enough funds available to withdraw this amount");
		// TODO Auto-generated constructor stub
	}

	
}
