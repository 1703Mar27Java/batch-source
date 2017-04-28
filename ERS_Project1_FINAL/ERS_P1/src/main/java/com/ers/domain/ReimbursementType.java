package com.ers.domain;

public class ReimbursementType {

	private int rt_id;
	private String type;
	
	public ReimbursementType(int rt_id, String type) {
		this.rt_id = rt_id;
		this.type = type;
	}



public int getRt_id() {
	return rt_id;
}

public void setRt_id(int rt_id) {
	this.rt_id = rt_id;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}



@Override
public String toString() {
	return "ReimbursementType [rt_id=" + rt_id + ", type=" + type + "]";
}




}