package com.revature;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver {

	public static void main(String[] args) throws InterruptedException {
		File file = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://google.com");
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		// Tells Selenium to wait 2 seconds before throwing an exception
		// If I try to get an element, but can't, then keep trying for 2 seconds before failing
		// with an exception
		
		WebElement searchBar = driver.findElement(By.name("q"));
		WebElement submitButton = driver.findElement(By.name("btnK"));
		
		searchBar.sendKeys("Do a barrel roll");
		submitButton.click();
		
		TimeUnit.SECONDS.sleep(10);
		
		driver.get("https://google.com");
		
//		WebDriverWait wait = new WebDriverWait(driver, 5);
		
//		driver.quit();
		// This will close the browser and shut down the chromedriver
	}
}
