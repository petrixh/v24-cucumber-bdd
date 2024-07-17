# Vaadin Testbench through Cucumber on a Vaadin Flow 24 application
This is a quick proof-of-concept of executing Testbench from a Cucumber BDD scenario based heavily on the following 
- https://cucumber.io/docs/installation/java/
- https://github.com/cucumber/cucumber-jvm/tree/main/cucumber-junit-platform-engine
- https://github.com/cucumber/cucumber-java-skeleton/blob/main/maven/src/main/java/io/cucumber/skeleton/Belly.java

To run the poc you will need a active Vaadin Pro or higher subscription or trial to run Testbench:
https://vaadin.com/pricing

To run the PoC: 

``` 
./mvnw clean package -DskipTests
```

We skip the tests initially as the browser tests require a running server (see other Testbench/Cucumber examples on how to start a Spring Boot project during tests phase)

Then to start the servrer run: 
```
./mvnw spring-boot:run
```

In another terminal run:
```
./mvnw test
```

This should run both the UiUnitTest (Karibu) verions of the HelloWorld tests and the Selenium based browser test, you might need to setup Chrome for selenium tests. 

In the console look for: 

```
Scenario: Enter name show notification                                   # com/example/application/hello.feature:2
  Given On the HelloWorldView enter the name John it into the text field # com.example.application.StepDefinitionsUiUnitTests.I_have_a_name()
  When I press the button                                                # com.example.application.StepDefinitionsUiUnitTests.i_press_the_button()
  Then a Notification is shown                                           # com.example.application.StepDefinitionsUiUnitTests.a_notification_is_shown()

..... 

Scenario: Enter name show notification in browser                                     # com/example/application/hello2.feature:2
  Given In a browser on the HelloWorldView enter the name John it into the text field # com.example.application.StepDefinitionsBrowserTest.in_a_browser_on_the_hello_world_view_enter_the_name_john_it_into_the_text_field()
  When In a browser I press the button                                                # com.example.application.StepDefinitionsBrowserTest.in_a_browser_i_press_the_button()
  Then In a browser a Notification is shown                                           # com.example.application.StepDefinitionsBrowserTest.in_a_browser_a_notification_is_shown()
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 5.574 s -- in com.example.application.RunCucumberTest
```

Additional documentation on Testbench: 
- https://vaadin.com/docs/latest/flow/testing




 ----- regular start.vaadin.com stuff below ----
# Custom project from Hilla

This project can be used as a starting point to create your own Hilla application with Spring Boot.
It contains all the necessary configuration and some placeholder files to get you started.

## Running the application

The project is a standard Maven project. To run it from the command line,
type `mvnw` (Windows), or `./mvnw` (Mac & Linux), then open
http://localhost:8080 in your browser.

You can also import the project to your IDE of choice as you would with any
Maven project.

## Deploying to Production

To create a production build, call `mvnw clean package -Pproduction` (Windows),
or `./mvnw clean package -Pproduction` (Mac & Linux).
This will build a JAR file with all the dependencies and front-end resources,
ready to be deployed. The file can be found in the `target` folder after the build completes.

Once the JAR file is built, you can run it using
`java -jar target/myapp-1.0-SNAPSHOT.jar` (NOTE, replace
`myapp-1.0-SNAPSHOT.jar` with the name of your jar).

## Project structure

<table style="width:100%; text-align: left;">
  <tr><th>Directory</th><th>Description</th></tr>
  <tr><td><code>src/main/frontend/</code></td><td>Client-side source directory</td></tr>
  <tr><td>&nbsp;&nbsp;&nbsp;&nbsp;<code>index.html</code></td><td>HTML template</td></tr>
  <tr><td>&nbsp;&nbsp;&nbsp;&nbsp;<code>index.ts</code></td><td>Frontend 
entrypoint, bootstraps a React application</td></tr>
  <tr><td>&nbsp;&nbsp;&nbsp;&nbsp;<code>routes.tsx</code></td><td>React Router routes definition</td></tr>
  <tr><td>&nbsp;&nbsp;&nbsp;&nbsp;<code>MainLayout.tsx</code></td><td>Main 
layout component, contains the navigation menu, uses <a href="https://hilla.dev/docs/react/components/app-layout">
App Layout</a></td></tr>
  <tr><td>&nbsp;&nbsp;&nbsp;&nbsp;<code>views/</code></td><td>UI view 
components</td></tr>
  <tr><td>&nbsp;&nbsp;&nbsp;&nbsp;<code>themes/</code></td><td>Custom  
CSS styles</td></tr>
  <tr><td><code>src/main/java/&lt;groupId&gt;/</code></td><td>Server-side 
source directory, contains the server-side Java views</td></tr>
  <tr><td>&nbsp;&nbsp;&nbsp;&nbsp;<code>Application.java</code></td><td>Server entry-point</td></tr>
</table>

## Useful links

- Read the documentation at [hilla.dev/docs](https://hilla.dev/docs/).
- Ask questions on [Stack Overflow](https://stackoverflow.com/questions/tagged/hilla) or join our [Discord channel](https://discord.gg/MYFq5RTbBn).
- Report issues, create pull requests in [GitHub](https://github.com/vaadin/hilla).
