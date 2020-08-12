package com.revature;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MyAppTest {
	
	private MyApp instance = null;
	private Number[] arr = null;

	/*
	 * This method will be invoked before the test class is instantiated
	 * This is primarily used to set up the global test environment
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/*
	 * This method will be invoked after the entire test class has completed
	 * This is primarily used to clean up the global test environment
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/*
	 * This method will be invoked before each individual test case
	 * This is primarily used to setup up specific test environment
	 * (or perhaps to reset it)
	 */
	@Before
	public void setUp() throws Exception {
		arr = new Number[] {BigDecimal.valueOf(10), BigDecimal.valueOf(15.5), BigDecimal.valueOf(14.3), BigDecimal.valueOf(5)};
		instance = new MyApp(arr);
	}

	/*
	 * Will be invoked after each individual test case
	 * Used to clean up the specific test environment
	 */
	@After
	public void tearDown() throws Exception {
	}

	/*
	 * This is our actual unit test case
	 */
	@Test
	public void testSimpleAddValueToArray() {
		Number value = 3.3;
		
		Number[] expected = new Number[] {
				BigDecimal.valueOf(13.3), BigDecimal.valueOf(18.8), BigDecimal.valueOf(17.6), BigDecimal.valueOf(8.3)};
		Number[] actual = instance.addValueToArray(value);
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testIdentity() {
//		BigDecimal value = BigDecimal.valueOf(new Random().nextDouble() * Math.pow(10, new Random().nextInt(100)));
		
		Number[] actual = instance.addValueToArray(0);
		
		Number[] expected = instance.getArr();
		
		assertArrayEquals(expected, actual);
	}
	
	@Test(expected = ArithmeticException.class) // Tests that the exception will occur
	public void testScaleException() {
		
	}
}
