package com.revature.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Functional Interface
// Will be used for custom lamdas in our RequestDispatcher class
public interface Delegate {
	void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
