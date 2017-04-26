package com.revature.domain;

public class UserRoles {
	private String urRole;
	private int urID;

	
	public UserRoles(){
		super();
	}
	
	public UserRoles(String urRole){
		this.urRole = urRole;
	}
	
	public int getUrID() {
		return urID;
	}

	public void setUrID(int urID) {
		this.urID = urID;
	}

	public String getUrRole() {
		return urRole;
	}

	public void setUrRole(String urRole) {
		this.urRole = urRole;
	}

	@Override
	public String toString() {
		return "UserRoles [urID=" + urID + ", urRole=" + urRole + "]";
	}
	
}
