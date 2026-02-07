package projectactivity;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class ChromeActivity1 {
	
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
		
		// Just scroll
        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".flingForward()"));
        //find the to do list and click
        driver.findElement(AppiumBy.accessibilityId("To-Do List Elements get added at runtime!")).click();
        
        // Wait for the page to load
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.className("android.widget.EditText")));
        
        //add three tasks
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"todo-input\"]")).sendKeys("Add tasks to list");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"todo-add\"]")).click();
        
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"todo-input\"]")).sendKeys("Get number of tasks");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"todo-add\"]")).click();
        
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"todo-input\"]")).sendKeys("Clear the list");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"todo-add\"]")).click();
        
        //Click on each of the tasks added to strike them out.
        driver.findElement(AppiumBy.xpath("//android.widget.ListView/android.view.View[3]/android.view.View/android.widget.CheckBox")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.ListView/android.view.View[4]/android.view.View/android.widget.CheckBox")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.ListView/android.view.View[5]/android.view.View/android.widget.CheckBox")).click();
        
        
       //Add assertions to verify the count of the number of tasks in the list
        List<WebElement> checkBoxes = driver.findElements(AppiumBy.className("android.widget.CheckBox"));
        int TaskCount = 0;

        for (WebElement checkbox : checkBoxes) {
TaskCount++;}

   	 System.out.println("task list count"+TaskCount);
     
		
		
		
	}
	//Teardown Function
		public void tearDown() {
			//Close the app
			driver.quit();
		}
		
			

	}

