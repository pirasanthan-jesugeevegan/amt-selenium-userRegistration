# User-Registration-Selenium
**Selenium | Maven | Cucumber | Extent Reporter | JUnit**

This repo contains the Maven setup for Cucumber / Selenium.
Using http://automationpractice.com/index.php as a exmaple website to test registration form



## Run Test
1. Download the zip or clone the Git repository.
2. Unzip the zip file (if you downloaded one).
3. Open Eclipse File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip
4. Select the right project
5. Change directory (cd) to folder containing pom.xml & runner.java
6. Right Click on the file and Run as Java Application
7. You are all Set

## Test Scenario
#### :white_check_mark:Postive Scenario
**Test Case 1 - Automate User Registration Process**

Steps to Automate:
1. Open this url  http://automationpractice.com/index.php
2. Click on sign in link.
3. Enter your email address in 'Create and account' section.
4. Click on Create an Account button.
5. Enter your Personal Information, Address and Contact info.
6. Click on Register button.
7. Validate that user is created.

#### :x:Negitibe Scenario
**Test Case 2 - Verify invalid email address error.**

Steps to Automate:
1. Open this url  http://automationpractice.com/index.php
2. Click on sign in link.
3. Enter invalid email address in the email box and click enter.
4. Validate that an error message is displaying saying "Invalid email address."


**Test Case 3 - Verify error messages for mandatory fields.**

Steps to Automate:
1. Open this url  http://automationpractice.com/index.php
2. Click on sign in link.
3. Enter email address and click Register button.
4. Leave the mandatory fields (marked with *) blank and click Register button.
5. Verify that error has been displayed for the mandatory fields.


**Test Case 4 - Verify error messages for entering incorrect values in fields.**

Steps to Automate:
1. Open this url  http://automationpractice.com/index.php
2. Click on sign in link.
3. Enter email address and click Register button.
4. Enter incorrect values in fields like., enter numbers in first and last name, city field etc and enter alphabets in Mobile no, Zip postal code etc., and click on 'Register' button.
5. Verify that error messages for respective fields are displaying.
