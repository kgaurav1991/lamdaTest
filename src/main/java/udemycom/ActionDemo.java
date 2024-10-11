package udemycom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionDemo extends BaseTest{

	public WebDriver driver;
	//public Object PageFactory.in;



	public ActionDemo(WebDriver driver) {
			this.driver = driver;
	}



	@Test
	public void goTo() throws InterruptedException {
	
	driver.get("https://www.amazon.in/");
    Actions act = new Actions(driver);
    act.moveToElement(driver.findElement(By.xpath("//span[@class='nav-line-2 ']"))).perform();
    Thread.sleep(5000);
    driver.findElement(By.xpath("//span[text()='Create a Wish List']")).click();
    System.out.println(driver.getTitle());
    driver.close();

	}

}
