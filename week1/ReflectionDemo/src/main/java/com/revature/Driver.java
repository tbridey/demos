package com.revature;

import java.lang.reflect.Field;

public class Driver {
	
	/*
	 * The Reflection API is a collection of classes in Java that allow us to perform
	 * introspection at runtime. This means we can anaylze our program within our program
	 * and modify its behavior.
	 * 
	 * In order to accomplish this, we have many classes spanning all of the Java language features:
	 * 
	 * Classes
	 * Interfaces
	 * Enums
	 * Fields
	 * Methods
	 * Constructors
	 * and more...
	 */

	public static void main(String[] args) {
		
		// The String Pool is PART OF the Heap
		
		// String Literals will become reference variables to String objects in the String Pool
		// when the application first runs
		
		// There is a way to interact with the String Pool through the use of the intern() method
		// on the String class
		
		String s = "Strings are ALWAYS immutable, right?"; // inside String pool
		
		String s2 = new String("Strings are ALWAYS immutable, right?"); // outside string pool
		
		s2 = s2.intern();
		
		String s3 = s2.concat(" Other"); // Outside the String Pool
		
		// The .equals method can be overridden to do whatever, generally it will compare the values
		System.out.println(s.equals(s2)); // true
		System.out.println(s == s2); // true
		// The == operator for objects, compares the memory locations, NOT the values
		
		Class<String> stringClass = String.class;
		
		// String is a subclass of Object
		// But Class<String> is NOT a subclass of Class<Object>
		// Class<? super String> is a subclass of Class<? super Object> is a subclass of Class<Object>

		System.out.println(stringClass);
		
		System.out.println("ORIGINAL VALUE: " + s);
		
		Field stringValue;
		
		try {
			
			stringValue = stringClass.getDeclaredField("value");
			
			System.out.println(stringValue);
			
			stringValue.setAccessible(true);
			
			stringValue.set(s, "HAHAHAHAHAHAHAHA".toCharArray());
			
			System.out.println(s);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		s = null;
		stringClass = null;
		stringValue = null;
		
		System.gc();
		
//		while("Strings are ALWAYS immutable, right?".equals("HAHAHAHAHAHAHAHA")) {
//			System.out.println("Strings are ALWAYS immutable, right?");
//		}
		
		System.out.println("All fixed!");
		System.out.println("Strings are ALWAYS immutable, right?");
	}
}
