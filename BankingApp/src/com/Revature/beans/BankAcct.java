package com.Revature.beans;

public class BankAcct {
	private int bid,uid;
	private String aName, uName;
	private double bal;
	
	public BankAcct(int bid, int uid, String aName, String uName, double bal) {
		super();
		this.bid = bid;
		this.uid = uid;
		this.aName = aName;
		this.uName = uName;
		this.bal = bal;
	}
	public BankAcct(int bid, String aName, double bal) {
		super();
		this.bid = bid;
		this.aName = aName;
		this.bal = bal;
	}
	
	
	
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getaName() {
		return aName;
	}
	public void setaName(String aName) {
		this.aName = aName;
	}
	public double getBal() {
		return bal;
	}
	public void setBal(double bal) {
		this.bal = bal;
	}
	@Override
	public String toString() {
		return "BankAcct [bid=" + bid + ", uid=" + uid + ", aName=" + aName + ", uName=" + uName + ", bal=" + bal + "]";
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
}
