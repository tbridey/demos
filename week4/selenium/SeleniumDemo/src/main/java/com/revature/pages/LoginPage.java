package com.revature.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 
 * This class is an example of the Page Object Model (POM) Design Pattern
 * 
 * It is a Design Pattern where we represent a single webpage as a Java class
 * 
 * Having references to the important WebElements and corresponding methods to interact
 * 
 * with those elements
 *
 */
public class LoginPage {
	
	private WebDriver driver;
	
	private WebElement header;
	private WebElement usernameField;
	private WebElement passwordField;
	private WebElement submitButton;
	
	private static final String title = "Project1";

	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
		this.navigateTo();
		WebElement appLogin = driver.findElement(By.tagName("app-login-page"));
		
		this.header = appLogin.findElement(By.tagName("h1"));
		this.usernameField = appLogin.findElement(By.name("username"));
		this.passwordField = appLogin.findElement(By.name("password"));
		this.submitButton = appLogin.findElement(By.tagName("button"));
	}
	
	public void setUsername(String username) {
		this.usernameField.clear();
		this.usernameField.sendKeys(username);
	}
	
	public String getUsername() {
		return this.usernameField.getAttribute("value");
	}

	public String getHeader() {
		return header.getText();
	}

	public String getPassword() {
		return passwordField.getAttribute("value");
	}

	public void setPassword(String password) {
		this.passwordField.clear();
		this.passwordField.sendKeys(password);
	}
	
	public void submit() {
		this.submitButton.click();
	}
	
	public void navigateTo() {
		this.driver.get("http://localhost:4200/login");
		// This url should come from an environment variable that is different
		// depending on your development environment
		// This particular URL would be for local development
		// But it will be different in a dev environment or a production
		// environment
	}
}
