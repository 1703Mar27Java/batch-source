package com.revature.dao;

import java.util.List;

import com.revature.domain.Employee;

public interface EmpDAO {
	public List<Employee> retrieveEmp();
	public float avgSalary(int deptId);
	public void giveRaise(int deptId, float raise);
}
