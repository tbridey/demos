# Teams

## Team 1 (4 person)
Christopher Castrillon
Bethel Poon
Julien Andrew
Pai Li

## Team 2 (4 person)
Garret Neff
Bret Baker
Maxwell Paul
Joseph Burss

## Team 3
Stephen Caceres
Jordan Tyus
Bach Tran

## Team 4
Tae Myles
Pranav Udaykumar
Jayson Lutrario

## Team 5
Zach Quinn
Andrew Lukens
Leron Charles

## Requirements

Project 2 will be a Full-Stack Application of your choosing.

- Spring Framework Backend
  - REST API
  - You can still perform authentication, you don't need to be fully stateless
  - You may NOT use Spring Data
  - Generally using Spring Web MVC to support HTTP Requests/Responses
  - Hibernate
  - Log4J (Intro to Log4J2)
    - Slightly different syntax
    - A very different configuration file (`log4j2.properties`)
    - Additionally like to see Logging through Aspect-Oriented Programming
      - Not required though
  - JUnit tests
    - Code Coverage Reports should be displayed on SonarCloud
    - For 3 person teams
      - Minimum 30% overall Code Coverage
      - Also 70% Service Layer Code Coverage
    - For 4 person teams
      - Minimum 50% overall Code Coverage
      - Also 85% Service Layer Code Coverage
    - Expect you to use Mockito as needed
    - Use TDD!!!!!!
  - Selenium Tests (e2e tests)
    - For 3 person teams
      - Expect 2 Selenium tests minimum
    - For 4 person teams
      - Expect 4 Selenium tests minimum
    - Note that generally speaking, e2e tests do not contribute to Code Coverage

- Angular Frontend
  - Must consume your own REST API backend
  - Additionally must consume a second, external, REST API

- DevOps Pipeline
  - Must use Jenkins
  - Can additionally use GitHub Actions for your SonarCloud Report if you wish
    - Could use Jenkins instead if you wish
    - Would still require a sonarcloud token
    - Would require a `sonar-scanner` linux executable

- Both your backend and your frontend must be deployed
  - Using your EC2's Tomcat to deploy your application is fine
  - Alternatively (if you're using Spring Boot, which has Tomcat built-in), you can just execute the program
    - However, that will take more configuration to make sure it shuts down when the next iteration is to be deployed
    - Additional issues are presented when if you run a java executable inside your pipeline, the Jenkins Job will not register as successful
    - Using Spring Boot, without Spring Data, can sometimes make it difficult to properly configure Spring Web MVC
      - So, some of you (or many of you), may decide not to use Spring Boot at all
  - You may also deploy your Angular frontend as static files on Tomcat or through an S3 bucket


## Steps that Teams must complete

Each team must decide on their project idea to implement. You must name your project. You must come up with several user stories and present them to me to confirm/deny. You must elect a Team Leader. You must create a Team Name (for solidarity). You must create a Project Description. This description is very important (along with Project name). They will appear on your Portfolio. Must be professionally worded/phrased. Should technical terminology, etc. The better it sounds, the better you look. You can consult the Project 1 description on your portfolio (which should already be available) as an example, but it is not required.

Make sure to send this to me on Slack, ASAP. The sooner it is confirmed, the sooner you can get started.

## Due Date

Friday, September 25th
