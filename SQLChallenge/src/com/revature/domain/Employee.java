package com.revature.domain;

public class Employee {
private int employeeID;
private String firstname;
private String lastname;
private int departmentID;
private double salary;
private String email;
public int getEmployeeID() {
	return employeeID;
}
public Employee(int employeeID, String firstname, String lastname, int departmentID, double salary, String email) {
	super();
	this.employeeID = employeeID;
	this.firstname = firstname;
	this.lastname = lastname;
	this.departmentID = departmentID;
	this.salary = salary;
	this.email = email;
}
@Override
public String toString() {
	return "Employee [employeeID=" + employeeID + ", firstname=" + firstname + ", lastname=" + lastname
			+ ", departmentID=" + departmentID + ", salary=" + salary + ", email=" + email + "]";
}
public void setEmployeeID(int employeeID) {
	this.employeeID = employeeID;
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
public int getDepartmentID() {
	return departmentID;
}
public void setDepartmentID(int departmentID) {
	this.departmentID = departmentID;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
}
