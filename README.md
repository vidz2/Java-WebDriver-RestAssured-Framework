# WebDriver and RestAssured Test Framework #

This test framework has been created using Java, Selenium WebDriver, TestNG and RestAssured. 

## Prerequisites: ##
   * Java 1.8.x
   * Apache Maven 3 or above
   
## Execution

* Clone the repository
* Open terminal or command prompt and cd to the 'java-webdriver-restassured-framework' directory

## To Run all tests
  Run command : ``mvn clean test``
## To Run UI tests only
  Run command ``mvn clean test -Dgroups=ui_test``
## To Run API tests only
    Run command ``mvn clean test -Dgroups=api_test``
    
## Tests
There are two Test classes found under /test/java/tmsandbox/tests directory. The 'UsedCarsUITests' class contains 3 tests to do the following:
* Navigate to https://www.tmsandbox.co.nz/motors/used-cars/more-makes
* Get the list of Used cars brands on the page
* Match the list of car brands against the sandbox API
* Verify the brand 'Kia' exists in the list and print the number of listings for it.
* Verify the brand 'Hispano Suiza' does not exist in the list

The 'UsedCarsAPITests' class contains 3 tests to do the following:

* Makes a GET request to https://api.tmsandbox.co.nz/Categories/UsedCars.json?with_counts=true
* Get the list of Used cars brands and verify the list is not null
* Verify the brand 'Kia' exists in the list and print the number of listings for it.
* Verify the brand 'Hispano Suiza' does not exist in the list

## WebDriver UI Tests
The WebDriver UI Tests are designed to run on Chrome or Firefox. The tests are run in parallel - the number of threads can be changed in the pom.xml file.








