package activities;

import static org.testng.Assert.assertEquals;

import java.io.File;
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

public class Activity1 {

	//Declaring the driver object
		AppiumDriver driver;
		WebDriverWait wait;
		
		//Setup Function
		@BeforeClass
		public void setup() throws MalformedURLException, URISyntaxException {
			
			//Specify the apk file
			File appFile = new File("src/test/resources/Calculator_9.0 (827797324)_APKPure.apk");
			
			//desired capabilities
			UiAutomator2Options caps = new UiAutomator2Options();
			caps.setPlatformName("Android");
			caps.setAutomationName("UiAutomator2");
			caps.setApp(appFile.getAbsolutePath());
			caps.noReset();
			
			//Appiun server URL
			URL serverUrl = new URI("http://localhost:4723").toURL();
			
			//Initiate the AndroidDriver
			driver = new AndroidDriver(serverUrl,caps);
			
		}
		
		//Test Function
		@Test
		public void testMethod() {
			//Locate and tap the digit 2
			driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_2")).click();
			
			//Locate and tap the multiply sumbol
			driver.findElement(AppiumBy.accessibilityId("multiply")).click();
			
			//Locate and tap the digit 3
			driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_3")).click();
			
			//Locate and tap the equals symbol
			driver.findElement(AppiumBy.accessibilityId("equals")).click();
			
			//Get the result text and assert
			String result = driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_final")).getText();
			assertEquals(result, "6");
			
		}
		
		
		
		//Teardown Function
		public void tearDown() {
			//Close the app
			driver.quit();
		}

}
