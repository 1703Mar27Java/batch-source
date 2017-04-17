package com.revature.bankExceptions;

public class BankBalanceException extends BankException {
	private static final long serialVersionUID = 6777412897145925527L;
	public BankBalanceException() { super(); }
	public BankBalanceException(String message) { super(message); }
}
