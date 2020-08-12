package com.revature.scanner;

import java.util.Arrays;
import java.util.Scanner;

public class Driver {
	
	/*
	 * Scanner is a class in Java that can be used to scan through many different things
	 * 
	 * For example, you can scan through files, console, or any InputStream
	 * 
	 * It is used to parse inputs for different values, or you can read entire lines
	 * 
	 * Helpful note: Only have 1 Scanner per InputStream in your application.
	 * Scanner can sometimes behave oddly when you have multiple open scanners on the same
	 * InputStream. There are additional issues that occur when you close 1 of the multiple scanners
	 * on the same InputStream.
	 * 
	 * The only native way to determine if a Scanner is still open is by invoking some methods
	 * on the object, and checking to see if it throws a IllegalStateException
	 */

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

//		System.out.println("Please Enter some user input:");
//		
//		String input = s.nextLine();
//		
//		String[] words = input.split("\\p{Punct}| ");
//		
//		System.out.println(Arrays.toString(words));
//		
//		for(String word : words) {
//			System.out.println(word);
//		}
		
		// s.nextInt() will leave the newline character in the buffer
		// and the following nextLine() reads just that character
//		int input = s.nextInt();
//		
//		System.out.println(input);
//		
//		String sentence = s.nextLine();
//		
//		System.out.println(sentence);
		
		int input;
		
		try {
			// Reads the entire line
			// Then splits into an array of words
			// It will ignore all but the first word
			// Parse the first word into an int
			// This might fail, if it does, a NumberFormatException will be thrown
			input = Integer.parseInt(s.nextLine().split(" ")[0]);
			
		} catch(NumberFormatException e) {
			input = -1;
			// Ask the user to repeat input
		}
		
		System.out.println(input);
		
		s.close();
	}

}
