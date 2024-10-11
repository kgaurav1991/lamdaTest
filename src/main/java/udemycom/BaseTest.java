package udemycom;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public ActionDemo action;

	@Test
	public WebDriver initializeDriver() throws IOException{
		Properties pro = new Properties();
		//FileInputStream fil = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\udemycom\\GlobleDate.properties");
		FileInputStream fil = new FileInputStream("C:\\Users\\gaura\\eclipse-workspace\\SeleniumMaven\\src\\main\\java\\udemycom\\GlobleDate.properties");
		
		pro.load(fil);
		String browserName = pro.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			//chrome browser
			WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
			
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			//fire fox
			
			
		}
		else if(browserName.equalsIgnoreCase("Edge")) {
			// Edge 
			System.setProperty("webdriver.edge.driver", "edge.exe");
			driver = new EdgeDriver();
			
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
		
	}
	@BeforeMethod
	public ActionDemo lunchApplication() throws IOException, InterruptedException {
		driver = initializeDriver();
		action = new ActionDemo(driver);
		action.goTo();
		return action;
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
