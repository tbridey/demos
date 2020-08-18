package com.revature.services;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repositories.IUserDAO;
import com.revature.repositories.UserDAO;

public class UserService {
	
	private IUserDAO userDao = new UserDAO();

	public User login(String username, String password) {
		return null;
	}
	
	public User register(String username, String password, Role role) {
		User u = new User(0, username, password, role);
		
		int new_id = userDao.insert(u);
		
		if(new_id == 0) {
			// Insert failed
			return null;
			// Maybe throw a custom exception
		}
		
		u.setId(new_id);
		
		return u;
	}
}
