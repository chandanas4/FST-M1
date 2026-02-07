package projectactivity;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class ChromeActivity2 {
	
	//Declaring the driver object
	AppiumDriver driver;
	WebDriverWait wait;
	
	//Setup Function
	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException {
		
		
		//desired capabilities
		UiAutomator2Options caps = new UiAutomator2Options();
		caps.setPlatformName("Android");
		caps.setAutomationName("UiAutomator2");
		caps.setAppPackage("com.android.chrome");
		caps.setAppActivity("com.google.android.apps.chrome.Main");
		caps.noReset();
		
		//Appium server URL
		URL serverUrl = new URI("http://localhost:4723").toURL();
		
		//Initiate the AndroidDriver
		driver = new AndroidDriver(serverUrl,caps);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		// Open the page in Chrome
        driver.get("https://training-support.net/webelements");
        

}
	
	@Test
	public void testmethod() {
		String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
		//wait for the page to load
		wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.className("android.view.View")));
	
        
     // Scroll and locate element Login form
        driver.findElement(AppiumBy.androidUIAutomator(
                UiScrollable + ".scrollTextIntoView(\"Login Form\")"
        )).click();
        
        // Wait for the page to load
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]")));

        
        //Enter the correct username and password
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]")).sendKeys("admin");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]")).sendKeys("passw0rd");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Submit\"]")).click();
        
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"subheading\"]")));
        
        String failuremessage = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"subheading\"]")).getText();
        assertEquals(failuremessage, "Invalid credentials");
        System.out.println("Login failed");
        
       
        //Enter the correct username and password
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]")).sendKeys("admin");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]")).sendKeys("password");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Submit\"]")).click();
        
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"subheading\"]")));
        
        String successmessage = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Login Success!\"]")).getText();
        assertEquals(successmessage, "Login Success!");
        System.out.println("Login Success");
        
        
        
        
		
		
	}
	
	//Teardown Function
		public void tearDown() {
			//Close the app
			driver.quit();
		}
		
	
	
	
}
