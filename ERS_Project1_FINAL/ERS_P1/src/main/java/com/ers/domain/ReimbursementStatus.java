package com.ers.domain;

public class ReimbursementStatus {

	
	private int rs_id;
	private String rs_status;
	
	public ReimbursementStatus(int rs_id, String rs_status) {
		this.rs_id = rs_id;
		this.rs_status = rs_status;
	}




public int getRs_id() {
	return rs_id;
}

public void setRs_id(int rs_id) {
	this.rs_id = rs_id;
}

public String getRs_status() {
	return rs_status;
}

public void setRs_status(String rs_status) {
	this.rs_status = rs_status;
}




@Override
public String toString() {
	return "ReimbursementStatus [rs_id=" + rs_id + ", rs_status=" + rs_status + "]";
}




}