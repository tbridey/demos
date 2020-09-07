package com.revature.delegates;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Employee;
import com.revature.services.AuthorizationService;
import com.revature.services.EmployeeService;
import com.revature.util.RequestUtil;
import com.revature.util.ResponseUtil;
import static com.revature.services.EmployeeService.*;

public class EmployeeDelegate implements Delegate {
	
	private ObjectMapper om;
	private EmployeeService employeeService;
	private AuthorizationService authService;
	
	public EmployeeDelegate() {
		super();
		this.om = new ObjectMapper();
		this.employeeService = new EmployeeService();
		this.authService = new AuthorizationService();
	}
	
	// For mocking if desired
	public EmployeeDelegate(ObjectMapper om, EmployeeService employeeService, AuthorizationService authService) {
		super();
		this.om = om;
		this.employeeService = employeeService;
		this.authService = authService;
	}

	@Override
	public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = (String) req.getAttribute("path");
		
		String[] portions = path.split("/");
		
		switch(portions.length) {
		case 1:
			handleGroup(req, resp);
			break;
		case 2:
			// This try-catch will handle input parsing
			// in case the id provided isn't actually a number
			try {
				handleSingle(req, resp, Integer.parseInt(portions[1]));
			} catch(NumberFormatException e) {
				resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			}
			break;
		default:
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			break;
		}
	}
	
	// This method will be used for URIs such as /employees/5
	// Where there is a single extra portion in the URI
	private void handleSingle(HttpServletRequest req, HttpServletResponse resp, int id) throws ServletException, IOException {
		switch(req.getMethod()) {
		case "GET": {
			authService.guard(req, id, FINANCE_MANAGER);
			Employee e = employeeService.findById(id);
			ResponseUtil.writeJSON(resp, e);
			break;
		}
		case "DELETE":
			authService.guard(req, FINANCE_MANAGER);
			// TODO: Delete based on ID
			resp.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED);
			break;
		default:
			resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			break;
		}
	}

	// This method will be used when the URI is just /employees
	private void handleGroup(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch(req.getMethod()) {
		case "GET":
			List<Employee> all = employeeService.findAll();
			ResponseUtil.writeJSON(resp, all);
			break;
		case "POST": {
			authService.guard(req, FINANCE_MANAGER);
			String body = RequestUtil.readBody(req);
			
			Employee e = om.readValue(body, Employee.class);
			
			e = employeeService.insert(e);
			ResponseUtil.writeJSON(resp, e);
			break;
		}
		case "PUT": {
			String body = RequestUtil.readBody(req);
			Employee e = om.readValue(body, Employee.class);
			
			authService.guard(req, e.getId(), FINANCE_MANAGER);

			if(employeeService.update(e)) {
				resp.setStatus(HttpServletResponse.SC_ACCEPTED);
			} else {
				resp.sendError(HttpServletResponse.SC_CONFLICT);
			}
			break;
		}
		default:
			resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			break;
		}
	}
}
