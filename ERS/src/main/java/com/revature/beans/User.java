package com.revature.beans;

public class User {
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int userID, String firstName, String lastName, String userName, String password, String email,
			UserRole role) {
		super();
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.role = role;
	}
	private int userID;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String email;
	private UserRole role;
	private int userRoleID;
	
	public String getFullName(){
		
		return firstName+" "+lastName;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getFirstName() {
		
		if(firstName== null)
		{
			return " ";
		}
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		
		if(lastName== null)
		{
			return " ";
		}
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserRole getRole() {
		return role;
	}
	public void setRole(UserRole role) {
		this.role = role;
	
	}
	@Override
	public String toString() {
		return "User [userID=" + userID + ", firstName=" + firstName + ", lastName=" + lastName + ", userName="
				+ userName + ", password=" + password + ", email=" + email + ", role=" + role + "]";
	}
	public int getUserRoleID() {
		return userRoleID;
	}
	public void setUserRoleID(int userRoleID) {
		this.userRoleID = userRoleID;
	}
	public void setUserRole(int roleID, String role){
		this.role = new UserRole(roleID,role);
	}
	
	
	

}
