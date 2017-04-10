package com.revature.BankAssignment.exceptions;

public class IncorrectPassword extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IncorrectPassword() {
		super("The password you entered was incorrect");
		
	}

	
}
