package com.revature.nonaccessmods;

// Interfaces are similar to abstract classes, except that they have far more restrictions
// These restrictions allow Java to support classes implementing many interfaces at once
// Without these restrictions, this feature could not exist
public interface Calculable {

	// Interfaces can ONLY have public abstract methods
	// You do not need to include these keywords, since the compiler will add them in
	
	public double area();
	
	// Interfaces may have variables, but they must be public static final
	
	public static final int temp = 33;
	
	// Introduced in Java 8, was the "default" keyword for interfaces
	
	// The default keyword allows us to provide an implementation to a method in an interface
	
	// The purpose of this keyword is backwards compatibility. It is not considered a good practice
	// to use this keyword if it is not required
	
	public default void myMethod() {
		System.out.println("This is my default method!");
	}
	
	// Interfaces may have static methods, which will NOT be abstract
	
	// These methods are not inherited by the class that implements this interface
	// These methods belong to the interface itself
	public static void myStaticMethod() {
		System.out.println("This is my static method!");
	}
}
