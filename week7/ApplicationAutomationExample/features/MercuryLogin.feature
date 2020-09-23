# Feature files are a feature of Cucumber
# We write these Feature files in a language called "Gherkin"
# Within these Feature files, we write user stories that can be translated into tests
# They additionally allow tracking of user stories

# At the very top of a feature file, you have a description of the
# User Story that you are trying to accomplish

Feature: Mercury Tours Login
    As a User, I wish to login to Mercury Tours using proper credentials

    # General Scenario
    # Scenario: Logging into Mercury Tours
    #     Given a user is at the homepage of Mercury Tours
    #     When a user inputs their username and password and submits
    #     Then the user is redirected to the success login page

    # Scenario Outline implies that we will be using multiple records of data
    Scenario Outline: Logging into Mercury Tours
        Given a user is at the homepage of Mercury Tours
        When a user inputs their "<username>"
        And their "<password>"
        But then submits the information
        Then the user is redirected to the success login page

    Examples:
        | username | password |
        | bobbert  | bobbert  |
        | goodbye  | hello    |
        | dogbert  | dogbert  |
