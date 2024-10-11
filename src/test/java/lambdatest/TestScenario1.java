package lambdatest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestScenario1 {

	@Test
	public void testScenario1() {
		WebDriver driver = new ChromeDriver();

		try {

			driver.get("https://www.lambdatest.com/selenium-playground");
			driver.findElement(By.linkText("Simple Form Demo")).click();
			String currentUrl = driver.getCurrentUrl();
			Assert.assertTrue(currentUrl.contains("simple-form-demo"), "URL validation failed");
			String message = "Welcome to LambdaTest";
			driver.findElement(By.id("user-message")).sendKeys(message);
			driver.findElement(By.id("showInput")).click();
			String displayedMessage = driver.findElement(By.id("message")).getText();
			Assert.assertEquals(displayedMessage, message, "Message validation failed");

			System.out.println("Test passed: Message is displayed correctly.");
		} finally {
			driver.quit();
		}

	}

}
