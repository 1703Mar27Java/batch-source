package com.Revature.domain;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Timestamp;

public class Reimbursement {
	private int id;
	private double amount;
	private String description;
	private InputStream receipt;
	private Timestamp timestamp;
	private Timestamp timestamp2;
	private int submitterID;
	private int resolverID;
	private int typeID;
	private int statusID;
	
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
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
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public InputStream getReceipt() {
		return receipt;
	}
	public void setReceipt(InputStream receipt) {
		this.receipt = receipt;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	
	public Timestamp getTimestamp2() {
		return timestamp2;
	}
	public void setTimestamp2(Timestamp timestamp) {
		this.timestamp2 = timestamp;
	}
	
	public int getSubmitterID() {
		return submitterID;
	}
	public void setSubmitterID(int submitterID) {
		this.submitterID = submitterID;
	}
	public int getResolverID() {
		return resolverID;
	}
	public void setResolverID(int resolverID) {
		this.resolverID = resolverID;
	}
	public int getTypeID() {
		return typeID;
	}
	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}
	public int getStatusID() {
		return statusID;
	}
	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}
}
