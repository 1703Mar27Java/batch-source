package com.Revature.domain;

public class SimpleReimb {
	private int id;
	private double amount;
	private String description;
	private int submitterID;
	
	public SimpleReimb() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SimpleReimb(int id, double amount, String description, int submitterID) {
		super();
		this.id = id;
		this.amount = amount;
		this.description = description;
		this.submitterID = submitterID;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getSubmitterID() {
		return submitterID;
	}
	public void setSubmitterID(int submitterID) {
		this.submitterID = submitterID;
	}
	
	
}
