package com.mystore.driverscript;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
/**
 * This class serves as the base class for all test classes in the project.
 * It handles browser setup, configuration loading, and teardown.
 */
public class TestBase {
	// Declares a static WebDriver instance to be used throughout the tests.
	public static WebDriver driver;
	// Declares a static WebDriverWait instance for explicit Properties object to store configuration properties. 
	public static WebDriverWait wait;
	public static Properties config=new Properties();
	public static String PropPath="/src/test/java/com/mystore/driverscript/configuration.properties";
	//Declares a FileInputStream instance for reading the configuration file.
	public static FileInputStream fis;

	/**
	 * This method performs setup tasks before running any test suite.
	 *
	 * It reads configuration properties, launches the browser based on the 
	 * specified browser in the configuration file, sets implicit wait, and 
	 * maximizes the browser window.
	 *
	 * @throws IOException if there's an issue reading the configuration file.
	 */

	@BeforeSuite
	public void setUp() throws IOException {
		// Construct the full path to the configuration file based on user directory
		try {
			fis=new FileInputStream(System.getProperty("user.dir")+PropPath);
			config.load(fis);
			System.out.println("Configuration File Loaded Successfully");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		// Launch browser chrome, firefox, and edge based on configuration
		if(config.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",".//Drivers//chromedriver.exe");
			ChromeOptions co=new ChromeOptions();
			// Add options for Chrome driver if needed (e.g., headless mode)
			//co.setBinary(".//Drivers//chrome-headless-shell.exe");
			driver=new ChromeDriver(co);
			System.out.println("Launch Chrome browser");
		}else if(config.getProperty("browser").equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver",".//Drivers//msedgedriver.exe");
			// Create Edge Options to customize Edge Driver behavior
			EdgeOptions options = new EdgeOptions();
			driver = new EdgeDriver(options);
			System.out.println("Launched edge browser");
		}
		else if(config.getProperty("browser").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",".//Drivers//geckodriver.exe");
			// Create FireFoxOptions to customize FireFoxDriver behavior
			FirefoxOptions options = new FirefoxOptions();
			driver = new FirefoxDriver(options);
			System.out.println("Launched Firefox browser");
		}
		// Set implicit wait from configuration
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("implicitWait"))));
		// Maximize the browser window
		driver.manage().window().maximize();
	}

	/**
     * This method performs teardown tasks after all test suites have run.
     *
     * It closes the browser if it's still open.
     */
	@AfterSuite
	public void tearDown() {
		if(driver!=null) {
			driver.close();
			System.out.println("Driver is closed");
		}
	}
}