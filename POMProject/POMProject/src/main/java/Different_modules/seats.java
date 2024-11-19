package Different_modules;  // Declaring the package where this class belongs to

import java.time.Duration;  // Importing Duration class to deal with timeouts and waiting
import java.util.List;  // Importing List interface to store a collection of elements

import org.openqa.selenium.By;  // Importing By class for locating elements on the web page
import org.openqa.selenium.WebDriver;  // Importing WebDriver interface to control the browser
import org.openqa.selenium.WebElement;  // Importing WebElement interface to interact with the elements on the page
import org.openqa.selenium.support.FindBy;  // Importing FindBy annotation to locate elements using various locators
import org.openqa.selenium.support.PageFactory;  // Importing PageFactory to initialize page elements easily
import org.openqa.selenium.support.ui.WebDriverWait;  // Importing WebDriverWait class to implement explicit waits
import org.openqa.selenium.support.ui.ExpectedConditions;  // Importing ExpectedConditions for wait conditions

public class seats {  // Class to handle seat selection page interactions

    private WebDriver driver;  // Declaring a WebDriver instance to control the browser

    public seats(WebDriver driver) {  // Constructor to initialize the WebDriver and page elements
        this.driver = driver;  // Storing the WebDriver in the class variable
        PageFactory.initElements(driver, this);  // Initializing all WebElements using PageFactory
    }

    // Locating the available seats using XPath
    @FindBy(xpath = "//div[@class='sleeper-lay-search seat-select-visibility']")
    private List<WebElement> availableSeats;  // Storing all available seats as a list of WebElements

    // Locating the dropdown options for boarding and dropping points using CSS selector
    @FindBy(css = ".selectize-dropdown-content .row")
    private List<WebElement> dropdown;  // Storing the dropdown options as a list of WebElements

    // Locating the boarding point input field using CSS selector
    @FindBy(css = ".selectize-input input")
    private WebElement select_boarding_point;  // Storing the WebElement for the boarding point input field

    // Locating the dropping point input field using XPath
    @FindBy(xpath = "//input[@id='boarding-point-list-selectized']")
    private WebElement select_dropping_point;  // Storing the WebElement for the dropping point input field

    // Locating the continue button using XPath
    @FindBy(xpath = "//button[@id='selected-seat-next']")
    private WebElement continue_button;  // Storing the WebElement for the continue button

    public void AllAvailableSeats() {  // Method to select any available seat
        if (availableSeats.size() > 0) {  // Check if there are any available seats
            for (WebElement seat : availableSeats) {  // Loop through each seat in the availableSeats list
                seat.click();  // Click the first seat available
                break;  // Exit the loop after selecting the first available seat
            }
        }
    }

    public void boarding_location(String boardingName) {  // Method to select the boarding point
        select_boarding_point.click();  // Click the boarding point input field to open the dropdown

        // Loop through each option in the dropdown list to find a match
        for (WebElement option : dropdown) {  // Iterate through the dropdown list
            String name = option.findElement(By.cssSelector(".sp-name")).getText();  // Get the text of each option
            if (name.equals(boardingName)) {  // Check if the option's text matches the provided boarding name
                option.click();  // If match found, click the option
                break;  // Exit the loop once the correct option is selected
            }
        }
    }

    public void dropping_location(String destinationName) {  // Method to select the dropping point
        select_dropping_point.click();  // Click the dropping point input field to open the dropdown

        // Loop through each option in the dropdown list to find a match
        for (WebElement option : dropdown) {  // Iterate through the dropdown list
            String name = option.findElement(By.cssSelector(".sp-name")).getText();  // Get the text of each option
            if (name.equals(destinationName)) {  // Check if the option's text matches the provided destination name
                option.click();  // If match found, click the option
                break;  // Exit the loop once the correct option is selected
            }
        }
    }

    public void click_on_continue() {  // Method to click on the 'Continue' button
        continue_button.click();  // Click the continue button to proceed to the next step
    }
}
