package com.revature.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Employee;
import com.revature.models.Role;

/**
 * Servlet implementation class MySecondServlet
 */
@WebServlet(urlPatterns = {"/second"})
// This @WebServlet annotation is just configuring the web.xml file (or Deployment Descriptor) for us
public class MySecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static ObjectMapper om = new ObjectMapper();
	// This ObjectMapper comes from Jackson-Databind
	// And will convert to/from JSON
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MySecondServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee e = new Employee(1, "John", "Smith", new Role(1, "Finance Manager"));
		
		PrintWriter writer = response.getWriter();
		
		writer.println(om.writeValueAsString(e));
		
		response.setContentType("application/json");
		response.setStatus(200);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
