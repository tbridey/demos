package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.EmployeeController;

@WebServlet(urlPatterns = {"/rest/*"})
// Normally, I would use just /* However, this create a url-pattern clash
// With the other Servlets
// So I will instead use /rest/*
public class FrontController extends HttpServlet {
	
	private EmployeeController employeeController;
	
	public FrontController() {
		super();
		employeeController = new EmployeeController();
	}
	
	public FrontController(EmployeeController controller) {
		super();
		employeeController = controller;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final String URI = req.getRequestURI().replace("/ServletDemo/rest", "");
		
		System.out.println(URI);
		
		if(URI.charAt(0) != '/') {
			resp.setStatus(400); // Bad Request
			return;
		}
		
		final String resource = URI.replaceFirst("/", "").split("/")[0];
		
		String[] portions = URI.replaceFirst("/", "").split("/");
		
		// This could change as we develop further
		// Because maybe I want to support more complex URI patterns
		// in the future
		if(portions.length >= 3) {
			resp.setStatus(400); // Bad Request
			return;
		}
		
		switch(resource) {
		case "employees":
			// I could put all logic here
			// But could make switch statement very long
			
			// Instead, Delegate to another helper
			employeeController.process(req, resp, portions);
			
			break;
		case "reimbursements":
			break;
		default:
			resp.setStatus(400); // Bad Request
			return;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}
}
