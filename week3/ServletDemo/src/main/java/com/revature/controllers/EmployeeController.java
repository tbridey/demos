package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Employee;
import com.revature.services.EmployeeService;
import com.revature.util.ResponseUtil;

/*
 * Will contain many helper methods for processing requests in regards to Employees
 */
public class EmployeeController {
	
	private ObjectMapper om = new ObjectMapper();
	private EmployeeService employeeService = new EmployeeService();

	public void process(HttpServletRequest req, HttpServletResponse resp, String[] portions)
		throws ServletException, IOException {
		
		if(!portions[0].equals("employees")) {
			// Throw a custom Exception
		}
		
		if(portions.length == 1) {
			// I know some information about this
			// This process method doesn't regard the HTTP Verb, so I might have to check the
			// Verb to figure out what to do
			
			// Alternatively, you could have different methods for different Verbs
			
			// Following RESTful URI patterns, with only 1 portion
			// The request could only be GET, POST, or PUT
			
			String method = req.getMethod();
			
			if(!method.equals("GET") || !method.equals("POST") || !method.equals("PUT")) {
				// Throw a different custom exception
			}
			
			// DELETE generally must include the id in the URI
			
			if(method.equals("GET")) {
				List<Employee> all = employeeService.findAll();
				ResponseUtil.writeJSON(resp, all);
				return;
			}
		}
	}
}
