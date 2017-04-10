package com.revature.dao;

import java.util.List;

import com.revature.domain.Department;


public interface DepartmentDao {
	public void createDepartment(Department account);
	public Department retrieveDepartmentById(int id);
	public List<Department> retrieveAllDepartment();
}
