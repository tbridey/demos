package com.revature.primitives;

public class Driver {
	
	/*
	 * We have 8 primitive values in Java, each with different sizes in memory:
	 * 
	 * int => 32 bits (or 4 bytes)
	 * short => 16 bits (or 2 bytes)
	 * byte => 8 bits (or 1 byte)
	 * float => 32 bits (or 4 bytes)
	 * boolean => JVM dependent => Could be 8 bits (or 1 byte) or could be 1 bit, or in between
	 * double => 64 bits (or 8 bytes)
	 * long => 64 bits (or 8 bytes)
	 * char => 16 bits (or 2 bytes)
	 * 
	 * For the numerical types, they can be either signed or unsigned values
	 * They also are either integral typed or floating-point values
	 * 
	 * int => signed / integral
	 * short => signed / integral
	 * byte => unsigned / integral
	 * float => signed / floating-point
	 * double => signed / floating-point
	 * long => signed / integral
	 * char => unsigned / integral
	 */
	
	/*
	 * Java also has equivalent Objects for each of the 8 primitives
	 * 
	 * 
	 */

	public static void main(String[] args) {
		float f = 13.3f;

		short s1 = 55;
		short s2 = 55;
		
		short s3 = (short) (s1 + s2);
	}
}
