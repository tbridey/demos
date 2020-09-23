package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MercuryLogin {

	public static final String title = "Login: Mercury Tours";
	
	@FindBy(xpath = "//h3[text()='Login Successfully']")
	public WebElement header;
	
	@FindBy(linkText = "SIGN-OFF")
	public WebElement signOffLink;
	
	public MercuryLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
