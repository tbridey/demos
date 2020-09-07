package com.revature.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegates.Delegate;
import com.revature.delegates.EmployeeDelegate;
import com.revature.delegates.LoginDelegate;
import com.revature.delegates.LogoutDelegate;

public class RequestDispatcher {
	
	private Map<String, Delegate> delegateMap;
	
	public RequestDispatcher() {
		super();
		delegateMap = new HashMap<>();
		
		// URLs mapped to very specific delegates
		delegateMap.put("login", new LoginDelegate());
		delegateMap.put("logout", new LogoutDelegate());
		
		// URLs mapped to REST delegates
		delegateMap.put("employees", new EmployeeDelegate());
		
		// URLs mapped to static resources
		delegateMap.put("index", (req, resp) -> {
			req.getRequestDispatcher("/static/index.html").forward(req, resp);
		});
		delegateMap.put("", (req, resp) -> {
			req.getRequestDispatcher("/static/index.html").forward(req, resp);
		});
		delegateMap.put("profile", (req, resp) -> {
			req.getRequestDispatcher("/static/profile.html").forward(req, resp);
		});
	}
	
	public Delegate dispatch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final String URI = req.getRequestURI().replace("/BusinessDelegateExample", "");
		
		String leftover = URI;
		
		// If the first character is a '/'
		// Then strip it out
		if(leftover.charAt(0) == '/') {
			leftover = URI.substring(1);
		}
		
		// Set a convenient, simplified attribute for the path
		// Delegates will be able to access the cleaned URI with
		// String path = (String) req.getAttribute("path");
		req.setAttribute("path", leftover);
		
		// Remove any extra portions of the URI
		// For example:
		// "employees/5" -> "employees"
		String resource = leftover.split("/")[0];
		
		// Return the corresponding Delegate that is associated with the path
		// If there is no match, this will be null
		return delegateMap.get(resource);
	}
}
