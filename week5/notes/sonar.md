# Code Quality Analysis

Sonar is a family of software that provides code quality metrics and analysis.

- SonarLint
  - A linter for your IDE to analyze code quality during development
- SonarCloud
  - A cloud-based UI to track code quality metrics for 1 or more projects
  - Provides a nice dashboard/display for pre-prepared reports
- SonarQube
  - A server whose purpose is to track and manage code quality for many projects
  - Can be configured to analyze projects for code quality

A common application is build reporting of code quality into our DevOps pipelines
  - This is accomplished by adding configuration to our maven project (in the pom.xml)
  - Alternatively, there are some sonar plugins we can add to our pom.xml
    - This will provide some maven lifecycle commands to send reports
  - After that, we use one of our CI tools such as Jenkins or GitHub Actions to perform the analysis
