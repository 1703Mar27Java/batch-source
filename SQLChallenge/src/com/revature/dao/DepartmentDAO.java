package com.revature.dao;

import com.revature.domain.Department;

public interface DepartmentDAO {
public void Create(Department department);
public void Update(Department department);
public void Delete(Department department);
public void RetrieveNameAndAvgSalary(Department department);
}
