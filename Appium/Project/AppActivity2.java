package projectactivity;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.interactions.Sequence;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AppActivity2 {
	
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

//Test Function
@Test
public void longPressOnTask() {

    // Wait for element
    WebElement Activity1taskItem = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                    AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.app.todolist:id/tv_exlv_task_name\" and @text=\"Activity 1\"]")));

    // Perform long press
    longPress(Activity1taskItem);

    //click Edit to do option after long press
    WebElement EditOption = wait.until(
            ExpectedConditions.elementToBeClickable(
                    AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Edit To-Do Task\"]")));
          
    EditOption.click();
    
    //Set the deadline 
    driver.findElement(AppiumBy.id("com.app.todolist:id/tv_todo_list_deadline")).click();
    driver.findElement(AppiumBy.accessibilityId("14 February 2026")).click();
    driver.findElement(AppiumBy.id("com.app.todolist:id/bt_deadline_ok")).click();
    driver.findElement(AppiumBy.id("com.app.todolist:id/bt_new_task_ok")).click();
    
    String Deadlinetext = driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@resource-id=\"com.app.todolist:id/tv_exlv_task_deadline\"])[1]")).getText();
    assertEquals(Deadlinetext, "Deadline: 14.02.2026");
    
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

//Teardown Function
public void tearDown() {
//Close the app
driver.quit();
}

}
