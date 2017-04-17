package com.revature.bankExceptions;

public class AccountAlreadyExistsException extends BankException {
	private static final long serialVersionUID = -2013306093982336165L;
	public AccountAlreadyExistsException() { super(); }
	public AccountAlreadyExistsException(String message) { super(message); }
}
