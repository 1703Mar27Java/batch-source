package com.Revature.beans;

import java.util.ArrayList;

public class Bean {
	public Bean(ArrayList<BankAcct> bankList) {
		super();
		this.bankList = bankList;
	}

	private ArrayList<BankAcct> bankList;

	public ArrayList<BankAcct> getBankList() {
		return bankList;
	}

	public void setBankList(ArrayList<BankAcct> bankList) {
		this.bankList = bankList;
	}

	@Override
	public String toString() {
		return "Bean [bankList=" + bankList + "]";
	}
}
