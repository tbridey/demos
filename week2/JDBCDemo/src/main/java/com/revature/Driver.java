package com.revature;

import java.util.List;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repositories.IUserDAO;
import com.revature.repositories.UserDAO;
import com.revature.services.UserService;

public class Driver {

	public static void main(String[] args) {
		UserService userService = new UserService();
		IUserDAO userDao = new UserDAO();

		List<User> allUsers = userDao.findAll();
		
		System.out.println(allUsers);
		
		User u = userService.register("becky", "pass", Role.Customer);
		System.out.println(u);
		
		allUsers = userDao.findAll();
		System.out.println(allUsers);
	}
}
