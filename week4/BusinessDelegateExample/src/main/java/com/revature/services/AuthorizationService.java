package com.revature.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.revature.exceptions.ActionNotPermittedException;
import com.revature.exceptions.NotLoggedInException;
import com.revature.models.Employee;
import com.revature.models.Role;

public class AuthorizationService {

	// There is no return value, but there are VERY CLEAR "side effects"
	// The side effects in this case are the Exceptions being thrown or not
	// Other side effects could be that field values are modified
	// When testing, you verify that the side effects are "as expected"
	public void guard(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		// If there was no session, don't create one

		// If there was no session, or if they aren't logged in anymore
		if(session == null || session.getAttribute("currentUser") == null) {
			throw new NotLoggedInException();
		}
	}
	
	// This method will throw an exception if the current User doesn't match
	// a list of allowed Roles
	public void guard(HttpServletRequest req, Role...allowedRoles) {
		guard(req);
		
		HttpSession session = req.getSession(false);
		
		Employee currentUser = (Employee) session.getAttribute("currentUser");
		
		for(Role r : allowedRoles) {
			if(r.equals(currentUser.getRole())) {
				return;
			}
		}
		
		throw new ActionNotPermittedException();
	}
	
	// This method builds on top of the allowedRoles guard above,
	// except with the addition of a user ID
	// If this user ID matches the current User's ID
	// Then the action will still be permitted
	// This is so that even non-managers can access their own data
	public void guard(HttpServletRequest req, int id, Role...allowedRoles) {
		try {
			guard(req, allowedRoles);
		} catch(ActionNotPermittedException e) {
			Employee currentUser = (Employee) req.getSession(false).getAttribute("currentUser");
			
			if(currentUser.getId() != id) {
				throw e;
			}
		}
	}
}
