package com.revature.testng;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.revature.pages.MercuryHome;
import com.revature.pages.MercuryLogin;

public class MercuryTest {
	
	public WebDriver driver;
	public final String url = "http://demo.guru99.com/test/newtours/index.php";

  @BeforeClass
  public void beforeClass() {
	  File file = new File("src/test/resources/chromedriver.exe");
	  System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
	  this.driver = new ChromeDriver();
	  driver.get(url);
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

  @Test
  public void confirmHomePage() {
	  assertEquals(driver.getTitle(), MercuryHome.title);
  }
  
//  @Test(dependsOnMethods = {"confirmHomePage"})
//  public void loginWorks() {
//	  MercuryHome mh = new MercuryHome(driver);
//	  // Instantiate corresponding pages
//	  
//	  mh.loginToMercuryTours("bobbert", "bobbert");
//	  // Login
//	  
//	  MercuryLogin ml = new MercuryLogin(driver);
//	  // Obtain other page
//
//	  // Wait for it to be visible
//	  WebDriverWait wait = new WebDriverWait(driver, 5);
//	  wait.until(ExpectedConditions.visibilityOf(ml.header));
//	  
//	  // Make assertion
//	  assertEquals(driver.getTitle(), MercuryLogin.title);
//  }
  
  @DataProvider(name = "credentials")
  public Object[][] loginCredentials() {
	  Object[][] data = null;
	  
	  try (Workbook wb = new XSSFWorkbook(new FileInputStream("src/test/resources/MercuryData.xlsx"))) {
		  Sheet sheet1 = wb.getSheet("Sheet1");
		  
		  int rowcount = sheet1.getLastRowNum();
		  
		  data = new String[rowcount][2];
		  
		  for(int i = 0; i < rowcount; i++) {
			  Row row = sheet1.getRow(i + 1);
			  data[i] = new String[] { row.getCell(0).getStringCellValue(), row.getCell(1).getStringCellValue() };
		  }
	  } catch(IOException e) {
		  e.printStackTrace();
	  }
	  
	  return data;
  }
  
  @Test(dependsOnMethods = {"confirmHomePage"}, dataProvider = "credentials")
  public void loginWorks(String username, String password) {
	  MercuryHome mh = new MercuryHome(driver);
	  // Instantiate corresponding pages
	  
	  mh.loginToMercuryTours(username, password);
	  // Login
	  
	  MercuryLogin ml = new MercuryLogin(driver);
	  // Obtain other page

	  // Wait for it to be visible
	  WebDriverWait wait = new WebDriverWait(driver, 5);
	  wait.until(ExpectedConditions.visibilityOf(ml.header));
	  
	  // Make assertion
	  assertEquals(driver.getTitle(), MercuryLogin.title);
	  
	  ml.signOffLink.click();
	  mh.homeLink.click();
  }
}
