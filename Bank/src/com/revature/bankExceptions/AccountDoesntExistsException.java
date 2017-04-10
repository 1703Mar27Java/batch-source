package com.revature.bankExceptions;

public class AccountDoesntExistsException extends BankException {
	private static final long serialVersionUID = -5298794212376743508L;
	public AccountDoesntExistsException() { super(); }
	public AccountDoesntExistsException(String message) { super(message); }
}
