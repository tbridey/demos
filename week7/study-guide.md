# Week 7 Study Guide
Topics Covered: Testing
Review the material covered from the week, which is listed out below.

Leverage the "How to do well in QC" Document that is pinned to the Training channel on Slack.

In particular, be able to answer "Tell me about your experience with X?", where X is any of the topics listed below.

Be able to provide overall reasons `Why` certain features are available. Such as what problems they solve.

## Topics
- [Testing](./notes/testing.md)
  - What is it?
  - Testing Pyramid
    - Unit Tests
    - Integration Tests
    - System Tests
    - User Acceptance Tests (UAT)
  - Testing Mindset
    - Focus on Requirements
    - The application must maintain quality
  - Types of Testing
    - Positive & Negative Testing
    - Functional Testing
      - Exploratory Testing
      - Exhaustive Testing
      - Boundary Testing
      - Equivalance Partitioning
    - Non-Functional Testing
      - Performing Testing:
        - Load Testing
        - Stress Testing
        - Spike Testing
        - Ramp Up/Down Testing
      - Usability Testing
    - API Testing
    - Re-testing
    - Regression-Testing
    - Testing Automation
    - Smoke Testing & Sanity Testing
    - Black-Box Testing
    - White-Box Testing
    - Manual Testing
  - Testing LifeCycle
    1. Requirement Analysis
    2. Test Planning
    3. Test-Case Development
    4. Test Environment Setup
    5. Test Execution
    6. Test Cycle Closure
  - Defects vs Features
  - Defect LifeCycle
    1. Open a Defect (Like Opening an Issue on GitHub)
    2. Assign to a developer to resolve
      2.5. The Developer says it is not a defect, then the defect is Closed (Step 5)
    3. Developer fixes the Defect
    4. Tester will re-test
      4.5 If the defect persists, go back to Step 2
    5. Close the Defect
  - Defect Reporting
    - Severity vs Priority
    - Plus Examples
  - TDD vs BDD
  - Manual Testing
    - Processes & Documents
    - Test Strategy
    - Test Plan
    - Test-Cases
    - Requirements Tracability Matrix (RTM)
    - Level of Effort Document
- TestNG vs JUnit
  - TestNG = Test Next Generation
  - TestNG is considered "more powerful" than JUnit 4
    - But about the same as JUnit 5
  - TestNG focuses on general testing, not just unit tests
  - Annotations
    - `@BeforeSuite` & `@AfterSuite`
    - `@BeforeTest` & `@AfterTest`
    - `@BeforeClass` & `@AfterClass`
    - `@BeforeGroups` & `@AfterGroups`
    - `@BeforeMethod` & `@AfterMethod`
    - `@DataProvider`
    - `@Test`
  - Supports xml configuration
  - Supports parallel test execution
- Selenium
  - PageFactory
    - `PageFactory.init(driver, this)`
    - `@FindBy` annotation
  - Makes creation of Page Object Models easier
- Cucumber
  - BDD Framework that uses Gherkin
    - BDD focuses on Requirements translated into functionality
  - Gherkin is a High-Level language to create Test Scenarios (of User Stories)
    - Supports 70+ Real-World spoken languages
    - Easy for non-programmers to develop test-cases
    - Scenario vs Scenario Outline
      - Scenario Outline supports Data Driven Tests (with Examples)
  - Feature Files (Step Definition Files)
    - Referred to as "Gluecode"
  - In particular, Cucumber is great, because it can automatically produce test stubs for our user stories that are then implemented as "gluecode"
  - Can work with either JUnit or TestNG
- Performance Testing with JMeter
  - Created our Test Plan
    - Saved as a `.jmx` file
  - Added `Thread Group` to the Test Plan (The number of concurrent users)
    - Can customize how many and how quickly they ramp and for how long
  - Added a variety of `Listeners`
    - View Results Tree
    - Response Time Graphs
    - Produced a dashboard overview
      - With a variety of graphs
  - Has support for scripting with `Groovy`
    - A language similar to Java
- Introduction to Jasmine and Protractor
  - Jasmine is a BDD testing library
    - Uses syntax with `describe` and `it` functions
  - Protractor is a Node library built on top of Selenium to perform e2e tests
    - Syntax is very similar to what we saw with the Java API for Selenium
    - `browser` object
    - `element` function to find elements on the page
    - `by` object that held all of our locators
      - `by.id`
      - `by.tagName`
      - etc
    - The resulting elements had methods exactly the same as the Java API
      - `click()`
      - `sendKeys()`
