package com.revature.accessmods;

public class Driver2 {

	public static void main(String[] args) {
		Driver driver = new Driver();
		
//		driver.p = 55; // No longer accessible
		
		// This is because Driver2 is not the same class where the private field was declared

		driver.z = 16;
		
		driver.y = 10;
	}

}
