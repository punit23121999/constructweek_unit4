package Different_modules;

import java.time.Duration; // Importing Duration class to handle time intervals
import java.util.List; // Importing List to work with lists of elements
import org.openqa.selenium.By; // Importing By to locate elements
import org.openqa.selenium.WebDriver; // Importing WebDriver to control the browser
import org.openqa.selenium.WebElement; // Importing WebElement to interact with page elements
import org.openqa.selenium.support.FindBy; // Importing FindBy annotation to find elements
import org.openqa.selenium.support.PageFactory; // Importing PageFactory to initialize the page elements

public class choosing_destination {
	
	private WebDriver driver; // WebDriver instance to interact with the browser

	// Constructor to initialize the WebDriver and page elements
	public choosing_destination(WebDriver driver) {
		
        this.driver = driver; // Assign the WebDriver to the instance variable
        PageFactory.initElements(driver, this); // Initialize the page elements using PageFactory
        
    }
	
    @FindBy(xpath = "//button[@title='Close']") // Locating the close button for the ad popup
    private WebElement closePopupAd; // WebElement for the ad close button

    @FindBy(xpath = "//input[@id='search-from-station-selectized']") // Locating the source city input field
    private WebElement source_point; // WebElement for source city input field

    @FindBy(xpath = "//div[@class='selectize-dropdown-content']//div[contains(@class, 'option') and @data-value='STF3OEX206']") // Locating source city options in the dropdown
    private List<WebElement> source_city_Options; // List of WebElements for source city options
    
    @FindBy(xpath = "//input[@id='search-to-station-selectized']") // Locating the destination city input field
    private WebElement destination_point; // WebElement for destination city input field

    @FindBy(xpath = "//div[@class=\"option\"]") // Locating destination city options in the dropdown
    private List<WebElement> destination_city_Options; // List of WebElements for destination city options
    
    @FindBy(xpath = "//button[@id='search-btn']") // Locating the submit button
    private WebElement submit_click; // WebElement for the submit button

    @FindBy(xpath = "//input[@id='search-onward-date']") // Locating the date input field
    private WebElement dateInputBox; // WebElement for the date input field

    @FindBy(xpath = "//div[@class='datepicker-days']//i[@class='fas fa-chevron-right']") // Locating the next month button in the calendar
    private WebElement nextMonth; // WebElement for the next month button

    @FindBy(xpath = "//th[normalize-space()='November 2024']") // Locating the calendar header for the month
    private WebElement calendarHeader; // WebElement for the calendar header

    //Methods------------------------------------------------------
    
    // Method to close the ad popup
    public void closeAd() {
        closePopupAd.click(); // Click the ad close button
    }

    
    // Method to select the source city from the dropdown
    public void selectFromCity(String sourceName) throws InterruptedException {
    	this.source_point.click(); // Click the source city input field
        this.source_point.clear(); // Clear any pre-filled text in the source input field
        this.source_point.sendKeys(sourceName); // Type in the source city name

        // Loop through source city options and select the matching city
        for (WebElement option : source_city_Options) {
            if (option.getText().equalsIgnoreCase("Bangalore")) { // Check if the option matches "Bangalore"
                option.click(); // Click the matching city option
                break; // Exit the loop once we click the correct option
            }
        }
    }
    

    // Method to select the destination city from the dropdown
    public void selectToCity(String destinationName) throws InterruptedException {
    	this.destination_point.click(); // Click the destination city input field
        this.destination_point.clear(); // Clear any pre-filled text in the destination input field
        this.destination_point.sendKeys(destinationName); // Type in the destination city name
        Thread.sleep(2000); // Wait for a couple of seconds to let options load

        // Loop through destination city options and select the matching city
        for (WebElement option2 : destination_city_Options) {
            if (option2.getText().equalsIgnoreCase("Dandeli")) { // Check if the option matches "Dandeli"
            	Thread.sleep(4000); // Wait for a few seconds before clicking
                option2.click(); // Click the matching city option
                break; // Exit the loop once we click the correct option
            }
        }
    }

    
    // Method to select a specific date from the date picker
    public void selectDate(String date, String monthYear) throws InterruptedException {
        dateInputBox.click(); // Click the date input field to open the date picker

        // Loop to go to the correct month and year in the calendar
        while (!calendarHeader.getText().equals(monthYear)) {
            nextMonth.click(); // Click the next month button
            Thread.sleep(1000); // Wait for the calendar to update
        }

        
        // Locate and click the specific day in the calendar
        WebElement day = driver.findElement(By.xpath("//td[text()='" + date + "']"));
        day.click(); // Click the day
    }
    
    
    // Method to click on the submit button
    public void click_on_submit() {
    	this.submit_click.click(); // Click the submit button
    }
    
}
