package ss;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class Screenshot {
	
	private WebDriver driver;

    // Constructor to initialize the WebDriver
    public Screenshot(WebDriver driver) {
        this.driver = driver;
    }

    public void captureScreenShot(String screenshot) throws IOException {
        String path = "C:/Users/Asus/Documents/workspace-spring-tool-suite-4-4.24.0.RELEASE/POMProject/Screenshot";

        try {
            TakesScreenshot takeScreenShot = (TakesScreenshot) driver; 
            File file = takeScreenShot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File(path + screenshot + ".png"));
        } catch (WebDriverException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	
	
	
	
	
	
	}

