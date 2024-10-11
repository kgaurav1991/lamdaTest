package SeleniumMaven.SeleniumMaven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Common_Xpath {

	public static void main(String[] args) {
		
		/*
		 * System.setProperty("WebDriver.chrome.driver",
		 * "D:\\Kumar\\Selenium\\chromedriver_win32\\chromedriver.exe");
		 */
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://www.amazon.in/");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
			driver.findElement(By.xpath("//a[@class='nav-a']")).click();

	}

}
