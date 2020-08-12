# Maven Notes

As mentioned previously, Maven can handle our dependencies and their versions.

It does this by downloading these libraries that were published to an online *Maven Repository*.

Maven will download them and store them on your local computer in a folder called `.m2/repository`

## Maven Build Lifecycle

The Maven Lifecycle is a series of phases that perform steps for miscellaneous actions relating to your project.

This is referred to as a lifecycle, because the phases are numbered, and in order to execute a particular phase, Maven must first execute the previous phases.

1. Validate => Validate that the project is correct (via pom.xml) and all necessary information is available (download dependencies if needed)
2. Compile => Compiles the source code
3. Test => Execute unit tests for the compiled code
4. Package => Package the compiled code into a JAR/WAR
  - Produce an "artifact" (.jar file or .war file)
5. Integration (Test) => Perform all integration tests on jar/war
6. Verify => Verifying the results of integration tests as well as quality gates such as Style Guides
7. Install => Installs the JAR/WAR into the *local* maven repository
  - For use as a dependency *locally*
8. Deploy => Copies the final JAR/WAR to the *remote* maven repository
  - Publish the JAR/WAR to be available publically

Each of these phases are also available as commands in the maven command line utility

Maven provides the `mvn` command line utility, so you can execute commands such as
`mvn package` or `mvn test` to perform that phase (and all preceeding phases)

There are also many maven plugins that can be included to expand the functionality that maven provides.

For example, there are Jacoco maven plugins to provide test code coverage as part of a maven lifecycle phase.

Outside of the Maven Build Lifecycle, there are 2 other lifecycles. There is a clean lifecycle, which is responsible for cleaning up a project and its artifacts. And the site lifecycle deals with generating documentation.

We do have commands such as `mvn clean` or `mvn site`.
