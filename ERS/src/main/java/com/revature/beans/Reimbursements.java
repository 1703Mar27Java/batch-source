package com.revature.beans;

import java.sql.Blob;
import java.sql.Timestamp;

public class Reimbursements {

	public Reimbursements(double rAmount, String rDescription, User rAuthor, int typeID) {
		super();
		this.rAmount = rAmount;
		this.rDescription = rDescription;
		this.rAuthor = rAuthor;
		this.setTypeID(typeID);
	}

	public Reimbursements(int rId, double rAmount, Timestamp submitted, Timestamp resolved, String rDescription,
			Blob rReceipt, User rAuthor, User rResolver, int statusID, int typeID, ReimbursementsStatus rStatus,
			ReimbursementsType rType) {
		super();
		this.rId = rId;
		this.rAmount = rAmount;
		Submitted = submitted;
		this.resolved = resolved;
		this.rDescription = rDescription;
		this.rReceipt = rReceipt;
		this.rAuthor = rAuthor;
		this.rResolver = rResolver;
		this.setStatusID(statusID);
		this.setTypeID(typeID);
		this.rStatus = rStatus;
		this.rType = rType;
	}

	public Reimbursements() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reimbursements(int rId, double rAmount, Timestamp submitted, Timestamp resolved, String rDescription,
			 User rAuthor, User rResolver, ReimbursementsStatus rStatus, ReimbursementsType rType) {
		super();
		this.rId = rId;
		this.rAmount = rAmount;
		Submitted = submitted;
		this.resolved = resolved;
		this.rDescription = rDescription;
		this.rAuthor = rAuthor;
		this.rResolver = rResolver;
		this.rStatus = rStatus;
		this.rType = rType;
	}

	public Reimbursements(int rId, double rAmount, Timestamp submitted, Timestamp resolved, String rDescription,
			Blob rReceipt, User rAuthor, User rResolver, ReimbursementsStatus rStatus, ReimbursementsType rType) {
		super();
		this.rId = rId;
		this.rAmount = rAmount;
		Submitted = submitted;
		this.resolved = resolved;
		this.rDescription = rDescription;
		this.rReceipt = rReceipt;
		this.rAuthor = rAuthor;
		this.rResolver = rResolver;
		this.rStatus = rStatus;
		this.rType = rType;
		
	}

	private int rId;
	private double rAmount;
	private Timestamp Submitted;
	private Timestamp resolved;
	private String rDescription;
	private Blob rReceipt;
	private String Receipt;
	private User rAuthor;
	private User rResolver;
	private int statusID;
	private int typeID;
	private ReimbursementsStatus rStatus;
	private ReimbursementsType rType;

	@Override
	public String toString() {
		return "Reimbursements [rId=" + rId + ", rAmount=" + rAmount + ", Submitted=" + Submitted + ", resolved="
				+ resolved + ", rDescription=" + rDescription + ", rReceipt=" + rReceipt + ", rAuthor=" + rAuthor
				+ ", rResolver=" + rResolver + ", rStatus=" + rStatus + ", rType=" + rType + "]";
	}

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

	public double getrAmount() {
		return rAmount;
	}

	public void setrAmount(double rAmount) {
		this.rAmount = rAmount;
	}

	public Timestamp getSubmitted() {
		return Submitted;
	}

	public void setSubmitted(Timestamp submitted) {
		this.Submitted = submitted;
	}

	public Timestamp getResolved() {
		return resolved;
	}

	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}

	public String getrDescription() {
		return rDescription;
	}

	public void setrDescription(String rDescription) {
		this.rDescription = rDescription;
	}

	public Blob getrReceipt() {
		return rReceipt;
	}

	public void setrReceipt(Blob rReceipt) {
		this.rReceipt = rReceipt;
	}

	public User getrAuthor() {
		return rAuthor;
	}

	public void setrAuthor(User rAuthor) {
		this.rAuthor = rAuthor;
	}

	public User getrResolver() {
		return rResolver;
	}

	public void setrResolver(User rResolver) {
		this.rResolver = rResolver;
	}

	public ReimbursementsStatus getrStatus() {
		return rStatus;
	}

	public void setrStatus(ReimbursementsStatus rStatus) {
		this.rStatus = rStatus;
	}

	public ReimbursementsType getrType() {
		return rType;
	}

	public void setrType(ReimbursementsType rType) {
		this.rType = rType;
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
