package SeleniumMaven.SeleniumMaven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Naukri_Login {
	public ChromeDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("WebDriver.chrome.driver",
				"D:\\Kumar\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		// System.out.println(driver.getTitle());
	}

	@Test
	public void openUrl() throws Exception {
		driver.get("https://www.naukri.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.id("login_Layer")).click();
		System.out.println("Open Url");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".err-border")).sendKeys("kgaurav4291@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("09997573409");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		System.out.println("Login S");

	}

}
