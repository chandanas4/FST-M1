package activities;

import static org.testng.Assert.assertEquals;

import java.awt.Point;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity6 {
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
		
		// Open the page in Chrome
        driver.get("https://training-support.net/webelements/sliders");
		
	}
	
	//Test Function
	@Test
	public void volume25Test() {
		//Get the dimensions of the device
		Dimension dims = driver.manage().window().getSize();
		
		//Start and End Point calculation
		
		int startX = (int)(0.5 * dims.getWidth());
		int startY = (int)(0.72 * dims.getHeight());
		Point start = new Point(startX, startY);
		System.out.println(startX+","+startY);
		
		int endX = (int)(0.33 * dims.getWidth());
		int endY = (int)(0.72 * dims.getHeight());
		Point end = new Point(endX, endY);
		
		//Perform the swipe action
		ActionsBase.doSwipe(driver, start, end, 2000);
		
		//Get the volumetext and assert
	   String volumeTest = driver.findElement(AppiumBy.xpath("//android.widget.TextView[contains(@text,'%')]")).getText();
	assertEquals(volumeTest,"25%");

	}
	
    public void volume75Test() {
    	//Get the dimensions of the device
    			Dimension dims = driver.manage().window().getSize();
    			
    			//Start and End Point calculation
    			
    			int startX = (int)(0.5 * dims.getWidth());
    			int startY = (int)(0.72 * dims.getHeight());
    			Point start = new Point(startX, startY);
    			System.out.println(startX+","+startY);
    			
    			int endX = (int)(0.69 * dims.getWidth());
    			int endY = (int)(0.72 * dims.getHeight());
    			Point end = new Point(endX, endY);
    			
    			//Perform the swipe action
    			ActionsBase.doSwipe(driver, start, end, 2000);
    			
    			//Get the volumetext and assert
    		   String volumeTest = driver.findElement(AppiumBy.xpath("//android.widget.TextView[contains(@text,'%')]")).getText();
    		assertEquals(volumeTest,"25%");

		
	}
	
	
	//Teardown Function
	public void tearDown() {
		//Close the app
		driver.quit();
	}

	
}
