package com.revature.gluecode;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.revature.pages.MercuryHome;
import com.revature.pages.MercuryLogin;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

// Gluecode files are also known as Step Definition Files
public class MercuryLoginTest {
	
	public MercuryHome mh;
	public MercuryLogin ml;
	
//	@Given("a user is at the homepage of Mercury Tours")
//	public void a_user_is_at_the_homepage_of_mercury_tours() {
//	    this.mh = new MercuryHome(MercuryDriverUtility.driver);
//	    assertEquals(MercuryHome.title, MercuryDriverUtility.driver.getTitle());
//	}
//
//	@When("a user inputs their username and password and submits")
//	public void a_user_inputs_their_username_and_password() {
//	    this.mh.loginToMercuryTours("bobbert", "bobbert");
//	}
//	
//	@Then("the user is redirected to the success login page")
//	public void the_user_is_redirected_to_the_success_login_page() {
//	    this.ml = new MercuryLogin(MercuryDriverUtility.driver);
//	    assertEquals(MercuryLogin.title, MercuryDriverUtility.driver.getTitle());
//	}
	
	@Given("a user is at the homepage of Mercury Tours")
	public void a_user_is_at_the_homepage_of_mercury_tours() {
		this.mh = new MercuryHome(MercuryDriverUtility.driver);
	    assertEquals(MercuryHome.title, MercuryDriverUtility.driver.getTitle());
	}
	
	@When("a user inputs their {string}")
	public void a_user_inputs_their(String username) {
	    this.mh.username.sendKeys(username);
	}
	
	@When("their {string}")
	public void their(String password) {
	    this.mh.password.sendKeys(password);
	}
	
	@When("then submits the information")
	public void then_submits_the_information() {
	    this.mh.submitButton.click();
	}
	
	@Then("the user is redirected to the success login page")
	public void the_user_is_redirected_to_the_success_login_page() {
		this.ml = new MercuryLogin(MercuryDriverUtility.driver);
		WebDriverWait wait = new WebDriverWait(MercuryDriverUtility.driver, 2);
		wait.until(ExpectedConditions.titleContains("Login"));
	    assertEquals(MercuryLogin.title, MercuryDriverUtility.driver.getTitle());
	}
}
