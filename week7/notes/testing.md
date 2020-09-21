# Overview
- Testing Pyramid
  - Unit Testing
    - Most Micro level of testing
    - Test each component standalone without dependencies
    - Usually requires mocking (try to avoid actually manipulating databases)
      - Mockito
    - JUnit, TestNG
  - Integration Testing
    - Test components WITH dependencies
    - Verify that components work with other correctly
    - Logically related components/modules are tested as a group
    - Selenium, RestAssured, MockMvc
  - System Testing (e2e Testing)
    - Test the entire application as a whole
    - Make sure that the entire applications works without errors
  - UAT: User Acceptance Testing
    - Test that all requirements/user stories are met
    - Simulate the end-user to guarantee that users can actually perform all of the actions they're supposed to
    - Two-Forms: Alpha & Beta Tests
      - Alpha Testing is generally performed "in-house"
      - Beta Testing is generally performed out-of-house (usually actual end-users)

### IDE Plugin
- EclEmma Java Code Coverage: Provides Code Coverage from JUnit and TestNG unit tests
- Gives a run option called "Coverage As" which runs the tests and provides code coverage reports

## JUnit & TestNG (Test Next Generation)
JUnit's most commonly used version is JUnit 4
TestNG was released after JUnit 4, and had a bit more functionality/features. JUnit is focused primarily on Unit Testing, but TestNG has features more abstract than just unit testing. As such, these extra configuration options make TestNG to be considered "more powerful" than JUnit 4.
After TestNG was released, JUnit released JUnit 5, called Jupiter. Which had many more configuration options, which allowed to be considered roughly as powerful as TestNG, but is not backwards compatibile with JUnit 4.

### TestNG
- Annotations
  - `@BeforeSuite` & `@AfterSuite`
  - `@BeforeTest` & `@AfterTest`
  - `@BeforeClass` & `@AfterClass`
  - `@BeforeGroups` & `@AfterGroups`
  - `@BeforeMethod` & `@AfterMethod`
  - `@DataProvider`
    - Method must return a 2D array of Objects (`Object[][]`)
  - `@Test`
    - `enabled`
    - `priority`
    - `expectedExceptions`
    - `groups`
    - `dataProvider`
    - `dependsOnMethods`
    - `dependsOnGroups`
- Supports xml configuration
- Parallel tests
  - Leads to better performance

## Types of Testing
- Positive & Negative Testing
  - Positive testing tests that the feature behaves correctly when it is used correctly
    - Called the "Happy Path"
  - Negative testing tests that the feature behaves correctly with incorrect use
- Functional Testing: Any test that validates the actions your application must perform
  - Exploratory Testing: You assume the requirements and validations are based off current behavior of the application
  - Exhaustive Testing: Testing every possible permutation for your application
    - Every possible route that your user could take, from button clicks to options to different combinations of inputs
    - It is not really feasible to pay for this kind of testing
  - Boundary Testing: Create tests to test the extremes of your application
    - min, max, min - 1, max + 1
  - Equivalance Partitioning: Divide up the test-values in some equivalent manner
    - Every 25 numbers
    - Negative, Zero, and Positive numbers
- Non-Functional Testing: Ensure your application does not have vulnerabilities
  - Performing Testing:
    - Load Testing: Examine how the application behaves under certain loads of connections
      - Usually anticipated/expected load
    - Stress Testing: Test how the application behaves under near maximum load
      - Sometimes even overload the application to see if/how it breaks
    - Spike Testing: How does the application behaves with a sudden increase of user count?
    - Ramp Up/Down Testing: Gradually increase/decrease load
  - Usability Testing: Is the application even possible to use?
    - White-background with all white text
- API Testing: Testing to make sure your application is fetching data correctly
- Re-testing: Re Run tests on functionality that failed before, in order to confirm that the defect is fixed
- Regression-Testing: Run old test-suites to ensure that newly added functionality does not break old functionality
- Testing Automation: Perform functional tests utilizing automated scripts to execute, track, and create tests results in an effort to save time and application quality
- Smoke Testing & Sanity Testing
  - Both are types of tests you would perform before other tests
  - Smoke Testing: Testing used in order to verify critical functionalities of the application
    - It is done to prevent QA team from having to waste time writing more sophisticated tests on broken functionality
  - Sanity Testing: Immediately checking if newly developed functionality works
- Black-Box Testing: Tests do not require access or understanding of the actual code
- White-Box Testing: Tests that are based on knowledge of the actual code (Like Unit Tests for example)
  - Usually aims for code coverage
- Manual Testing
  - You test functionality of the application directly
  - The key concept is that manual testing is used to make sure that the application is error free and complies with specifications
  - How to:
    - Read and understand the guidelines
      - Come from Documents
    - Draft test cases
      - Based on specifications
    - Review test cases with team-lead
    - Execute test-cases
    - Report any defects
      - Standardized process
    - After they are fixed, verify it
  - Documents
    - Test Strategy Document: Detail how the team handles testing in general
      - Deals with processes for how much testing should be done
      - Specify what documents and verifications are needed to show you have done what is expected (for the test)
    - Test Plan Document: Detail how you will test a specific project
      - What processes and conditions are to be utilized for the current project
    - Test Case Document: Detail all specific test cases
    - Requirements Tracability Matrix (RTM): Aims to detail every requirement/user story and link it to the test case it pertains to
    - Level of Effort (LOE) Document:
      - Includes Test Strategy, Test Plan, RTM, Test Summary Documents

## Defect LifeCycle
- Defect: The result of a failed test
  - Bug: The application behaves in a manner it should not
  - Error: Misundertanding of the Requirements
- Feature vs Defect
  - Defects can reasonably be viewed as a problem
  - Features are additional functionality that wasn't requested
- LifeCycle:
  1. Open a Defect (Like Opening an Issue on GitHub)
  2. Assign to a developer to resolve
    2.5. The Developer says it is not a defect, then the defect is Closed (Step 5)
  3. Developer fixes the Defect
  4. Tester will re-test
    4.5 If the defect persists, go back to Step 2
  5. Close the Defect

## Defect Report
- While reporting a bug to the developer, sometimes the report will contain some of the following:
  - Defect ID: Unique ID
  - Defect Description: Detailed info about the defect
  - Version
  - Steps: Events that occurred having to do with the defect
  - Date
  - Reference: Referencing other documents
  - Detected By
  - Fixed By
  - Date Closed
  - Severity
    - Indicates the effect it has on the system's functionality
  - Priority
    - The urgency with which it needs to be fixed
  - Screenshots
  - Test Data (if any)
- Severity & Priority
  - High Severity & High Priority: Half of all Users cannot login to Facebook
  - High Severity & Low Priority: A very niche feature that hardly anyone uses is completely broken
  - Low Severity & High Priority: An opposing company's Logo is shown on your home page
  - Low Severity & Low Priority: Certain colors are not displaying as expected/required

## Software Testing LifeCycle
1. Requirement Analysis: Determine what can/should be tested
  - Produce the RTM
2. Test Planning: Senior QA will determine cost estimates and some form of Test Plan is created
3. Test-Case Development: Create and Develop Test-cases and scripts
4. Test Environment Setup: Software/hardware conditions that product will be in shall be tested
5. Test Execution: Execute the tests as per the Test Plan
  - Map Defects to Test-Cases in RTM
  - Follow the Defect LifeCycle (Along with Defect Reporting)
6. Test Cycle Closure: Testing team will meet and talk about how the testing cycle went

## Miscellaneous Topics
- Verification vs Validation
  - Verification: Am I making the right Application?
  - Validation: Have I made the right Application?
- What should I test?
  - The bad answer: "Everything"
    - Testing for testing's sake isn't strategic
    - Code coverage isn't everything
  - The better answer: "The Requirements"

## TDD & BDD
- TDD: Test Driven Development
  - Development depends on tests
  - You only develop new tests or to make failing tests pass
  - Test cases are written first, then development is done in order to allow the tests to pass
- BDD: Behavior Driven Development
  - Development occurs based off of collaborations between QA team, BA team, devs, and all other non-technical members
  - Conversations between BAs and Clinet/Product Owner determine how coding will occur
  - Conversations -> Test Cases -> Development
- Cucumber: BDD Framework that uses "Gherkin"
  - Gherkin: A Domain Specific Language (DSL) that helps describe business behavior without needing to go into implementation
    - Very High Level
    - Supports 70+ Real World Spoken Languages
    - Used to create "Feature Files"
    - Syntax follows a Given-When-Then approach
  - Gluecode: Actual code that is executed
    - Usually refers to a subset of code that does not go towards meeting program requirements
