package com.revature;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.revature.pages.LoginPage;

public class Project1Test {
	
	private LoginPage page;
	private static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		File file = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	@Before
	public void setUp() throws Exception {
		this.page = new LoginPage(driver);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLoginHeader() {
		assertEquals(page.getHeader(), "Login");
	}
	
	@Test
	public void testSuccessfulLogin() {
		page.setUsername("taemyles");
		page.setPassword("pass");
		page.submit();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.urlMatches("/home"));
		assertEquals("http://localhost:4200/home", driver.getCurrentUrl());
	}
	
	@Test
	public void testFailedLogin() {
		page.setUsername("taemyles");
		page.setPassword("incorrectpass");
		page.submit();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		if(wait.until(ExpectedConditions.alertIsPresent()) == null) {
			fail("Alert was expected");
		}
		
		driver.switchTo().alert().accept();
	}
}
