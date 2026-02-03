package activities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity4 {
	
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
			caps.setAppPackage("com.google.android.contacts");
			caps.setAppActivity("com.android.contacts.activities.PeopleActivity");
			caps.noReset();
			
			//Appiun server URL
			URL serverUrl = new URI("http://localhost:4723").toURL();
			
			//Initiate the AndroidDriver
			driver = new AndroidDriver(serverUrl,caps);
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			
		}
		
		//Test Function
		@Test
		public void contactsTest() {
			// Find and click the add button
	        driver.findElement(AppiumBy.accessibilityId("Create new contact")).click();
	 
	        // Wait for elements to load
	        wait.until(ExpectedConditions.elementToBeClickable(
	                AppiumBy.xpath("//android.widget.EditText[@text='First name']")
	        ));
	 
	        // Enter the details
	        driver.findElement(AppiumBy.xpath(
	                "//android.widget.EditText[@text='First name']"
	        )).sendKeys("Aaditya");
	        driver.findElement(AppiumBy.xpath(
	                "//android.widget.EditText[@text='Last name']"
	        )).sendKeys("Varma");
	        driver.findElement(AppiumBy.xpath(
	                "//android.widget.EditText[@text='Phone']"
	        )).sendKeys("999148292");
	        // Click Save
	        driver.findElement(AppiumBy.id("editor_menu_save_button")).click();
	 
	        // Wait for contact to save
	        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("large_title")));
	 
	        // Assertion
	        String contactName = driver.findElement(AppiumBy.id("large_title")).getText();
	        Assert.assertEquals(contactName, "Aaditya Varma");
		}
		
		//Teardown Function
		public void tearDown() {
			//Close the app
			driver.quit();
		}


}
