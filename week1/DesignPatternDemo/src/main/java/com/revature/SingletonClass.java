package com.revature;

/*
 * This is an example of the Singleton Design Pattern
 * 
 * The characteristics of Singleton classes are that
 * they may only have at most 1 instance of this class
 * in memory at a time
 * 
 * We accomplish this with the following:
 * Private Constructor only
 * Private static instance of the same class
 * Public getInstance() method that only instantiates the instance
 * 	if it didn't already exist
 */
public class SingletonClass {
	
	private static SingletonClass instance = null;

	private SingletonClass() {
		super();
	}
	
	public static SingletonClass getInstance() {
		if(instance != null) {
			// Already exists
			return instance;
		}
		
		// Otherwise, create it
		instance = new SingletonClass();
		return instance;
	}
}
