package cc.dao;

import cc.domain.*;
import java.util.*;

public interface DAOInterface {			
		
			public void createNewEmployeePS(Employee Employee);
			public Employee retrieveEmployee(String Employee);
			public List<Employee> retrieveEmployees();
			public void updateEmployee(Employee Employee);
			public void deleteEmployee(String employee);
		
	
	
}
