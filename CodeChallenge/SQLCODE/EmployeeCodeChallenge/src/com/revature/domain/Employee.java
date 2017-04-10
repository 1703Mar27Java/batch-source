package com.revature.domain;

public class Employee {
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int empID, String empFirstName, String empLastName, String empDepartment, String empEmail) {
		super();
		this.empID = empID;
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.empDepartment = empDepartment;
		this.empEmail = empEmail;
	}
	private int empID;
	private String empFirstName;
	private String empLastName;
	private String empDepartment;
	private String empEmail;
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public String getEmpFirstName() {
		return empFirstName;
	}
	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}
	public String getEmpLastName() {
		return empLastName;
	}
	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}
	public String getEmpDepartment() {
		return empDepartment;
	}
	public void setEmpDepartment(String empDepartment) {
		this.empDepartment = empDepartment;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

}
