package com.revature.exceptions;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		
		try {
			// Inside the try-block, you include statements that could cause an exception
			method1();
			method2();
		} catch (RuntimeException e) {
			// In the catch block you handle it
			e.printStackTrace();
			
			// It is 100% up to you in terms of how you handle exceptions
			// Ignoring them is technically valid
			// However, in enterprise applications, generally you should do something
			// actually helpful
			
			// Sometimes, all you need to do is log the fact that it happened
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Program will continue running!");
		
		System.out.println(method3());
		
		Scanner s = new Scanner(System.in);
		
		try {
//			method1();
		} finally {
			System.out.println("Finally block before program crashes!");
			s.close();
		}
		
		Duck d = new Duck(10);
		
//		d.setNumberOfEggs(-30);
		
		d.getNumberOfEggs();
	}
	
	public static void method1() throws RuntimeException {
		throw new RuntimeException("Runtime Exception");
	}
	
	public static void method2() throws Exception {
		throw new Exception("Checked Exception");
	}
	
	
	/*
	 * The finally clause can be used with the try block
	 * 
	 * The syntax will be valid as long as you have a finally block
	 * or at least 1 catch block
	 * 
	 * This means that try-finallys are valid syntax
	 * 
	 * So is try-catch-catch-catch-finally
	 * 
	 * Just note that the finally block must be the last one in the chain
	 * 
	 * Additional note, these catch blocks that are chained will occur sequentially
	 * 
	 * So, if you try to catch something generic first, and THEN something specific
	 * 
	 * You will have a syntax issue
	 * 
	 * If you have multiple statements in a try block, the entire try block will be interrupted
	 * when an exception occurs.
	 * 
	 * So if you have 3 statements, and the first statement triggered an exception,
	 * the 2nd and 3rd statements will never happen.
	 */
	
	public static int method3() {
		try {
			method1();
			method2();
		} catch(RuntimeException e) {
			return 1;
		} catch(Exception e) {
			return 2;
		} finally {
			System.out.println("Finally block happened!");
		}
		
		return 0;
	}
	
	/*
	 * The finally block will always run
	 * 
	 * What this means is that it will interrupt return statements if it has to
	 * 
	 * This also means that the finally block does not necessarily complete
	 * 
	 * If the finally block throws an exception, then it will stop in the middle
	 */
}
