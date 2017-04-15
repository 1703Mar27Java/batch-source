package com.revature.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Bank_User implements Cloneable, Serializable {
	private int BANK_USER_ID;
	private String BANK_USER_NAME;
	private String BANK_USER_PASSWORD;

	public Bank_User() {

	}

	public Bank_User(int BANK_USER_IDIn) {

		this.BANK_USER_ID = BANK_USER_IDIn;

	}

	public int getBANK_USER_ID() {
		return this.BANK_USER_ID;
	}

	public void setBANK_USER_ID(int BANK_USER_IDIn) {
		this.BANK_USER_ID = BANK_USER_IDIn;
	}

	public String getBANK_USER_NAME() {
		return this.BANK_USER_NAME;
	}

	public void setBANK_USER_NAME(String BANK_USER_NAMEIn) {
		this.BANK_USER_NAME = BANK_USER_NAMEIn;
	}

	public String getBANK_USER_PASSWORD() {
		return this.BANK_USER_PASSWORD;
	}

	public void setBANK_USER_PASSWORD(String BANK_USER_PASSWORDIn) {
		this.BANK_USER_PASSWORD = BANK_USER_PASSWORDIn;
	}

	public void setAll(int BANK_USER_IDIn, String BANK_USER_NAMEIn, String BANK_USER_PASSWORDIn) {
		this.BANK_USER_ID = BANK_USER_IDIn;
		this.BANK_USER_NAME = BANK_USER_NAMEIn;
		this.BANK_USER_PASSWORD = BANK_USER_PASSWORDIn;
	}

	public boolean hasEqualMapping(Bank_User valueObject) {

		if (valueObject.getBANK_USER_ID() != this.BANK_USER_ID) {
			return (false);
		}
		if (this.BANK_USER_NAME == null) {
			if (valueObject.getBANK_USER_NAME() != null)
				return (false);
		} else if (!this.BANK_USER_NAME.equals(valueObject.getBANK_USER_NAME())) {
			return (false);
		}
		if (this.BANK_USER_PASSWORD == null) {
			if (valueObject.getBANK_USER_PASSWORD() != null)
				return (false);
		} else if (!this.BANK_USER_PASSWORD.equals(valueObject.getBANK_USER_PASSWORD())) {
			return (false);
		}

		return true;
	}

	public String toString() {
		StringBuffer out = new StringBuffer();
		out.append("\nclass USERS, mapping to table USERS\n");
		out.append("Persistent attributes: \n");
		out.append("BANK_USER_ID = " + this.BANK_USER_ID + "\n");
		out.append("USER_NAME = " + this.BANK_USER_NAME + "\n");
		out.append("PASSWORD = " + this.BANK_USER_PASSWORD + "\n");
		return out.toString();
	}
}