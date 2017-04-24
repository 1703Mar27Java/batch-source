package com.Revature.domain;

public class User {
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int userID;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private int userRoleID;
	
	public User(String username, String pass, String firstname, String lastname, String email, int userRoleid){
		this.username = username;
		this.password = pass;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.userRoleID = userRoleid;
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
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getUserRoleID() {
		return userRoleID;
	}
	public void setUserRoleID(int userRoleID) {
		this.userRoleID = userRoleID;
	}
	
	
}
