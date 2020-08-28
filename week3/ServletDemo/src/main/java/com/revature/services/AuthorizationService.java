package com.revature.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.revature.exceptions.authorization.ActionNotPermittedException;
import com.revature.exceptions.authorization.NotLoggedInException;
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
}
