package com.revature.bankExceptions;

public class UserDoesntExistException extends BankException {
	private static final long serialVersionUID = -129312369383234293L;
	public UserDoesntExistException() { super(); }
	public UserDoesntExistException(String message) { super(message); }
}
