package activities;


import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;


import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity2 {
	
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
	        driver.get("https://training-support.net");
			
		}
		
		//Test Function
		@Test
		public void testMethod() {
			//Locate the heading on the page and print it to console.
			
			String pageheading = driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@text=\"Training Support\"])[1]")).getText();
			System.out.println("Heading: " + pageheading);
			
			//Locate the About Us button and click it.
			driver.findElement(AppiumBy.accessibilityId("About Us")).click();
			
			//Print the heading on the About Us page to the console
			String aboutusheading = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"About Us\"]")).getText();
			System.out.println("Heading: " + aboutusheading);
			
			
			
		}
		
		
		
		//Teardown Function
		public void tearDown() {
			//Close the app
			driver.quit();
		}


}
