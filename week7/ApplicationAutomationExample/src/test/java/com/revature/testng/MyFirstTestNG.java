package com.revature.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class MyFirstTestNG {
	
  @Test(dataProvider = "myDataProvider")
  public void f(Integer n, String s) {
	  System.out.println("TEST WITH INTEGER " + n + " AND STRING " + s);
  }
  
  @Test(groups = "group1")
  public void otherTest() {
	  System.out.println("TEST WITHIN group1");
  }
  
  @Test
  public void test1() {
	  System.out.println("TEST 1");
  }
  
  @Test
  public void test2() {
	  System.out.println("TEST 2");
  }
  
  @Test
  public void test3() {
	  System.out.println("TEST 3");
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("BEFORE METHOD");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("AFTER METHOD");
  }

  @DataProvider(name = "myDataProvider")
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  
  @BeforeClass
  public void beforeClass() {
	  System.out.println("BEFORE CLASS");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("AFTER CLASS");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("BEFORE TEST");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("AFTER TEST");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("BEFORE SUITE");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("AFTER SUITE");
  }
  
  @BeforeGroups({"group1"})
  public void beforeGroups() {
	  System.out.println("BEFORE group1");
  }
  
  @AfterGroups({"group1"})
  public void afterGroups() {
	  System.out.println("AFTER group1");
  }
}
