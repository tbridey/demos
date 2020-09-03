package com.revature.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Employee;
import com.revature.services.EmployeeService;
import com.revature.templates.LoginTemplate;
import com.revature.util.ResponseUtil;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
	
	private static ObjectMapper om = new ObjectMapper();
	private static EmployeeService es = new EmployeeService();
	

//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String username = req.getParameter("username");
//		String password = req.getParameter("password");
//		
//		if(username == null || password == null || username.equals("") || password.equals("")) {
//			resp.setStatus(400);
//			// Bad Request
//			return;
//		}
//		
//		// The user had entered both username and password
//		
//		if(username.equals(password)) {
//			// successful login
//			HttpSession session = req.getSession();
//			// Will create a session if there was not already one
//			
//			session.setAttribute("currentUser", username);
//			// This session will be associated with this key-value pair
//			// Java supports more than just Strings as the value
//			// The value can be any object
//			// The key must be a String
//			
//			// This key-value pair is stored exclusively on the server, associated with
//			// this particular session id
//			
//			resp.setStatus(200);
//			// Maybe I could send back data in JSON
//			
//			PrintWriter writer = resp.getWriter();
//			
//			// Jackson-Databind needs an object to serialize
//			// In my case I don't have any useful objects outside of Employee,
//			// which I don't want to use right now, so I will just send back the username
//			// But I could send an entire Employee object
//			
//			writer.println(om.writeValueAsString(username));
//		} else {
//			// in this else statement, the user failed to login
//			resp.setStatus(401);
//		}
//	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedReader reader = request.getReader();
		
		String body = reader.lines().collect(Collectors.joining());
		
		LoginTemplate lt = om.readValue(body, LoginTemplate.class);
		
		Employee e = es.login(lt);
		
		if(e == null) {
			response.setStatus(400);
		} else {
			HttpSession session = request.getSession();
			// This creates a cookie with a single key-value
			// JSESSIONID = something
			// Which represents our session
			
			// Store this employee object on the backend/server corresponding to this session
			session.setAttribute("currentUser", e);
			ResponseUtil.writeJSON(response, e);
		}
	}
}
