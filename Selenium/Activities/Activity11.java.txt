import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity11 {
    public static void main(String[] args) {
        // Driver object reference
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the browser
        driver.get("https://www.training-support.net/webelements/dynamic-controls");

        // Verify page title
        System.out.println("Page title is: " + driver.getTitle());

        // Find the checkbox and make sure it is visible
        WebElement checkbox = driver.findElement(By.id("checkbox"));
        System.out.println("Checkbox is visible? " + checkbox.isDisplayed());

        // Find the button to toggle it and click it
        driver.findElement(By.xpath("//button[text()='Toggle Checkbox']")).click();
        // Wait for it to disappear
        wait.until(ExpectedConditions.invisibilityOf(checkbox));
        // Check if it is visible
        System.out.println("Checkbox is visible? " + checkbox.isDisplayed());
        
        // Toggle the checkbox and click it
        driver.findElement(By.xpath("//button[text()='Toggle Checkbox']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(checkbox)).click();
        // Check if it is selected
        System.out.println("Checkbox is selected? " + checkbox.isSelected());

        // Close the browser
        driver.quit();
    }
}

Activity 11
Python Solution:

# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait

# Start the Driver
with webdriver.Firefox() as driver:
    # Declare the wait variable
    wait = WebDriverWait(driver, timeout=10)
    # Navigate to the URL
    driver.get("https://training-support.net/webelements/dynamic-controls")
    # Print the title of the page
    print("Page title is: ", driver.title)

    # Find the checkbox and make sure it is visible
    checkbox = driver.find_element(By.ID, "checkbox")
    print("Checkbox is visible? ", checkbox.is_displayed())

    # Find the button to toggle it and click it
    driver.find_element(By.XPATH, "//button[text()='Toggle Checkbox']").click()
    # Wait for it to disappear
    wait.until(EC.invisibility_of_element(checkbox))
    # Check if it is visible
    print("Checkbox is visible? ", checkbox.is_displayed())

    # Toggle the checkbox and click it
    driver.find_element(By.XPATH, "//button[text()='Toggle Checkbox']").click()
    wait.until(EC.element_to_be_clickable(checkbox)).click()
    # Check if it is selected
    print("Checkbox is selected? ", checkbox.is_selected())

Using Selenium:

Open a new browser to https://training-support.net/webelements/dynamic-content
Get the title of the page and print it to the console.
On the page, perform:
Find and click the "Click me!" button.
Wait till the word "release" appears.
Get the text and print it to console.
Close the browser.
Activity 12
Waits #2
Activity 12
Java Solution:

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity12 {
    public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        // Create the Wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the page
        driver.get("https://www.training-support.net/webelements/dynamic-content");
        // Print the title of the page
        System.out.println("Page title: " + driver.getTitle());

        // Find the button and click it
        driver.findElement(By.id("genButton")).click();
        // Wait for the word to appear
        if (wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("word"), "release"))) {
            // Print the text to console
            System.out.println("Word found: " + driver.findElement(By.id("word")).getText());
        }
        // Close the browser
        driver.quit();
    }
}

Handling Multiple Elements
34 . 2



