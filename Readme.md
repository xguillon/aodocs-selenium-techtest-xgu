# AODocs Selenium technical test

This project is about assessing QA automation abilities.

## Getting Started

### Prerequisites
* Java JDK: 10 or higher
* Maven: 3.3.9 or higher

## Test Objectives
The marketing team ask you to write an automation test to validate how prospect access to our website, and the form to request a demo of the product.
 
The test steps are:
 1. Search AODocs in Google
 2. In the result, open the website www.aodocs.com
 3. Into the website click on the "Request a demo" button
 4. Fill the form with:
     * your first name
     * set empty in the "Last Name" field
     * fill a random string in the "Your Email" field
     * choose a value in Company Size
 5. Check the error messages

## Notes
In this project you can find a utility class "WebDriverUtility" to help you to start a browser locally.
To write the test, you need to use Junit 5 already configured in pom.xml

## Project architecture
- in com.aodocs.test.core package : all classes needed to interact with page, launch browser, assertions with screenshot, etc...
- in com.aodocs.test.bindings : all queries used
- in com.aodocs.test.behavior : all actions possible in pages. There is no page object model, but several actions which can be used together
- in com.aodocs.test.checkers : each checker is an action + the corresponding assertion. TestCases will mostly use checkers
- in com.aodocs.test.checkers : some beans to modelise data
- in com.aodocs.test.testcase : all testcases

## Execution
Testcase can be launched as a JUnit test (tested only in Eclipse).
Test can be launched with ```mvn test -Dconfig=path/to/config/config.json```. A default config file is present in com.aodocs.test.core.config.config-example.json

configuration must be like :
```
{
"timeout":10,
"isGrid":false,
"gridServer":"http://localhost:4444/wd/hub",
"browser":"CHROME",
"screenshot":"NONE"
}
```
with the following value : 
- timeout : maximum wait time before trying to perform action on element (error is returned if element never appears)
- isGrid : if true, selenium grid is used to execute test, if false, test is executed locally
- browser: CHROME or FIREFOX
- screenshot : NONE no screenshot taken, FAIL : screenshot taken only when a fail occurs, ALL : screenshot taken at all assertions



## TODO
- improve logs (present only in assertion class and in UIActions class)
- Improve Steps description and testcase description.
- configure correct issue and tms links
- query real TMS to get a real description of test
- add tag to launch all tests by tag if needed
- configure CI/CD to execute tests

## Reporting
Allure files are generated in /target/allure-results.
To generate the report, go to /target and execute : 
```path\to\allure\bin\allure generate -c
path\to\allure\bin\allure serve```


