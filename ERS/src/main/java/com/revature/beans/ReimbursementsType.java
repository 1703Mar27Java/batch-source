package com.revature.beans;

public class ReimbursementsType {
	
	public ReimbursementsType(int typeID, String type) {
		super();
		this.typeID = typeID;
		this.type = type;
	}
	public ReimbursementsType() {
		super();
	}
	private int typeID;
	private String type;
	public int getTypeID() {
		return typeID;
	}
	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "ReimbursementsType [typeID=" + typeID + ", type=" + type + "]";
	}

}
