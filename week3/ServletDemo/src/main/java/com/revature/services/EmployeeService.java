package com.revature.services;

import java.util.List;

import com.revature.models.Employee;
import com.revature.repositories.EmployeeDAO;
import com.revature.repositories.IEmployeeDAO;
import com.revature.templates.LoginTemplate;

public class EmployeeService {
	
	private IEmployeeDAO employeeDao = new EmployeeDAO();
	
	public Employee login(LoginTemplate lt) {
		
		Employee e = employeeDao.findByUsername(lt.getUsername());
		
		if(e == null) {
			// Instead throw custom exception
			return null;
		}
		
		if(e.getPassword().equals(lt.getPassword())) {
			return e;
		}
		
		return null;
	}
	
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}
	
	public Employee insert(Employee e) {
		return employeeDao.insert(e);
	}
}
