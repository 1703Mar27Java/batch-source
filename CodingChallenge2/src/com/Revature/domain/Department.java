package com.Revature.domain;

public class Department {
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Department(int id, String name, double sal) {
		super();
		this.id = id;
		this.name = name;
		this.salary = sal;
	}
	private int id;
	private String name;
	private double salary;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary(){
		return salary;
	}
	public void setSalary(double amt){
		this.salary = amt;
	}
	
}
