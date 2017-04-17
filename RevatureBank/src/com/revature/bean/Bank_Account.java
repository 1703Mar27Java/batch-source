package com.revature.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Bank_Account implements Cloneable, Serializable {
	private int BANK_ACCOUNT_ID;
	private int BANK_USER_ID;
	private String BANK_ACCOUNT_NAME;
	private double BANK_ACCOUNT_BALANCE;

	public Bank_Account() {

	}

	public Bank_Account(int BANK_ACCOUNT_IDIn) {

		this.BANK_ACCOUNT_ID = BANK_ACCOUNT_IDIn;

	}

	public int getBANK_ACCOUNT_ID() {
		return this.BANK_ACCOUNT_ID;
	}

	public void setBANK_ACCOUNT_ID(int BANK_ACCOUNT_IDIn) {
		this.BANK_ACCOUNT_ID = BANK_ACCOUNT_IDIn;
	}

	public int getBANK_USER_ID() {
		return this.BANK_USER_ID;
	}

	public void setBANK_USER_ID(int BANK_USER_IDIn) {
		this.BANK_USER_ID = BANK_USER_IDIn;
	}

	public String getBANK_ACCOUNT_NAME() {
		return this.BANK_ACCOUNT_NAME;
	}

	public void setBANK_ACCOUNT_NAME(String BANK_ACCOUNT_NAMEIn) {
		this.BANK_ACCOUNT_NAME = BANK_ACCOUNT_NAMEIn;
	}

	public double getBANK_ACCOUNT_BALANCE() {
		return this.BANK_ACCOUNT_BALANCE;
	}

	public void setBANK_ACCOUNT_BALANCE(double BANK_ACCOUNT_BALANCEIn) {
		this.BANK_ACCOUNT_BALANCE = BANK_ACCOUNT_BALANCEIn;
	}

	public void setAll(int BANK_ACCOUNT_IDIn, int BANK_USER_IDIn, String BANK_ACCOUNT_NAMEIn,
			double BANK_ACCOUNT_BALANCEIn) {
		this.BANK_ACCOUNT_ID = BANK_ACCOUNT_IDIn;
		this.BANK_USER_ID = BANK_USER_IDIn;
		this.BANK_ACCOUNT_NAME = BANK_ACCOUNT_NAMEIn;
		this.BANK_ACCOUNT_BALANCE = BANK_ACCOUNT_BALANCEIn;
	}

	public boolean hasEqualMapping(Bank_Account valueObject) {

		if (valueObject.getBANK_ACCOUNT_ID() != this.BANK_ACCOUNT_ID) {
			return (false);
		}
		if (valueObject.getBANK_USER_ID() != this.BANK_USER_ID) {
			return (false);
		}
		if (this.BANK_ACCOUNT_NAME == null) {
			if (valueObject.getBANK_ACCOUNT_NAME() != null)
				return (false);
		} else if (!this.BANK_ACCOUNT_NAME.equals(valueObject.getBANK_ACCOUNT_NAME())) {
			return (false);
		}
		if (valueObject.getBANK_ACCOUNT_BALANCE() != this.BANK_ACCOUNT_BALANCE) {
			return (false);
		}

		return true;
	}

	public String toString() {
		StringBuffer out = new StringBuffer();
		out.append("\nclass Bank_Account, mapping to table Bank_Account\n");
		out.append("Persistent attributes: \n");
		out.append("BANK_ACCOUNT_ID = " + this.BANK_ACCOUNT_ID + "\n");
		out.append("BANK_USER_ID = " + this.BANK_USER_ID + "\n");
		out.append("BANK_ACCOUNT_NAME = " + this.BANK_ACCOUNT_NAME + "\n");
		out.append("BANK_ACCOUNT_BALANCE = " + this.BANK_ACCOUNT_BALANCE + "\n");
		return out.toString();
	}
}
