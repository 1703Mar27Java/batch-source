package com.pbjbank.domain;

//import java.util.Scanner;

public class User_Logon {

	
	private int userID;
	private String userName;
	private String password;
	
	
	
	public User_Logon(){
		super();
	}
	

	/*public User_Logon(int userID) {
		this();
		this.userName = userName;
		this.password = password;
	}
	
	public User_Logon(int userID, String userName) {
		this();
		this.userName = userName;
		
	} */

	
	public User_Logon(int userID, String userName, String password) {
		this();
		this.userID = userID;
		this.userName = userName;
		this.password = password;
	}
	
	
	public int getuserID(){
		return userID;
		
	}

	public void setUserID(int userID){
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	
	
		
	
	
	@Override
	public String toString() {
		return "User_Logon [userID=" + userID + ", userName=" + userName + ", password=" + password + "]";
	}


	
	
	
	
}
