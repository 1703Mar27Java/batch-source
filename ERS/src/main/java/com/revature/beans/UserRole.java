package com.revature.beans;

public class UserRole {
	
	public UserRole(int userRoleID, String userRole) {
		super();
		this.userRoleID = userRoleID;
		this.userRole = userRole;
	}
	private int userRoleID;
	private String userRole;
	public int getUserRoleID() {
		return userRoleID;
	}
	public void setUserRoleID(int userRoleID) {
		this.userRoleID = userRoleID;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	@Override
	public String toString() {
		return "UserRole [userRoleID=" + userRoleID + ", userRole=" + userRole + "]";
	}
	

}
