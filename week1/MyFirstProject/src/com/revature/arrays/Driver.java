package com.revature.arrays;

import java.util.Arrays;

public class Driver {

	public static void main(String[] args) {
		
		// A data structure that's purpose is to contain data
		// Specifically, an array contains data in sequence
		// The memory locations are immediately next to each other
		
		// Because of this, we can generally refer to a specific value in the array
		// by using the offset from the first element, called the "index"
		
		// Because of this, indexes start with zero
		// Because the memory is reserved in advance, the length cannot be changed
		
		// If you need more room, you must create a new array, and copy the values
		
		int[] arr = new int[/* SIZE */ 5];
		// By declaring an array like this, all values are initialized to that type's default value
		
		// However, we can initialize the values with this syntax
		
		Integer[] arr2 = new Integer[] {1, 2, 3, 4, 5, 6};
		// In this case, we will have 6 elements
		
		System.out.println(arr); // The Array class does not have a useful implementation of the toString method
		// This causes the print statements to only display the hashcode
		
		System.out.println(arr2);

		System.out.println(Arrays.toString(arr));
		// Arrays is a built in utility class from the java.util package
		// In particular, it has many overloaded toString methods that can print the contents of an array
		
		System.out.println(Arrays.toString(arr2));
	}

}
