package com.revature.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="features/MercuryLogin.feature", glue="com.revature.gluecode")
public class TestNGRunner extends AbstractTestNGCucumberTests {
}
