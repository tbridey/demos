package com.revature.services;

import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Role;
import com.revature.repositories.EmployeeDAO;
import com.revature.repositories.IEmployeeDAO;
import com.revature.templates.LoginTemplate;

public class EmployeeService {
	
	public static final Role FINANCE_MANAGER = new Role(1, "Finance Manager");
	public static final Role EMPLOYEE = new Role(2, "Employee");
	
	private IEmployeeDAO employeeDao;
	
	public EmployeeService() {
		super();
		this.employeeDao = new EmployeeDAO();
	}
	
	// For mocking if desired
	public EmployeeService(IEmployeeDAO employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}

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
	
	public Employee findById(int id) {
		return employeeDao.findById(id);
	}
	
	public boolean update(Employee e) {
		return employeeDao.update(e);
	}
}
