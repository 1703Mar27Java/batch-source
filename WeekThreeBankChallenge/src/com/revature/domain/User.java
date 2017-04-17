package com.revature.domain;

public class User {
	private String userName;
	private String password;
	private int userID;
	
	public User(){
		super();
	}
	public User(String userName, String password){
		this.userName = userName;
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int id){
		this.userID = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", userID=" + userID + ", password=" + password + "]";
	}
	
	
}

