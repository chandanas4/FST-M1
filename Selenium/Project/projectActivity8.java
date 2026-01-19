package seleniumproject;




import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class projectActivity8 {
	
	public static void main(String[] args) {
		

	// Initialize the Firefox Driver
    WebDriver driver = new FirefoxDriver();
    
     //open the page
    driver.get("https://alchemy.hguy.co/lms");
    
 //navigate to Contact in Navigation bar and click
   driver.findElement(By.linkText("Contact")).click();
  
   
 //wait until the page is loaded
   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   wait.until(ExpectedConditions.titleContains("Contact"));
   
   //enter the details in contact form and submit
   driver.findElement(By.xpath("//input[@name='wpforms[fields][0]']")).sendKeys("chandana");
   driver.findElement(By.xpath("//input[@name='wpforms[fields][1]']")).sendKeys("chandanas@gmail.com");
   driver.findElement(By.xpath("//input[@name='wpforms[fields][3]']")).sendKeys("query");
   driver.findElement(By.xpath("//textarea[@name='wpforms[fields][2]']")).sendKeys("test message query");
   driver.findElement(By.xpath("//button[@name='wpforms[submit]']")).click();
   
   //print the confirmation message
   String message = driver.findElement(By.xpath("//div[@id='wpforms-confirmation-8']/p")).getText();
   System.out.println(message);
   
   
   driver.quit();
   
   
  
    
	
}

}
