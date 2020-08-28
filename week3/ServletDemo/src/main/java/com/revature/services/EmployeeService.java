package com.revature.services;

import java.util.Arrays;
import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Role;
import com.revature.repositories.EmployeeDAO;
import com.revature.repositories.IEmployeeDAO;

public class EmployeeService {
	
	private IEmployeeDAO employeeDao = new EmployeeDAO();
//	private AuthorizationService authService = new AuthorizationService();
	
	public List<Employee> findAll() {
		// TODO: Implement Later to use an actual database
		Employee first = new Employee(1, "Matthew", "Oberlies", new Role(1, "Finance Manager"));
		
		return Arrays.asList(first);
	}
	
	public Employee insert(Employee e) {
		if(e.getId() != 0) {
			// Throw a custom exception
			// since new Employees must have a zero ID
		}
		
//		authService.guard(req, new Role(2, "Finance Manager"));
		
		// TODO: Use EmployeeDAO to insert into database and obtain new ID
		// This performing a fake Insert
		e.setId(2);
		return e;
	}
}
