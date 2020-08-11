package com.revature.varargs;

public class Driver {

	public static void main(String[] args) {
		System.out.println(add(1));
		
		System.out.println(add(1,2,3,4,5));
		
		int[] arr = new int[] {1,2,3,4,5};
		
		System.out.println(add(0, arr));
	}

	public static int add(int a, int b) {
		return a + b;
	}
	
	public static int add(int a, int b, int c) {
		return a + b + c;
	}
	
	// In order to avoid manually overloading methods like this, we can leverage varargs
	
	// varargs will support 0+ parameters
	// If you don't want 0 parameters, you must add additional explicit parameters
	// The varargs parameter must be the last parameter in the list
	// And you may only have 1 varargs parameter per method
	public static int add(int a, int...arr) {
		int sum = a;
		
		for(int i : arr) {
			sum += i;
		}
		
		return sum;
	}
}
