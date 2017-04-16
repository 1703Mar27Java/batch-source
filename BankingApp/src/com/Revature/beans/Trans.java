package com.Revature.beans;

public class Trans {
	
	public Trans(int transId, int userId, String action) {
		super();
		TransId = transId;
		UserId = userId;
		Action = action;
	}
	private int TransId, UserId;
	private String Action;
	
	public int getTransId() {
		return TransId;
	}
	public void setTransId(int transId) {
		TransId = transId;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getAction() {
		return Action;
	}
	public void setAction(String action) {
		Action = action;
	}
	@Override
	public String toString() {
		return "Trans [TransId=" + TransId + ", UserId=" + UserId + ", Action=" + Action + "]";
	}
}
