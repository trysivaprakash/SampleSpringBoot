# sample-spring-boot-service
Sample application for spring boot application

## Prerequisites 

- Java 8
- Install lombok plugin
- Install scala plugin(for performance test using Gatling)

## Build and Deploy

The project can be built using below gradle command
```bash
$ ./gradlew clean build
```
The built artifact can be deployed through PCF CLI with the following command
```bash
$ cf push -f manifest-{env}.yml
```
*Note: env is the enviornment in which the application is deployed eg QA, PR etc

## Testing
This project supports three different types of automated testing, unit tests,integration tests, and functional tests.
Gradle is configured so that each type of testing can be run individually. The test results are stored in separate
directories so we can send the required information to Quality Hub, and the generated reports are grouped the test type.

Use the following command to run the unit tests:
```bash
$ gradle clean test
```
Use the following command to run the integration tests:
```bash
$ gradle clean integrationTest
```
Use the following command to run the functional (user acceptance) tests:
```bash
$ gradle clean functionalTest
```
Use the following command to run the performance tests:
```bash
$ gradle clean performanceTest
```
Notes: 
- By default, functional test expects a running instance of the application on localhost at port 8080. If we
want to run them as part of our pipeline, the URL of the service being tested must be externalized so we can change it
without recompiling anything.
- When running the functional tests, the URL of the host that will be called based on two things; the URLs found in 
the src/funtionalTest/resources/application.yml file, and the value assigned to the 'lcp' environment variable. When 
running from the command line us this command to set lcp to the desired value:
```bash
$ export lcp="<value>"
```

The same applicable for performanceTest as well.

When running the test from your IDE you will need to include it in the test configuration.

## Documentation

Swagger Docs: [http://localhost:8082](http://localhost:8082)