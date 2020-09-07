package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegates.Delegate;
import com.revature.exceptions.AuthorizationException;

@WebServlet(urlPatterns = {"/"})
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 922064885233890820L;
	
	private RequestDispatcher rd;
	
	public FrontController() {
		super();
		rd = new RequestDispatcher();
	}

	// For mocking if desired
	public FrontController(RequestDispatcher rd) {
		super();
		this.rd = rd;
	}
	
	// We are not overriding any methods here
	// This is just a private method to help organize all of our different HTTP Verbs
	// under this same method
	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Delegate delegate = rd.dispatch(req, resp);
		
		if(delegate == null) {
			resp.sendError(404);
			return;
		}
		
		try {
			delegate.process(req, resp);
		} catch(AuthorizationException e) {
			resp.setStatus(401);
		}
	}
	
	// This is equivalent to creating a CORS Filter class, since CORS only needs to apply to
	// OPTIONS requests
	// This is called a "pre-flight" request
	// None of the other methods need these headers
	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("CORS Filter leveraged");
		
		resp.setHeader("Access-Control-Allow-Origin", "http://localhost:8080"); // Allow only same origin
		
		resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
		// Allow specific HTTP Verbs
		
		resp.setHeader("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With, Content-Type,"
				+ "Access-Control-Request-Method, Access-Control-Request-Headers");
		// Allow specific HTTP Headers (there's a fair few)
		
		resp.setHeader("Access-Control-Allow-Credentials", "true");
		// Credentials are allowed
		
		resp.addHeader("Produces", "application/json");
		// Send back application/json unless forwarded to a static resource
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	@Override
	protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
}
