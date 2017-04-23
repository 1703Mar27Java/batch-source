package com.revature.domain;

public class Employee {
	private int EMPLOYEE_ID;
    private String EMP_FIRSTNAME;
    private String EMP_LASTNAME;
    private int DEPARTMENT_ID;
    private int SALARY;
    private String EMP_EMAIL;
	
    public Employee() {
    	super();
    }
    
    public Employee(int eMPLOYEE_ID, String eMP_FIRSTNAME, String eMP_LASTNAME, int dEPARTMENT_ID, int sALARY, String eMP_EMAIL) {
		this();
		EMPLOYEE_ID = eMPLOYEE_ID;
		EMP_FIRSTNAME = eMP_FIRSTNAME;
		EMP_LASTNAME = eMP_LASTNAME;
		DEPARTMENT_ID = dEPARTMENT_ID;
		SALARY = sALARY;
		EMP_EMAIL = eMP_EMAIL;
	}

	public int getEMPLOYEE_ID() {
		return EMPLOYEE_ID;
	}

	public void setEMPLOYEE_ID(int eMPLOYEE_ID) {
		EMPLOYEE_ID = eMPLOYEE_ID;
	}

	public String getEMP_FIRSTNAME() {
		return EMP_FIRSTNAME;
	}

	public void setEMP_FIRSTNAME(String eMP_FIRSTNAME) {
		EMP_FIRSTNAME = eMP_FIRSTNAME;
	}

	public String getEMP_LASTNAME() {
		return EMP_LASTNAME;
	}

	public void setEMP_LASTNAME(String eMP_LASTNAME) {
		EMP_LASTNAME = eMP_LASTNAME;
	}

	public int getDEPARTMENT_ID() {
		return DEPARTMENT_ID;
	}

	public void setDEPARTMENT_ID(int dEPARTMENT_ID) {
		DEPARTMENT_ID = dEPARTMENT_ID;
	}

	public int getSALARY() {
		return SALARY;
	}

	public void setSALARY(int sALARY) {
		SALARY = sALARY;
	}

	public String getEMP_EMAIL() {
		return EMP_EMAIL;
	}

	public void setEMP_EMAIL(String eMP_EMAIL) {
		EMP_EMAIL = eMP_EMAIL;
	}

	@Override
	public String toString() {
		return "Employee [EMPLOYEE_ID=" + EMPLOYEE_ID + ", EMP_FIRSTNAME=" + EMP_FIRSTNAME + ", EMP_LASTNAME="
				+ EMP_LASTNAME + ", DEPARTMENT_ID=" + DEPARTMENT_ID + ", SALARY=" + SALARY + ", EMP_EMAIL=" + EMP_EMAIL
				+ "]";
	}
}
