package seleniumproject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class projectActivity2 {
	
	public static void main(String[] args) {
        
		// Initialize the Firefox Driver
	        WebDriver driver = new FirefoxDriver();
	        
	     // Open the page
	        driver.get("https://alchemy.hguy.co/lms");


	     // get the heading of the webpage
	        String heading = driver.findElement(By.xpath("//h1[contains(text(), 'Industry Experts')]")).getText();
	        System.out.println(heading);
	     
	     // Verify the page title
	        String expectedHeading = "Learn from Industry Experts";

	        if(heading.equals(expectedHeading)) {
	        	System.out.println("heading matched and closing the browser");
	        	driver.quit();
	        }
	        
	    }
		

}
