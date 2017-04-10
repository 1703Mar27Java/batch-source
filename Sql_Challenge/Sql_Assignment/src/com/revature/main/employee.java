package com.revature.main;

public class employee {
	public int Employee_Id;
	public String firstName;
	public String lastName;
	public int Department_ID;
	public  int salary;
	public String empEmail;
	
	
	
	public employee() {
		super();
		// TODO Auto-generated constructor stub
	}



	public employee(int employee_Id, String firstName, String lastName, int department_ID, int salary,
			String empEmail) {
		super();
		Employee_Id = employee_Id;
		this.firstName = firstName;
		this.lastName = lastName;
		Department_ID = department_ID;
		this.salary = salary;
		this.empEmail = empEmail;
	}

	


	public employee(String firstName, String lastName, int department_ID, int salary, String empEmail) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		Department_ID = department_ID;
		this.salary = salary;
		this.empEmail = empEmail;
	}



	public int getEmployee_Id() {
		return Employee_Id;
	}



	public void setEmployee_Id(int employee_Id) {
		Employee_Id = employee_Id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public int getDepartment_ID() {
		return Department_ID;
	}



	public void setDepartment_ID(int department_ID) {
		Department_ID = department_ID;
	}



	public int getSalary() {
		return salary;
	}



	public void setSalary(int salary) {
		this.salary = salary;
	}



	public String getEmpEmail() {
		return empEmail;
	}



	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}



	@Override
	public String toString() {
		return "employee [Employee_Id=" + Employee_Id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", Department_ID=" + Department_ID + ", salary=" + salary + ", empEmail=" + empEmail + "]";
	}
	
}
