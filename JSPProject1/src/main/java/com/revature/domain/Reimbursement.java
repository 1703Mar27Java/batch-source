package com.revature.domain;

public class Reimbursement {
	private int rID;
	private double amt;
	private String desc;
	private String receipt;
	private String submitted;
	private String resolved;
	private int author;
	private int resolver;
	private int rTtype;
	private int rTstatus;
	
	public Reimbursement(int uID){
		this.author = uID;
	}
	
	public int getrID() {
		return rID;
	}
	public void setrID(int rID) {
		this.rID = rID;
	}
	public double getAmt() {
		return amt;
	}
	public void setAmt(double amt) {
		this.amt = amt;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getReceipt() {
		return receipt;
	}
	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}
	public String getSubmitted() {
		return submitted;
	}
	public void setSubmitted(String submitted) {
		this.submitted = submitted;
	}
	public String getResolved() {
		return resolved;
	}
	public void setResolved(String resolved) {
		this.resolved = resolved;
	}
	public int getAuthor() {
		return author;
	}
	public void setAuthor(int author) {
		this.author = author;
	}
	public int getResolver() {
		return resolver;
	}
	public void setResolver(int resolver) {
		this.resolver = resolver;
	}
	public int getrTtype() {
		return rTtype;
	}
	public void setrTtype(int rTtype) {
		this.rTtype = rTtype;
	}
	public int getrTstatus() {
		return rTstatus;
	}
	public void setrTstatus(int rTstatus) {
		this.rTstatus = rTstatus;
	}
	@Override
	public String toString() {
		return "Reimbursement [rID=" + rID + ", amt=" + amt + ", desc=" + desc + ", receipt=" + receipt + ", submitted="
				+ submitted + ", resolved=" + resolved + ", author=" + author + ", resolver=" + resolver + ", rTtype="
				+ rTtype + ", rTstatus=" + rTstatus + "]";
	}
	
	
}
