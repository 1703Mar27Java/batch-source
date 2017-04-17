package com.revature.bankExceptions;

public class BankException extends Exception {
	private static final long serialVersionUID = 3719187672764064560L;
	public BankException() { super(); }
	public BankException(String message) { super(message); }
}
