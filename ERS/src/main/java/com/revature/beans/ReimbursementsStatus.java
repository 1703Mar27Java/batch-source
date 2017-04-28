package com.revature.beans;

public class ReimbursementsStatus {
	
	
	public ReimbursementsStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReimbursementsStatus(String status, int statusID) {
		super();
		this.status = status;
		this.statusID = statusID;
	}
	private String status;
	private int statusID;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getStatusID() {
		return statusID;
	}
	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}
	@Override
	public String toString() {
		return "ReimbursementsStatus [status=" + status + ", statusID=" + statusID + "]";
	}
	

}
