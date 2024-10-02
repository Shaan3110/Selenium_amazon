# Amazon Automation Project

This project automates Amazon's search functionality using Selenium WebDriver and TestNG. It supports multi-browser execution, allowing you to run the tests across different browsers. The example shown in the `testng.xml` file outlines the execution configuration and structure.

## Project Structure


This project automates various functionalities on Amazon using Selenium WebDriver, supporting execution on multiple browsers. It provides a sample test case demonstrating product search, but you can easily extend it to automate other scenarios based on your needs.


    ├── src │ 
        └── java │ 
        └── test │ 
            └── base 
             └── BaseTest.java 
            └── utilities 
             └── AccessProperties.java 
            └── testcases 
             └── Test.java
        └── resources 
            └── PropertiesFIle.utilities
    └── testRunner 
        └── prod 
             └── amazon.xml
        └── uat 
             └── amazonUat.xml
    ├── pom.xml

## Prerequisites

1. **Java**: Ensure that you have JDK 8 or above installed.
2. **Maven**: This project uses Maven as the build tool.
3. **Selenium WebDriver**: WebDriver dependencies are managed through the Maven `pom.xml`.
4. **TestNG**: The testing framework used is TestNG.

Clone the Repository:

    
     git clone https://github.com/yourusername/AmazonAutomation.git
     cd AmazonAutomation

Replace <your-username> with your GitHub username and <your-repository-name> with the name of your cloned repository.   

Set Up Project:
Open the project directory in your preferred IDE.

Configure Build and Dependencies:
Ensure your pom.xml file includes the following dependencies:

    
    <dependency>
        <groupId>org.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.7.4</version> </dependency>
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.6.1</version>   
     </dependency>   


Configure Browser Drivers (Optional):
If you're not using system-wide installation, set the WebDriver binary paths in your code using system utilities like this:

    
    System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
    System.setProperty("webdriver.gecko.driver", "/path/to/geckodriver");   


Running the Tests

Command Line (Recommended):
Open a terminal in your project directory and run:

    
    mvn test


This command compiles your project, downloads dependencies, and executes the test suite.

### Explanation of the Code

The provided testng.xml file defines a test suite named "Automation Suite" with verbose output enabled (verbose="1"). The suite contains a single test named "All Testcases" configured to run with a single thread (thread-count="1"). It also defines two parameters:

username: Stores the username for login (currently set to "testsalesrep1").
password: Stores the password (currently set to "@1234" - replace with a secure password for testing).
The <classes> section specifies the test case class to be executed, which is testcases.SearchProductTest in this example. This class would likely contain code using Selenium WebDriver to access Amazon, search for products, and perform other actions based on your requirements.

### Extending Functionality

Create additional test case classes for different Amazon functionalities.
Parameterize tests to handle multiple data sets (e.g., various search terms, products to add to cart).
Use Page Object Model (POM) for better code organization and maintainability.
Integrate with a reporting framework (e.g., TestNG Reports, Extent Reports) for visual test results.
Multi-Browser Support (Optional)

Download the WebDriver binaries for the desired browsers (e.g., edgedriver).
Configure the WebDriver paths (as shown in "Configure Browser Drivers" above).
Implement code to create WebDriver instances for different browsers using appropriate classes (e.g., ChromeDriver, FirefoxDriver, EdgeDriver). Consider using a factory pattern for cleaner WebDriver management.
Additional Notes

Remember to create actual test cases extending testng.framework.TestngTest within testcases.SearchProductTest or similar classes.
Use appropriate assertions (e.g., assertEquals, assertTrue) to verify expected behavior in your tests
