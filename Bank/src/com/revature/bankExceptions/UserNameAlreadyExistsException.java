package com.revature.bankExceptions;

public class UserNameAlreadyExistsException extends BankException {
	private static final long serialVersionUID = 2767875692578889980L;
	public UserNameAlreadyExistsException() { super(); }
	public UserNameAlreadyExistsException(String message) { super(message); }
}
