package com.example.tests; // Change this to your package name

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;

public class LambdaTest {

    WebDriver driver;
    String username = "kumar.gaurav40@wipro.com"; 
    String accessKey = "528665";
    String gridURL = "https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub";

    @BeforeTest
    public void setUp() throws Exception {
        // Set Desired Capabilities for the LambdaTest Grid
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("version", "latest");
        capabilities.setCapability("platform", "Windows 10");

        // Enable network logs, video recording, and console logs on LambdaTest Cloud
        capabilities.setCapability("network", true);  // To enable network logs
        capabilities.setCapability("video", true);    // To enable video recording
        capabilities.setCapability("console", true);  // To enable console logs

        // Set the test build name and test name
        capabilities.setCapability("build", "LambdaTest Java Parallel");
        capabilities.setCapability("name", "Sample Test");

        // Initialize the Remote WebDriver with LambdaTest Grid URL
        driver = new RemoteWebDriver(new URL(gridURL), capabilities);
    }

    @Test
    public void testLambdaTest() throws InterruptedException {
        // Sample test to navigate to LambdaTest website and print the title
        driver.get("https://www.lambdatest.com");
        System.out.println("Title of the page is: " + driver.getTitle());
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // Close the browser after the test
        }
    }
}
