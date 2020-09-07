package com.revature.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.services.AuthorizationService;

public class ReimbursementDelegate implements Delegate {
	
	private ObjectMapper om;
	private AuthorizationService authService;

	@Override
	public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO: Implement similarly to EmployeeDelegate

	}
}
