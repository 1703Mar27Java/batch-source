package com.Revature.dao;
import java.util.List;

import com.Revature.domain.Department;;

public interface DepartmentDAO {
	public List<Department> departmentSalary();
	public void giveRaise(int amt);
}
