package lambdatest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestScenario3 {
	@Test
	public void testScenario3() {
		 WebDriver driver = new ChromeDriver();

	        try {
	            driver.get("https://www.lambdatest.com/selenium-playground");
	            driver.findElement(By.linkText("Input Form Submit")).click();
	            driver.findElement(By.name("name")).sendKeys("John Doe");
	            driver.findElement(By.xpath("//*[@id=\"inputEmail4\"]")).sendKeys("johndoe@example.com");
	            driver.findElement(By.xpath("//*[@id=\"inputPassword4\"]")).sendKeys("1234567890");
	            driver.findElement(By.id("company")).sendKeys("123 Elm Street");
	            driver.findElement(By.id("websitename")).sendKeys("www.lambda.com");
	            Thread.sleep(1000);
	            Select countryDropdown = new Select(driver.findElement(By.xpath("//*[@id=\"seleniumform\"]/div[3]/div[1]/select")));
	            countryDropdown.selectByVisibleText("United States");
	            driver.findElement(By.id("inputCity")).sendKeys("New York");
	            driver.findElement(By.id("inputAddress1")).sendKeys("https://example.com");
	            driver.findElement(By.id("inputAddress2")).sendKeys("This is a test comment.");
	            driver.findElement(By.id("inputState")).sendKeys("UK");
	            driver.findElement(By.id("inputZip")).sendKeys("100102");
	            driver.findElement(By.xpath("//*[text()='Submit']")).click();
	   
	            WebElement successMessage = driver.findElement(By.cssSelector(".success-msg"));
	            Assert.assertEquals(successMessage.getText(), "Thanks for contacting us, we will get back to you shortly.", "Success message mismatch");

	            System.out.println("Test passed: Form submitted and success message is displayed correctly.");

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	           driver.quit();
	        }
	}

}
