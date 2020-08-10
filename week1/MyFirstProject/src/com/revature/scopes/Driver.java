package com.revature.scopes;

import java.util.ArrayList;
import java.util.List;

public class Driver {
	/*
	 * There are also notes about Memory Management below
	 */
	
	/*
	 * In Java there 4 scopes (descending):
	 * 
	 * _Static_/Class/Global Scope
	 * Instance Scope
	 * Method Scope
	 * Block Scope
	 */
	
	// Within Static scope, we can define the states and behaviors for this blueprint
	
	// Behaviors are methods, whose syntax is similar to the main method
	
	// States are declared as variables within this static scope
	
	int age;
	String name;
	int studentId;
	
	// The above variables (AKA Fields) will be separate PER instance of this class
	
	// We can also declare fields under the static scope, which will mean there is only 1 field
	// for the entire blueprint
	
	// So all instances would share the same value
	
	static int numberOfInstances = 0;

	public static void main(String[] args) {
		// Method Scope
		
		// Static methods DO NOT have access to instance fields
		// Instance methods DO have access to static fields
		
		// Instances themselves have access to static fields/methods
		
		// In order to create an object/instance, we use the new keyword;
		
		Driver driver = new Driver(); // Say for example: Created at memory location 10
		// Type varname = new Type();

		Driver driver2 = new Driver(); // Created at memory location 20
		
		driver.age = 5;
		driver2.age = 10;
		
		driver.numberOfInstances = 1;
		driver2.numberOfInstances = 2;
		
		System.out.println(driver.numberOfInstances);
		
		driver.myMethod();
		
		System.out.println(driver.age);
		
		
		// Java has this concept of reference variables and objects
		// In the above statements, we created a reference variable called "driver"
		// and we also created an object called "new Driver()"
		// However, that "new Driver()" object isn't necessarily named "driver"
		
		// "driver" is a completely separate reference to that nameless object
		
		// I can have multiple references to the same object
		Driver driver3 = driver;
		// This statement will create another reference, named driver3, that is pointing to the same
		// "new Driver()" object that was created on line 36.
		
		// Java (and most programming languages) store data in memory, specifically into 2 regions: The stack and the Heap
		
		// The stack is a region of memory that is highly structured.
		// The heap is unstructured
		// Generally, the heap is a lot bigger than the stack
		
		driver = new Driver(); // Memory location 30
		
		// Any reference variable that does not reference anything at all, has a value of "null"
		
		Driver driver4; // I have not assigned anything to driver4, so therefore it is null
		
		
		/*
		 * Local variables will be created on the stack
		 * This includes primitives and reference variables
		 * 
		 * Just remember that the stack consists of different stack frames, that each will have
		 * their own local variables
		 * 
		 * In particular Local variables are any variables created within the Method or Block Scope
		 */
		
		int x = 33;
		
		if(x > 30) {
			// Block Scope
			int y = 50; // All variables are only visible within their own scope
			// and nested scopes
		} else {
			// Separate Block scope from the previous
//			System.out.println(y);
			// Not visible
		}
		
//		System.out.println(y);
		System.out.println(x);
	}
	
	/*
	 * Java has a "Class" class.
	 * There will be an object for each class you create
	 * That object will be in the heap (where all objects are)
	 * And will contain information such as static fields
	 */
	
	public void myMethod() {
		// This is an instance method, because it does not use the static keyword
		
		// This will be one of the "behaviors" of our instances
		
		age = 15;
		this.name = "Something";
		// The "this" keyword is referring to the instance that invokes this method
		// Generally it is not needed to use the "this" keyword
		// But you will sometimes see it used to avoid variable name conflicts
		
		String name = "test"; // Creating this local variable "hides" the name field
		// Now we can only access the name field by prefixing it with the "this" keyword
		
		System.out.println("Object modified");
	}
}
