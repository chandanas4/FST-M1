package activities;

import java.awt.Point;
import java.time.Duration;
import java.util.Arrays;

import static java.time.Duration.ofMillis;

import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.MouseButton;
import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;
import org.openqa.selenium.interactions.Sequence;

import io.appium.java_client.AppiumDriver;



public class ActionsBase {
	//Set the pointer type
	static PointerInput finger = new PointerInput(Kind.TOUCH, "finger");


	public static void doSwipe(AppiumDriver driver, Point start, Point end, int duration) {
		// TODO Auto-generated method stub
		//Create the sequence of Actions
				Sequence swipe = new Sequence(finger, 1);
				swipe.addAction(finger.createPointerMove(ofMillis(0), viewport(), start.x, start.y));
				swipe.addAction(finger.createPointerDown(MouseButton.LEFT.asArg()));
				swipe.addAction(finger.createPointerMove(ofMillis(duration), viewport(), end.x, end.y));
				swipe.addAction(finger.createPointerUp(MouseButton.LEFT.asArg()));
				
				//perform the sequence
				driver.perform(Arrays.asList(swipe));
	}



}
