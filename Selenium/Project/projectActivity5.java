package seleniumproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class projectActivity5 {
	
public static void main(String[] args) {
        
		// Initialize the Firefox Driver
	        WebDriver driver = new FirefoxDriver();
	        
	     // Open the page
	        driver.get("https://alchemy.hguy.co/lms");
	        
	     //navigate to My Account in Navigation bar and click
	        driver.findElement(By.linkText("My Account")).click();
	        
	     //wait until the page is loaded
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.titleContains("My Account"));
	      
	     //read the page title
	        String MyAccounttitle= driver.getTitle();
	        System.out.println(MyAccounttitle);
	        
	        if(MyAccounttitle.contains("My Account")){
	        	System.out.println("we are in correct page");
	        }
	             
	        
	        driver.quit();
	      
}

}
