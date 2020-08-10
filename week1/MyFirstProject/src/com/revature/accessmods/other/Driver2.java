package com.revature.accessmods.other;

import com.revature.accessmods.Driver;

public class Driver2 extends Driver {

	public Driver2(int x, int y, int z, int p) {
		// The very first line of a Constructor must be a call to a different constructor
		// or a parent class constructor
		
		// We accomplish that invoking this() or super().
		// this refers to the same instance
		// so we can invoke this class's constructors using "this()" syntax
		// super refers to the parent class
		// We can invoke parent class's constructors using "super()" syntax
		
		// The compiler will implicitly insert a "super()" statement
		super(z, p);
		
		this.x = x;
		this.y = y;
//		this.z = z;
//		this.p = p;
	}

	public static void main(String[] args) {
		Driver2 driver = new Driver2(10, 10, 10, 10);

//		driver.z = 16; // No longer accessible
		
		driver.y = 10;
	}
}
