package seleniumproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class projectActivity1 {
	
	public static void main(String[] args) {
         
	// Initialize the Firefox Driver
        WebDriver driver = new FirefoxDriver();
        
     // Open the page
        driver.get("https://alchemy.hguy.co/lms");


     // Verify the page title
        String actualTitle = driver.getTitle();
        String expectedTitle = "Alchemy LMS – An LMS Application";
        System.out.println(actualTitle);

        if(actualTitle.equals(expectedTitle)) {
        	System.out.println("title matched and closing the browser");
        	driver.quit();
        }
        
    }
	
}
