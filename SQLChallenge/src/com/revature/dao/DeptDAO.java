package com.revature.dao;

import java.util.List;

import com.revature.domain.Department;

public interface DeptDAO {
	public List<Department> retrieveDept();
	public String retrieveDeptName(int deptId);
}
