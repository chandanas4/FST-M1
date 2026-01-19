package seleniumproject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class projectActivity9 {
	
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
	      
	
	          
	       //find the login button and click
	        driver.findElement(By.linkText("Login")).click();
	        
	        // Find the username field and enter the username
	        driver.findElement(By.name("log")).sendKeys("root");
	        // Find the password field and enter the password
	        driver.findElement(By.name("pwd")).sendKeys("pa$$w0rd");
	        // Find the login button and click it
	        driver.findElement(By.xpath("//input[@name='wp-submit']")
	        	).click();
	        
	        if (driver.findElement(By.linkText("Edit profile")).isDisplayed()) {
	        	System.out.println("Logged in successfully");   
	        }
	        
	     //navigate to All Courses in Navigation bar and click
	        driver.findElement(By.linkText("All Courses")).click();
	        
	      //wait until the page is loaded
	        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait2.until(ExpectedConditions.titleContains("All Courses"));
	        
	      //click on course
	        driver.findElement(By.xpath("//p[@class='ld_course_grid_button']/a")).click();
	        
	      //click on course content
	        driver.findElement(By.xpath("//div[@id='ld-expand-83']")).click();
	        
	      //clicked on lesson
	        String lessonheading = driver.findElement(By.xpath("//div[@class='ld-focus-content']/h1")).getText();
	        System.out.println(lessonheading);
	        
	        
	        driver.quit();
	        
	        

}

}
