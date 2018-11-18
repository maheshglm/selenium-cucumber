Selenium Demo project is created using Java8, Cucumber, Junit to build a basic Automation framework.
Maven as a build tool and using cucumber-jvm-parallel-plugin to run SCENARIOS in parallel

===
Feature files & Runner
===
can be found in src\test\resources\features
Cucumber Runner is created in src\test\java\com\pageobect\demo\CucumberRunner.java

===
To Execute a specific Feature or Scenario (in Sequential):
===

1. Identify a tag of a specific Feature or Scenario
2. Update Runner.java with the tag that captured in above step
3. Run 'CucumberRunner.java' class

    or $ mvn clean test (will by default trigger CucumberRunner Test with predefined tag)

    or $ mvn clean test "-Dcucumber.options=--tags @tag1, @tag2..." (to trigger specific tags)

===
To Execute specific Scenarios in parallel:
===

1. Identify a tag of a specific Feature or Scenario
2. Navigate to SeleniumDemo directory in command line
3. Run 'mvn clean test -Dparallel.tag.name=@tagname -Drunner.classes=**/*Parallel*IT.class'

    Ex: $ mvn clean test -Dparallel.tag.name=@select_flight -Drunner.classes=**/*Parallel*IT.class

===
Reports
===

Can be found in testout/reports folder.






