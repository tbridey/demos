package com.revature.nonaccessmods;

public abstract class Shape {

	// Once the class is declared as abstract
	// It can no longer be directly instantiated
	// And it may also have abstract methods
	
	public abstract double area();
	// Abstract methods DO NOT have implementations
	
	// Concrete methods are still allowed
	public Object test() {
		return new Object();
	}

	// Abstract classes do not lose any features in terms of what can be added to the class body
	
	// You can still have instance and static variables
	// You can have Constructors, etc
}
