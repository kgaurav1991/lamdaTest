package udemy.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Ecomerse_Login {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.naukri.com/");
		
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[text()='Please enter your Email ID / Username']")).sendKeys("kgaurav4291@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("09997573409");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		
		//Print console
		System.out.println("Login Sucessfully Naukri");
		

	}

}
