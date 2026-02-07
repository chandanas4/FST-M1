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

public class ChromeActivity3 {
	
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
		
	        
	     // Scroll and locate element Popups
	        driver.findElement(AppiumBy.androidUIAutomator(
	                UiScrollable + ".scrollTextIntoView(\"Popups\")")).click();
	        
	        //Wait for the popup page to load
	        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.Button[@resource-id=\"launcher\"]")));
	        
	        //click on button to view the logim form
	        driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"launcher\"]")).click();
	        
	      //Wait for the login popup to load
	        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]")));
		
	        
	        //enter the username and password
	        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]")).sendKeys("admin");
	        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]")).sendKeys("password");
	        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Submit\"]")).click();
	        
	        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Login Success!\"]")));
	        
	        String successmessage = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Login Success!\"]")).getText();
	        assertEquals(successmessage,"Login Success!");
	        System.out.println("login success");
}
		
		//Teardown Function
				public void tearDown() {
					//Close the app
					driver.quit();
				}
				
		
}