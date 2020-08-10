package com.revature.accessmods;

public class Driver {
	
	/*
	 * In Java there are 4 "Access Modifiers", which are keywords that define a field/method's visiblity:
	 * 
	 * public
	 * - Visible for whole project/everything
	 * private
	 * - Visible only within that class where the method/field is declared
	 * protected
	 * - Same as default, but also available within sub-classes
	 * default -- Note: Default access doesn't have a keyword, it is just a lack of a keyword
	 * - Only within the package where the method/field is declared
	 * - AKA Package-Private
	 */
	
	public int x;
	protected int y;
	int z;
	private int p;
	
	public Driver() {
		super();
	}

	public Driver(int z, int p) {
		super();
		this.z = z;
		this.p = p;
	}

	public static void main(String[] args) {
		// This was using the default constructor
		Driver driver = new Driver();
		
		driver.p = 55; // Also works, because we are within the same class
		
		driver.z = 16;
		
		driver.y = 10;

	}
	
	public void myMethod() {
		p = 33; // This works
		// Because we are in a method within the same class where the private field was declared
		
		z = 15;
	}
}
