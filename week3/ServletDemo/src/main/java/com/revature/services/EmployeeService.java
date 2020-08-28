package com.revature.services;

import java.util.Arrays;
import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Role;
import com.revature.repositories.EmployeeDAO;
import com.revature.repositories.IEmployeeDAO;

public class EmployeeService {
	
	private IEmployeeDAO employeeDao = new EmployeeDAO();
	
	public List<Employee> findAll() {
		// TODO: Implement Later to use an actual database
		Employee first = new Employee(1, "Matthew", "Oberlies", new Role(1, "Finance Manager"));
		
		return Arrays.asList(first);
	}
}
