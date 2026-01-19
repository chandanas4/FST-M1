package seleniumproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class projectActivity4 {

public static void main(String[] args) {
        
		// Initialize the Firefox Driver
	        WebDriver driver = new FirefoxDriver();
	        
	     // Open the page
	        driver.get("https://alchemy.hguy.co/lms");

	     // get the title of the second most popular course
	        String secondcourse = driver.findElement(By.xpath("//h3[contains(text(), 'Email Marketing')]")).getText();
	        System.out.println(secondcourse);
	     
	     // Verify the page title
	        String expectedsecondcourse = "Email Marketing Strategies";

	        if(secondcourse.equals(expectedsecondcourse)) {
	        	System.out.println("secondcourse matched and closing the browser");
	        	driver.quit();
	        }
	        
	    }
}
