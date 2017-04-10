package com.pbjbank.domain;

public class BankAccount{
	
	private int bankID;
	private int userID;
	private String baName;
	private double bal;
		
	public BankAccount() {
		super();
	}
	
	public BankAccount (int bankID){
		this();
		this.bankID = bankID;	
	}
	
	public BankAccount (int bankID, int userID){
		this();
		this.bankID = bankID;
		this.userID = userID;
		
	}
	
	
	public BankAccount (int bankID, int userID, String baName){
		this();
		this.bankID = bankID;
		this.userID = userID;
		this.baName = baName;
	
		
	}
	
	public BankAccount (int bankID, int userID, String baName, double bal){
		this();
		this.bankID = bankID;
		this.userID = userID;
		this.baName = baName;
		this.bal = bal;
		
	}

	public int getBankID() {
		return bankID;
	}

	public void setBankID(int bankID) {
		this.bankID = bankID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getBaName() {
		return baName;
	}

	public void setBaName(String baName) {
		this.baName = baName;
	}

	public double getBal() {
		return bal;
	}

	public void setBal(double bal) {
		this.bal = bal;
	}

	@Override
	public String toString() {
		return "BankAccount [bankID=" + bankID + ", userID=" + userID + ", baName=" + baName + ", bal=" + bal
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
		


}
