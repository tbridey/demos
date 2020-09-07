package com.revature.repositories;

import java.util.List;

import com.revature.models.Employee;

public interface IEmployeeDAO {

	public Employee findById(int id);
	
	public Employee findByUsername(String username);
	
	public List<Employee> findAll();
	
	public Employee insert(Employee e);
	
	public boolean update(Employee e);
	
	public boolean delete(int id);
}
