package activities;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity3 {
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
	
		public void additionTest() {
	        // Perform the calculation
		//Calculate 5 + 9 and print the result to the console.
	        driver.findElement(AppiumBy.id("digit_5")).click();
	        driver.findElement(AppiumBy.accessibilityId("plus")).click();
	        driver.findElement(AppiumBy.id("digit_9")).click();
	        driver.findElement(AppiumBy.accessibilityId("equals")).click();
	 
	        // Find the result
	        String result = driver.findElement(AppiumBy.id("result_final")).getText();
	 
	        // Assertion
	        Assert.assertEquals(result, "14");
	    }
	 
	    // Test method
	    @Test
	    public void subtractTest() {
	        // Perform the calculation
	        driver.findElement(AppiumBy.id("digit_1")).click();
	        driver.findElement(AppiumBy.id("digit_0")).click();
	        driver.findElement(AppiumBy.accessibilityId("minus")).click();
	        driver.findElement(AppiumBy.id("digit_5")).click();
	        driver.findElement(AppiumBy.accessibilityId("equals")).click();
	 
	        // Find the result
	        String result = driver.findElement(AppiumBy.id("result_final")).getText();
	 
	        // Assertion
	        Assert.assertEquals(result, "5");
	    }
	 
	    // Test method
	    @Test
	    public void multiplyTest() {
	        // Perform the calculation
	        driver.findElement(AppiumBy.id("digit_5")).click();
	        driver.findElement(AppiumBy.accessibilityId("multiply")).click();
	        driver.findElement(AppiumBy.id("digit_1")).click();
	        driver.findElement(AppiumBy.id("digit_0")).click();
	        driver.findElement(AppiumBy.id("digit_0")).click();
	        driver.findElement(AppiumBy.accessibilityId("equals")).click();
	 
	        // Find the result
	        String result = driver.findElement(AppiumBy.id("result_final")).getText();
	 
	        // Assertion
	        Assert.assertEquals(result, "500");
	    }
	 
	    // Test method
	    @Test
	    public void divideTest() {
	        // Perform the calculation
	        driver.findElement(AppiumBy.id("digit_5")).click();
	        driver.findElement(AppiumBy.id("digit_0")).click();
	        driver.findElement(AppiumBy.accessibilityId("divide")).click();
	        driver.findElement(AppiumBy.id("digit_2")).click();
	        driver.findElement(AppiumBy.accessibilityId("equals")).click();
	 
	        // Find the result
	        String result = driver.findElement(AppiumBy.id("result_final")).getText();
	 
	        // Assertion
	        Assert.assertEquals(result, "25");
		
	}
	
	
	
	//Teardown Function
	public void tearDown() {
		//Close the app
		driver.quit();
	}


}
