package Different_modules; // Package declaration - this is part of the package where this class is located

import java.util.List; // Importing List to hold multiple elements (in case there are multiple options for dropdowns)

import org.openqa.selenium.WebDriver; // Import WebDriver, which is used to control the browser
import org.openqa.selenium.WebElement; // Import WebElement, which represents an element on a web page
import org.openqa.selenium.support.FindBy; // Import FindBy annotation to locate elements
import org.openqa.selenium.support.PageFactory; // Import PageFactory to initialize page elements

public class four_elements { // Class definition for handling elements related to 4 options on a page
    
    private WebDriver driver; // WebDriver instance to interact with the browser

    public four_elements(WebDriver driver) { // Constructor method that initializes the WebDriver
        this.driver = driver; // Assign the WebDriver to the class-level variable
        PageFactory.initElements(driver, this); // Initialize all the elements defined by @FindBy annotations
    }
    
    // Find the "Rest Stops" button on the page
    @FindBy(xpath = "//div[@id='trip-43N683S241117D']//div[@type='button'][normalize-space()='Rest Stops']") 
    private WebElement rest_stops; // This variable will hold the "Rest Stops" button element

    // Find the "Amenities" button on the page
    @FindBy(xpath = "//div[@id='trip-43N683S241117D']//div[@type='button'][normalize-space()='Amenities']")
    private WebElement amenities; // This variable will hold the "Amenities" button element
    
    // Find the "Cancellation Terms" button on the page
    @FindBy(xpath = "//div[@id='trip-43N683S241117D']//div[@type='button'][normalize-space()='Cancellation Terms']")
    private WebElement cancellation_terms; // This variable will hold the "Cancellation Terms" button element
    
    // Find the "Boarding & Dropping" button on the page
    @FindBy(xpath = "//div[@id='trip-43N683S241117D']//div[@type='button'][normalize-space()='Boarding & Dropping']")
    private WebElement boarding_and_dropping; // This variable will hold the "Boarding & Dropping" button element
    
    
    // Method to click on the "Rest Stops" button
    public void Rests_Stops() { 
        this.rest_stops.click(); // Click on the "Rest Stops" button
    }
    
    // Method to click on the "Amenities" button
    public void Amenities() { 
        this.amenities.click(); // Click on the "Amenities" button
    }

    // Method to click on the "Cancellation Terms" button
    public void Cancellation_Terms() { 
        this.cancellation_terms.click(); // Click on the "Cancellation Terms" button
    }

    // Method to click on the "Boarding & Dropping" button
    public void Boarding_and_Dropping() { 
        this.boarding_and_dropping.click(); // Click on the "Boarding & Dropping" button
    }
    
}
