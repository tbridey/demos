package com.revature.nonaccessmods;

public class Driver {
	
	/*
	 * There are a fair few number of non access modifiers in Java:
	 * 
	 * The first keyword is static:
	 * 		This keyword declares a method or variable to belong to the class itself
	 * 		It will have STATIC SCOPE
	 * 		Note: It cannot be used on local variables
	 * 
	 * The next keyword is final:
	 * 		This keyword prevents something from being changed:
	 * 		For variables: The value cannot be reassigned
	 * 		For methods: The method cannot be overridden
	 * 		For classes: The class cannot be extended
	 * 
	 * abstract keyword:
	 * 		This applies to methods and classes
	 * 		This keyword can only be used on methods if they are inside an interface or an abstract class
	 * 		Abstract classes cannot be instantiated
	 * 		Conflicts with the final keyword, since a class must be extended in order to implement abstract methods
	 * 			The idea is that abstract classes should extended, and final prevents that, so together, they would
	 * 			leave you with a useless class
	 *		Exclusively used for inheritance
	 *		Abstract methods do NOT have implementations
	 *		Abstract classes may have regular methods
	 * 
	 * synchronized keyword:
	 * 		The synchronized keyword can be used on variables
	 * 		It prevents that variable from being accessed by multiple threads at once
	 * 
	 * volatile keyword:
	 * 		This applies to variables (instance and static scope only)
	 * 		Changes the location that the variable is stored to main memory
	 * 			(NOT the heap or the stack)
	 * 		Since each Thread will get its own Stack, they cannot access anything in the stack from
	 * 			another Thread
	 * 		The volatile keyword would make this variable accessible by all threads
	 * 
	 * transient keyword:
	 * 		This applies to variables (instance and static scope only)
	 * 		Prevents that variable from being serialized
	 * 
	 * strictfp keyword:
	 * 		This applies to classes
	 * 		This forces all methods and fields within the class to follow
	 * 		strict IEEE floating point format
	 * 
	 * native keyword:
	 * 		This applies to methods
	 * 		This means that the implementation for the method will be provided
	 * 			somewhere else in a different language
	 */

	public static void main(String[] args) {
		Shape s = new Circle(10);
		// Example of polymorphism, covariant reference variable
		System.out.println(s.area());
		
		System.out.println(s.test());
		
		Calculable c = new Circle(15);
		
		c.myMethod();
		
		System.out.println(c.area());
		
		Calculable.myStaticMethod();
		
		System.out.println(Calculable.temp);
	}
}
