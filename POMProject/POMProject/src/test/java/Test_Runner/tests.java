package Test_Runner;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Browsers.all_browsers;
import Different_modules.choosing_destination;
import Different_modules.four_elements;
import Different_modules.seats;
import ss.Screenshot;

public class tests {

    WebDriver driver; // Creating a WebDriver object to control the browser
    choosing_destination new_choosing_Destination; // Object to interact with destination selection part of the app
    four_elements new_four_elements; // Object to interact with four elements of the app (like rest stops, amenities, etc.)
    seats newSeats; // Object to interact with seat-related actions (booking, boarding, etc.)
    Screenshot new_ss; // Object for capturing screenshots during the test
    
    @BeforeTest
    public void setup() {
        // So, first thing, we're initializing the browser (Chrome in this case) using our all_browsers class
        driver = all_browsers.getDriver("CHROME");

        // Now we launch the app. Just tell the browser to open this URL.
        driver.get("https://www.smbus.co/");

        // Here, we’re setting up our page objects (POM classes). These are like the pages of our app
        // and will help interact with the elements on the page.
        new_choosing_Destination = new choosing_destination(driver);
        new_four_elements = new four_elements(driver);
        newSeats = new seats(driver);
        new_ss = new Screenshot(driver);
    }

    @Test
    public void Automation_Tests() throws InterruptedException, IOException {
        // Close the annoying popup ad that keeps popping up on the page
        new_choosing_Destination.closeAd();
        
        // Select the source city. "Bang" is just part of the name we're typing in, we expect it to auto-complete.
        new_choosing_Destination.selectFromCity("Bang");
        
        // Select the destination city. Similarly, "Dand" is just a part of the destination name.
        new_choosing_Destination.selectToCity("Dand");

        // Let the page load for a moment before moving forward. Not a fan of race conditions.
        Thread.sleep(4000);
        
        // Click on the submit button after selecting cities.
        new_choosing_Destination.click_on_submit();

        // Now we’re checking out the different sections of the page, like Rest Stops, Amenities, etc.
        // Each one will be captured in a screenshot as we go along.
        new_four_elements.Rests_Stops();
        new_ss.captureScreenShot("rests_stops");

        // Checking out the amenities section next and capturing the screenshot.
        new_four_elements.Amenities();
        new_ss.captureScreenShot("Amenities");

        // Moving on to cancellation terms and capturing it as a screenshot.
        new_four_elements.Cancellation_Terms();
        new_ss.captureScreenShot("Cancellation");

        // Finally, we look at boarding and dropping information.
        new_four_elements.Boarding_and_Dropping();
        new_ss.captureScreenShot("Boarding and Dropping");

        // Now, we deal with the seat selection part of the page.
        newSeats.AllAvailableSeats();
        
        // Set the boarding location to "Hope Farm Junction"
        newSeats.boarding_location("Hope Farm Junction");
        
        // Set the dropping location to "Dharwad"
        newSeats.dropping_location("Dharwad");
        
        // Once all is set, we click on "Continue" to proceed further.
        newSeats.click_on_continue();
    }
}
