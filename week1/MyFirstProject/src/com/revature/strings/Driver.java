package com.revature.strings;

public class Driver {

	public static void main(String[] args) {
		// Strings are immutable, but sometimes we do want
		// to have a mutable version of a String
		
		// This is where the StringBuilder & StringBuffer classes come in
		// These are NOT subclasses of String (String class is final)
		// These classes are similar to Strings, but their character[] field is not final
		
		StringBuilder sb = new StringBuilder("Hello World");
		
		sb.reverse();
		
		System.out.println(sb.toString());
		
		// They have many methods for mutating text
		
		// The difference between StringBuffer & StringBuilder
		// is that StringBuffer is thread-safe (all methods are synchronized)
		// Because of this, StringBuilder is faster
	}

}
