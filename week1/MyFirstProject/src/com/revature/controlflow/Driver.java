package com.revature.controlflow;
// The above statement is a package declaration
// It defines the location that this class is in
// It has an impact on other aspects of the application, such as scope
// This package statement MUST be the first line of a java file

// We have our class declaration
// This is our blueprint
public class Driver {
	// The above curly-brace defines a "scope"
	// In particular, this region is called the "class/static scope"

	// This below line is a method declaration
	// It is one of the "behaviors" of our blueprint
	// They are referred to as "methods"
	
	// The specific syntax here defines our "main" method, which has special support
	// in order to act as the entrypoint of our application
	// Note that a class can only have 1 main method
	// However, if you have multiple classes, they can each have a main
	// When you run the application, you choose one of the mains
	public static void main(String[] args) {
		// This is a single-line comment
		// This will be ignored by the compiler and jvm
		// They are just here to provide context to other human beings
		
		/*
		 * This is a multi-line comment
		 * Everything within the /* and the ending tag will be ignored
		 */
		
		System.out.println("Whatever you want to print");
		
		// Control Flow statements allow us to execute statements only under certain conditions
		
		// There are many control flow statements in Java:
		// if
		// if-else (these can be chained together)
		// switch statements (similar to if-else chains)
		// for-loops
		// enhanced for-loop
		// while-loops
		// do-while-loops
		
		if(true) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
		
		switch(10) {
		case 5:
			System.out.println("Five");
			break;
		case 10:
			System.out.println("Ten");
			// Note: There is no break statement here
			// Which will cause "falling-through"
		default:
			System.out.println("Default");
		}
		
		for(int i = 0; i < 10; i++) {
			System.out.println(i);
		}
		
		int[] array = new int[] { 1, 2, 3, 4, 5 };
		// Creating an array and instantating with specific values
		
		// Enhanced for-loops work with arrays and collections
		for(Integer i : array) {
			System.out.println(i);
		}
		
		int x = 10;
		
		while(x >= 0) {
			System.out.println(x);
			x--;
		}
		
		do {
			System.out.println(x);
		} while(x >= 0);
	}
}
