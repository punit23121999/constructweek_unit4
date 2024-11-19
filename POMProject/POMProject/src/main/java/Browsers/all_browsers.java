package Browsers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class all_browsers {
		private static WebDriver driver; 
		
		public static WebDriver getDriver(String driverName){

			if(driverName.equals(browsers_drivers.CHROME)){
				//System.setProperty(Driver.CHROME, Driver.CHROME_PATH);
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			else if(driverName.equals(browsers_drivers.FIREFOX)){
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				
			}
			else if(driverName.equals(browsers_drivers.EDGE)){
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver(); 
			}
			else if(driverName.equals(browsers_drivers.PHANTOM)){
				// TODO 
			}
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			return driver;
		}
}
