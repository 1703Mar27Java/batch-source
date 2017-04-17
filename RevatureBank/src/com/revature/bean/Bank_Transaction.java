package com.revature.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Bank_Transaction implements Cloneable, Serializable {
	private int BANK_TRANSACTION_ID;
	private int BANK_USER_ID;
	private String BANK_TRANSACTION_DESC;

	public Bank_Transaction() {
		
	}

	public Bank_Transaction(int bANK_TRANSACTION_ID, int bANK_USER_ID, String bANK_TRANSACTION_DESC) {
		super();
		BANK_TRANSACTION_ID = bANK_TRANSACTION_ID;
		BANK_USER_ID = bANK_USER_ID;
		BANK_TRANSACTION_DESC = bANK_TRANSACTION_DESC;
	}

	public int getBANK_TRANSACTION_ID() {
		return BANK_TRANSACTION_ID;
	}

	public void setBANK_TRANSACTION_ID(int bANK_TRANSACTION_ID) {
		BANK_TRANSACTION_ID = bANK_TRANSACTION_ID;
	}

	public int getBANK_USER_ID() {
		return BANK_USER_ID;
	}

	public void setBANK_USER_ID(int bANK_USER_ID) {
		BANK_USER_ID = bANK_USER_ID;
	}

	public String getBANK_TRANSACTION_DESC() {
		return BANK_TRANSACTION_DESC;
	}

	public void setBANK_TRANSACTION_DESC(String bANK_TRANSACTION_DESC) {
		BANK_TRANSACTION_DESC = bANK_TRANSACTION_DESC;
	}

	@Override
	public String toString() {
		return "Bank_Transaction [BANK_TRANSACTION_ID=" + BANK_TRANSACTION_ID + ", BANK_USER_ID=" + BANK_USER_ID
				+ ", BANK_TRANSACTION_DESC=" + BANK_TRANSACTION_DESC + "]";
	}

}
