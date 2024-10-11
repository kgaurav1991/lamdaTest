package SeleniumMaven.SeleniumMaven;

import java.io.File;
import java.time.Duration;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.util.LoadLibs;

public class Verify_Captcha_CodeUdyam {

	@Test(enabled=true)
	public void getCaptchaCode(){
		// TODO Auto-generated method stub
		// WebDriver driver = new ChromeDriver();
		WebDriver driver = new EdgeDriver();
		try {
			driver.get("https://udyamregistration.gov.in/Udyam_Verify.aspx");
			// driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();

			// move to element
			Actions act = new Actions(driver);
			// act.moveToElement(driver.findElement(By.xpath("//a[text()='Print /
			// Verify']"))).perform();
			act.moveToElement(driver.findElement(By.xpath("/html/body/form/header/div/div/div/nav/ul/li[4]/a"))).perform();
			driver.findElement(By.xpath("//a[@href='/Udyam_Verify.aspx']")).click();

			// Udyam Registration Online Verification
			driver.findElement(By.xpath("//input[@placeholder='UDYAM-XX-00-0000000']")).sendKeys("UDYAM-XX-00-0000000");

			// Enter valid Verification Code as given in Captcha Image.
			WebElement image = driver.findElement(By.xpath("//img[@alt='Verification code']"));
			// System.out.println(driver.getTitle());
			Thread.sleep(2000);
			File screenshot = image.getScreenshotAs(OutputType.FILE);
			String path = "C:\\Users\\gaura\\eclipse-workspace\\SeleniumMaven\\Captchaimage\\captcha.png";
			File screenshotLocation = new File(path);
			// screenshot.renameTo(screenshotLocation);
			FileHandler.copy(screenshot, new File(path));
			Thread.sleep(2000);

			// Perform OCR using Tesseract
			Tesseract tesseract = new Tesseract();
			tesseract.setDatapath(LoadLibs.extractTessResources("tessdata").getPath());

			String text = tesseract.doOCR(screenshotLocation);
			System.out.println("image OCR done");
			System.out.println("Extracted Text: " + text);

			//String Captcha = text.split("sensitive")[1].replaceAll("[^a-zA-Z0-9]", "");
			String Captcha = text.replaceAll("[^a-zA-Z0-9]", "");
			System.out.println(Captcha);
			Thread.sleep(2000);

			driver.findElement(By.xpath("//input[@placeholder='Verification Code']")).sendKeys(Captcha);
			driver.findElement(By.xpath("//input[@value='Verify']")).click();
			System.out.println("Verify Successfully :"+driver.getTitle());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	@Test(enabled=false)
	public void getSingleUser_BDDStyle() {
		RestAssured.given()
		.when().get("https://udyamregistration.gov.in/Udyam_Verify.aspx")
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK");
		
	}
	 @Test(enabled=false)
	    public void verifyUdyamRegistration() {
	        // Set the base URL
	        RestAssured.baseURI = "https://udyamregistration.gov.in/Udyam_Verify.aspx-0"; // Replace with the actual base URL

	        // Create request specification
	        RequestSpecification request = RestAssured.given();

	        // Define the Udyam Registration Number and Captcha Code
	        String udyamNumber = "UDYAM-XX-00-0000000";
	        String captchaCode = "Abc123"; // Assume you somehow obtain this, possibly via OCR

	        // Create JSON payload
	        JSONObject payload = new JSONObject();
	        payload.put("udyamNumber", udyamNumber);
	        payload.put("captchaCode", captchaCode);

	        // Set headers
	        request.header("Content-Type", "application/json");

	        // Make the POST request
	        Response response = request.body(payload.toString())
	                                   .post("/verifyUdyam");

	        // Print the response for debugging
	        System.out.println(response.getBody().asString());

	        // Assert the response status code
	        Assert.assertEquals(response.getStatusCode(), 200);

	        // Additional assertions can be made based on response content
	    }

}
