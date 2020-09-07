package com.revature.delegates;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Employee;
import com.revature.services.EmployeeService;
import com.revature.templates.LoginTemplate;
import com.revature.util.ResponseUtil;

public class LoginDelegate implements Delegate {
	
	private ObjectMapper om;
	private EmployeeService es;
	
	public LoginDelegate() {
		super();
		om = new ObjectMapper();
		es = new EmployeeService();
	}
	
	// For mocking if desired
	public LoginDelegate(ObjectMapper om, EmployeeService es) {
		super();
		this.om = om;
		this.es = es;
	}

	@Override
	public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BufferedReader reader = req.getReader();
		
		String body = reader.lines().collect(Collectors.joining());
		
		LoginTemplate lt = om.readValue(body, LoginTemplate.class);
		
		Employee e = es.login(lt);
		
		if(e == null) {
			resp.setStatus(400);
		} else {
			HttpSession session = req.getSession();
			// This creates a cookie with a single key-value
			// JSESSIONID = something
			// Which represents our session
			
			// Store this employee object on the backend/server corresponding to this session
			session.setAttribute("currentUser", e);
			ResponseUtil.writeJSON(resp, e);
		}
	}
}
