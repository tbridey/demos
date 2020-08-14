package com.revature.operators;

public class Driver {

	public static void main(String[] args) {
		// Logical OR operator uses the || syntax
		// Logical AND operator uses the && syntax
		
		// One characteristic of these is short-circuiting

		// Since "false AND anything" will always be false
		// We can "short-circuit" the evaluation and ignore executing
		// what comes after
		
		// Same with "true OR anything" will always be true
		
		if(true || method2()) { // Short-circuited
			System.out.println("TRUE");
		}
		
		// There are equivalent operators called bitwise operators
		// They just have a single | or &
		// These operators do not short-circuit
		
		if(true | method2()) { // Not Short-circuited
			System.out.println("TRUE");
		}
	}

	public static boolean method1() {
		System.out.println("METHOD 1");
		return true;
	}
	
	public static boolean method2() {
		System.out.println("METHOD 2");
		return false;
	}
}
