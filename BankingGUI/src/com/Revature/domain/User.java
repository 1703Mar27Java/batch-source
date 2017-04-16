package com.Revature.domain;

public class User {
	private int userID;
	private String username;
	private String password;
	private int superPriv;
	
	public User() {
		super();
	}
	public User(String username, String password, int superPriv) {
		super();
		this.username = username;
		this.password = password;
		this.superPriv = superPriv;
	}
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int isSuperPriv() {
		return superPriv;
	}
	public void setSuperPriv(int superPriv) {
		this.superPriv = superPriv;
	}
	
	
}
