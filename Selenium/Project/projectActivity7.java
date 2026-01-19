package seleniumproject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class projectActivity7 {

	
public static void main(String[] args) {
        
		// Initialize the Firefox Driver
	        WebDriver driver = new FirefoxDriver();
	        
	     // Open the page
	        driver.get("https://alchemy.hguy.co/lms");
	        
	     //navigate to All Courses in Navigation bar and click
	        driver.findElement(By.linkText("All Courses")).click();
	        
	        
	     //wait until the page is loaded
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.titleContains("All Courses"));
	        
	        
	     //find the number of courses in the page
	        List<WebElement> courses =driver.findElements(By.className("entry-title"));
	        int courseCount = courses.size();
	        System.out.println("Number of courses: " + courseCount);
	        
	        driver.quit();
}

}
