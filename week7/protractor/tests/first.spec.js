const welcomePage = require('../pages/welcome-page');
const profilePage = require('../pages/profile-page');
// These commands above are how you import before ES6 modules
// With ES6 modules, it is the same import syntax you see in Angular

// import { browser, describe, it, test, expect } from 'protractor';
// Reminder: The above statement will have to be removed before we run this
// Since we are not actually using an ES6 module, but it does provide
// intellisense, since VSCode is awesome

browser.ignoreSynchronization = true;
// Don't throw an error simply because we are not using an angular application


// Protractor tests are written using Jasmine syntax
// Jasmine is essentially the same as JUnit or TestNG but for JavaScript

// We use describe to create a test suite
// It accepts 2 parameters

// First Paremeter is the name of the test suite
// Second Parameter is a callback function with your tests

// Note: They will run in order that they were written automatically
// Barring the use of async/await

describe("BusinessDelegateExample", () => {

  // This is a single test
  it("Should go to the login page", () => {

    browser.get("http://localhost:8080/BusinessDelegateExample/");

    // Cause the browser to pause with the sleep function

    browser.sleep(2000);
    // Sleep for 2 seconds

    const title = browser.getTitle();
    // Grab the webpage title

    expect(title).toBe("My Webpage from a Servlet");
  });

  it("Should login", () => {

    welcomePage.username.sendKeys("taemyles");
    welcomePage.password.sendKeys("pass");

    browser.sleep(1000);

    welcomePage.submitButton.click();

    browser.sleep(3000);

    expect(profilePage.header.getText()).toBe("Welcome tae myles");
  });
});
