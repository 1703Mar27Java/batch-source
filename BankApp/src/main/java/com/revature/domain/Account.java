package com.revature.domain;

public class Account {
	private int BANK_ACCOUNT_ID;
	private int USER_ID;
	private String BANK_ACCOUNT_NAME;
	private int BALANCE;
	
	public Account() {
		super();
	}
	
	public Account(int uSER_ID, String bANK_ACCOUNT_NAME, int bALANCE) {
		this();
		USER_ID = uSER_ID;
		BANK_ACCOUNT_NAME = bANK_ACCOUNT_NAME;
		BALANCE = bALANCE;
	}

	public int getBANK_ACCOUNT_ID() {
		return BANK_ACCOUNT_ID;
	}

	public void setBANK_ACCOUNT_ID(int bANK_ACCOUNT_ID) {
		BANK_ACCOUNT_ID = bANK_ACCOUNT_ID;
	}

	public int getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(int uSER_ID) {
		USER_ID = uSER_ID;
	}

	public String getBANK_ACCOUNT_NAME() {
		return BANK_ACCOUNT_NAME;
	}

	public void setBANK_ACCOUNT_NAME(String bANK_ACCOUNT_NAME) {
		BANK_ACCOUNT_NAME = bANK_ACCOUNT_NAME;
	}

	public int getBALANCE() {
		return BALANCE;
	}

	public void setBALANCE(int bALANCE) {
		BALANCE = bALANCE;
	}

	@Override
	public String toString() {
		return BANK_ACCOUNT_NAME + " ACCOUNT BALANCE = $" + BALANCE;
	}
}
