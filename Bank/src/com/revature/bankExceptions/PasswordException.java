package com.revature.bankExceptions;

public class PasswordException extends BankException {
	private static final long serialVersionUID = 1670876570742642049L;
	public PasswordException() { super(); }
	public PasswordException(String message) { super(message); }
}
