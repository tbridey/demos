package com.revature.gluecode;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class MercuryDriverUtility {

	public static WebDriver driver;
	public static final String url = "http://demo.guru99.com/test/newtours/index.php";
	
	/*
	 * These are Cucumber tag webhooks
	 * They will inject themselves before all of the other tests begin
	 * Allows us to create setup and teardown methods
	 */
	@Before
	public void setup() {
		  File file = new File("src/test/resources/chromedriver.exe");
		  System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		  driver = new ChromeDriver();
		  driver.get(url);
	}
	
	@After
	public void teardown() {
		if(driver != null) {
			driver.quit();
		}
	}
}
