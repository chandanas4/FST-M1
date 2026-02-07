package projectactivity;
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
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;


public class AppActivity1 {
	
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
			
				
				caps.setAppPackage("com.app.todolist");
				//caps.setAppActivity("com.app.todolist.view.MainActivity");
				caps.setNoReset(true);
				caps.setAutoGrantPermissions(true);
				
				//Appium server URL
				URL serverUrl = new URI("http://localhost:4723").toURL();
				
				//Initiate the AndroidDriver
				driver = new AndroidDriver(serverUrl,caps);
				((InteractsWithApps) driver).activateApp("com.app.todolist");

	}
	
	//Test Function
	@Test
	public void testMethod() {
		
		//Click the button to add a new task.
		driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@resource-id=\"com.app.todolist:id/fab_new_task\"]")).click();
		//Add the activity 1
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.app.todolist:id/et_new_task_name\"]")).sendKeys("Activity 1");
		driver.findElement(AppiumBy.id("com.app.todolist:id/et_new_task_description")).sendKeys("Complete Activity 1");
		driver.findElement(AppiumBy.id("com.app.todolist:id/tv_new_task_priority")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"High\"]")).click();
		driver.findElement(AppiumBy.id("com.app.todolist:id/bt_new_task_ok")).click();
		
		//assert activity 1 added
		String TextActivity1 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.app.todolist:id/tv_exlv_task_name\" and @text=\"Activity 1\"]")).getText();
        Assert.assertEquals(TextActivity1, "Activity 1");
        System.out.println("activity1 added");
		
		//Click the button to add a new task.
		driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@resource-id=\"com.app.todolist:id/fab_new_task\"]")).click();
				//Add the activity 2
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.app.todolist:id/et_new_task_name\"]")).sendKeys("Activity 2");
	    driver.findElement(AppiumBy.id("com.app.todolist:id/et_new_task_description")).sendKeys("Complete Activity 2");
		driver.findElement(AppiumBy.id("com.app.todolist:id/tv_new_task_priority")).click();
	    driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Medium\"]")).click();
		driver.findElement(AppiumBy.id("com.app.todolist:id/bt_new_task_ok")).click();
		
		//assert activity 2 added
		String TextActivity2 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.app.todolist:id/tv_exlv_task_name\" and @text=\"Activity 2\"]")).getText();
		Assert.assertEquals(TextActivity2, "Activity 2");
		System.out.println("activity2 added");
				
		//Click the button to add a new task.
		driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@resource-id=\"com.app.todolist:id/fab_new_task\"]")).click();
				//Add the activity 3
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.app.todolist:id/et_new_task_name\"]")).sendKeys("Activity 3");
		driver.findElement(AppiumBy.id("com.app.todolist:id/et_new_task_description")).sendKeys("Complete Activity 3");
	    driver.findElement(AppiumBy.id("com.app.todolist:id/tv_new_task_priority")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Low\"]")).click();
		driver.findElement(AppiumBy.id("com.app.todolist:id/bt_new_task_ok")).click();
		
		
		//assert activity 3 added
		String TextActivity3 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.app.todolist:id/tv_exlv_task_name\" and @text=\"Activity 3\"]")).getText();
		Assert.assertEquals(TextActivity3, "Activity 3");
		System.out.println("activity3 added");

	}
	
	//Teardown Function
	public void tearDown() {
		//Close the app
		driver.quit();
	}
	
}



