package com.revature.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
	
	private static ObjectMapper om = new ObjectMapper();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		if(username == null || password == null || username.equals("") || password.equals("")) {
			resp.setStatus(400);
			// Bad Request
			return;
		}
		
		// The user had entered both username and password
		
		if(username.equals(password)) {
			// successful login
			HttpSession session = req.getSession();
			// Will create a session if there was not already one
			
			session.setAttribute("currentUser", username);
			// This session will be associated with this key-value pair
			// Java supports more than just Strings as the value
			// The value can be any object
			// The key must be a String
			
			// This key-value pair is stored exclusively on the server, associated with
			// this particular session id
			
			resp.setStatus(200);
			// Maybe I could send back data in JSON
			
			PrintWriter writer = resp.getWriter();
			
			// Jackson-Databind needs an object to serialize
			// In my case I don't have any useful objects outside of Employee,
			// which I don't want to use right now, so I will just send back the username
			// But I could send an entire Employee object
			
			writer.println(om.writeValueAsString(username));
		} else {
			// in this else statement, the user failed to login
			resp.setStatus(401);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
