package projectactivity;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AppActivity3 {
	
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
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			((InteractsWithApps) driver).activateApp("com.app.todolist");

	}
		
   @Test
   public void testmethod() {
	   
	   //Mark the first two tasks as complete
	   driver.findElement(AppiumBy.xpath("(//android.widget.CheckBox[@resource-id=\"com.app.todolist:id/cb_task_done\"])[1]")).click();
	   driver.findElement(AppiumBy.xpath("(//android.widget.CheckBox[@resource-id=\"com.app.todolist:id/cb_task_done\"])[2]")).click();
	   
	   WebElement Activity3taskItem = driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout[@resource-id=\"com.app.todolist:id/rl_exlv_task_group_root\"])[3]"));
	    // Perform long press
	    longPress(Activity3taskItem);

	    //click Edit to do option after long press
	    WebElement EditOption = wait.until(
	            ExpectedConditions.elementToBeClickable(
	                    AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Edit To-Do Task\"]")));
	          
	    EditOption.click();
	    //progress to 50%
	    Dimension dims = driver.manage().window().getSize();
	    

	    int X = (int)(0.605 * dims.getWidth());
		int Y = (int)(0.542 * dims.getHeight());
		
		//Perform the Progress action
		tapOn50(X,Y);
		
		String progressText = driver.findElement(
	            AppiumBy.id("com.app.todolist:id/new_task_progress")
	    ).getText();

	    assertEquals(progressText, "50%");
	    driver.findElement(AppiumBy.id("com.app.todolist:id/bt_new_task_ok")).click();
	    
	    
	    //filter the completed tasks
	    driver.findElement(AppiumBy.accessibilityId("More options")).click();
	    
	    WebElement completedtasks = wait.until(
	            ExpectedConditions.elementToBeClickable(
	                    AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.app.todolist:id/title\" and @text=\"Completed tasks\"]")));
	          
	    completedtasks.click();
	    
	    
	    List<WebElement> checkBoxes = driver.findElements(AppiumBy.className("android.widget.CheckBox"));
	 // Verify all checkboxes are checked i.e., only completed activites are available in the list
	    int CompletedCount = 0;
	    for (WebElement checkBox : checkBoxes) {
	        Assert.assertEquals(
	                checkBox.getAttribute("checked"),
	                "true");
	        CompletedCount++;
	    }
	    
	    System.out.println("Completed tasks"+CompletedCount);
	        
   }
   
   
// -------- LONG PRESS METHOD --------
public void longPress(WebElement element) {

    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
    Sequence longPress = new Sequence(finger, 1);

    int centerX = element.getRect().getX() + element.getRect().getWidth() / 2;
    int centerY = element.getRect().getY() + element.getRect().getHeight() / 2;

    longPress.addAction(finger.createPointerMove(
            Duration.ZERO,
            PointerInput.Origin.viewport(),
            centerX,
            centerY
    ));
    longPress.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
    longPress.addAction(new Pause(finger, Duration.ofSeconds(2))); // long press duration
    longPress.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

    driver.perform(Arrays.asList(longPress));
}

//-----------move progress bar method--------------
public void tapOn50(int x, int y) {

    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
    Sequence tap = new Sequence(finger, 1);

    tap.addAction(finger.createPointerMove(
            Duration.ZERO,
            PointerInput.Origin.viewport(),
            x,
            y
    ));
    tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
    tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

    driver.perform(Arrays.asList(tap));
}

    
//Teardown Function
	public void tearDown() {
		//Close the app
		driver.quit();
	}
	

}



