package com.revature.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"features/MercuryLogin.feature"},
		glue = {"com.revature.gluecode"})
public class TestRunner /* extends AbstractTestNGCucumberTests */ {
	
//	private TestNGCucumberRunner runner;
//	
//	@BeforeClass(alwaysRun = true)
//	public void setup() {
//		this.runner = new TestNGCucumberRunner(this.getClass());
//	}
}
