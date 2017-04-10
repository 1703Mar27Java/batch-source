package com.revature.domain;

public class Department {
	private int DEPARTMENT_ID;
	private String DEPARTMENT_NAME;
	
	public Department() {
		super();
	}
	
	public Department(int dEPARTMENT_ID, String dEPARTMENT_NAME) {
		this();
		DEPARTMENT_ID = dEPARTMENT_ID;
		DEPARTMENT_NAME = dEPARTMENT_NAME;
	}

	public int getDEPARTMENT_ID() {
		return DEPARTMENT_ID;
	}

	public void setDEPARTMENT_ID(int dEPARTMENT_ID) {
		DEPARTMENT_ID = dEPARTMENT_ID;
	}

	public String getDEPARTMENT_NAME() {
		return DEPARTMENT_NAME;
	}

	public void setDEPARTMENT_NAME(String dEPARTMENT_NAME) {
		DEPARTMENT_NAME = dEPARTMENT_NAME;
	}

	@Override
	public String toString() {
		return "Department [DEPARTMENT_ID=" + DEPARTMENT_ID + ", DEPARTMENT_NAME=" + DEPARTMENT_NAME + "]";
	}
}
