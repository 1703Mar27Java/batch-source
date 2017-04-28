package com.revature.domain;

public class Employee {

	private int employeeID;
	private String employeeUsername;
	private String employeePassword;
	private String employeeFirstname;
	private String employeeLastname;
	private String employeeEmail;
	private Roles userRoleID;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int employeeID, String employeeUsername, String employeePassword, String employeeFirstname,
			String employeeLastname, String employeeEmail, Roles userRoleID) {
		super();
		this.employeeID = employeeID;
		this.employeeUsername = employeeUsername;
		this.employeePassword = employeePassword;
		this.employeeFirstname = employeeFirstname;
		this.employeeLastname = employeeLastname;
		this.employeeEmail = employeeEmail;
		this.userRoleID = userRoleID;
	}

	public Employee(String employeeUsername, String employeePassword, String employeeFirstname, String employeeLastname,
			String employeeEmail, Roles userRoleID) {
		super();
		this.employeeUsername = employeeUsername;
		this.employeePassword = employeePassword;
		this.employeeFirstname = employeeFirstname;
		this.employeeLastname = employeeLastname;
		this.employeeEmail = employeeEmail;
		this.userRoleID = userRoleID;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int i) {
		this.employeeID = i;
	}

	public String getEmployeeUsername() {
		return employeeUsername;
	}

	public void setEmployeeUsername(String employeeUsername) {
		this.employeeUsername = employeeUsername;
	}

	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	public String getEmployeeFirstname() {
		return employeeFirstname;
	}

	public void setEmployeeFirstname(String employeeFirstname) {
		this.employeeFirstname = employeeFirstname;
	}

	public String getEmployeeLastname() {
		return employeeLastname;
	}

	public void setEmployeeLastname(String employeeLastname) {
		this.employeeLastname = employeeLastname;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public Roles getUserRoleID() {
		return userRoleID;
	}

	public void setUserRoleID(Roles userRoleID) {
		this.userRoleID = userRoleID;
	}

	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", employeeUsername=" + employeeUsername + ", employeePassword="
				+ employeePassword + ", employeeFirstname=" + employeeFirstname + ", employeeLastname="
				+ employeeLastname + ", employeeEmail=" + employeeEmail + ", userRoleID=" + userRoleID + "]";
	}
	
	
	
}
