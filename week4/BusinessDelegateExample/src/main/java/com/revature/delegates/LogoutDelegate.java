package com.revature.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutDelegate implements Delegate {

	@Override
	public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		// If there was no session, don't create one
		
		if(session != null) {
			session.invalidate();
		}
		
		resp.sendRedirect("http://localhost:8080/BusinessDelegateExample");
	}
}
