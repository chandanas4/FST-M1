package seleniumproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class projectActivity3 {
	
public static void main(String[] args) {
        
		// Initialize the Firefox Driver
	        WebDriver driver = new FirefoxDriver();
	        
	     // Open the page
	        driver.get("https://alchemy.hguy.co/lms");


	     // get the title of first info box
	        String firstinfotitle = driver.findElement(By.xpath("//h3[contains(text(), 'Actionable')]")).getText();
	        System.out.println(firstinfotitle);
	     
	     // Verify the page title
	        String expectedinfotitle = "Actionable Training";

	        if(firstinfotitle.equals(expectedinfotitle)) {
	        	System.out.println("infotitle matched and closing the browser");
	        	driver.quit();
	        }
	        
	    }
		

}
