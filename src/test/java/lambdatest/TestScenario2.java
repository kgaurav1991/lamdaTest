package lambdatest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestScenario2 {
	@Test
	public void testScenario2() {

		WebDriver driver = new ChromeDriver();

		try {
			
			driver.get("https://www.lambdatest.com/selenium-playground");
			driver.findElement(By.linkText("Drag & Drop Sliders")).click();
			WebElement slider = driver.findElement(By.xpath("//input[@value='15']"));
			WebElement rangeValue = driver.findElement(By.id("range"));
			Actions actions = new Actions(driver);
			actions.clickAndHold(slider).moveByOffset(150, 0).release().perform(); 
			Thread.sleep(1000);
			String value = rangeValue.getText();
			Assert.assertEquals(value, "95", "Slider value mismatch. Expected: 95, Found: " + value);

			System.out.println("Test passed: Slider value is correctly set to 95.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//driver.quit();
		}

	}

}
