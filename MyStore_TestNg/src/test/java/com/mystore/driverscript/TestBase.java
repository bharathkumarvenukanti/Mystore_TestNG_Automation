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

public class TestBase {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Properties config=new Properties();
	public static String PropPath="/src/test/java/com/mystore/driverscript/configuration.properties";
	public static FileInputStream fis;

	@BeforeSuite
	public void setUp() throws IOException {
		try {
			fis=new FileInputStream(System.getProperty("user.dir")+PropPath);
			config.load(fis);
			System.out.println("Configuration File Loaded Successfully");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(config.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",".//Drivers//chromedriver.exe");
			ChromeOptions co=new ChromeOptions();
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("implicitWait"))));
		driver.manage().window().maximize();
	}

@AfterSuite
public void tearDown() {
	if(driver!=null) {
		driver.close();
		System.out.println("Driver is closed");
	}
}
}