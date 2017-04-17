package com.revature.Domain;

public class User {

	public String userName;
	public String Password;
	public int userID;
	public Boolean superUser;
	
	public User() {
		super();
	}

	public User(int userId, String userName, String password,Boolean superUser) {
		this();
		this.userID = userId;
		this.userName = userName;
		this.Password = password;
		this.superUser = superUser;
	}
	public Boolean getSuperUser() {
		return superUser;
	}

	public void setSuperUser(Boolean superUser) {
		this.superUser = superUser;
	}

	public User(String userName, String password, Boolean superUser) {
		this();
		this.userName = userName;
		this.Password = password;
		this.superUser = superUser;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", Password=" + Password + ", userID=" + userID + "]";
	}
	
}
