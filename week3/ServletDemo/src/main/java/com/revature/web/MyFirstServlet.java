package com.revature.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFirstServlet extends HttpServlet {

	/*
	 * You are expected to memorize these method signatures
	 * 
	 * protected void doXXXXXX(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Our Servlet's doGet method has been invoked!");
		
//		PrintWriter writer = resp.getWriter();
//		
//		writer.println("<h1>Header sent back from Servlet</h1>");
//		
//		writer.println("<p>I can do whatever I want in the body of the request</p>");
		
//		resp.setContentType("text/html");
//		resp.setStatus(200);
		req.getRequestDispatcher("/static/index.html").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
