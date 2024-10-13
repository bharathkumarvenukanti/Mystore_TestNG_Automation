package com.mystore.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.asserts.SoftAssert;

import com.mystore.driverscript.TestBase;

public class TestUtil extends TestBase{
	private Actions actions=new Actions(driver);
	public static String screenshotPath;
	public static String screenshotName;
	public static ExcelReader excel = new ExcelReader(".\\TestData\\RegisterDemoTestData.xlsx");
	public SoftAssert softAssert = new SoftAssert();

	public static void captureScreenshot() throws IOException {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		FileUtils.copyFile(scrFile,
				new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName));
		FileUtils.copyFile(scrFile,
				new File(".\\Reports\\" + screenshotName));

	} 
	
	@DataProvider(name="registerDemo")
	public Object[][] getData(Method m) {

		String sheetName = m.getName();
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][1];

		Hashtable<String,String> table = null;

		for (int rowNum = 2; rowNum <= rows; rowNum++) { 
			table = new Hashtable<String,String>();			
			for (int colNum = 0; colNum < cols; colNum++) {
				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
				data[rowNum - 2][0] = table;
			}
		}
		return data;

	}
	public static boolean isTestRunnable(String testName, ExcelReader excel){

		String sheetName="test_suite";
		int rows = excel.getRowCount(sheetName);		

		for(int rNum=2; rNum<=rows; rNum++){			
			String testCase = excel.getCellData(sheetName, "TCID", rNum);			
			if(testCase.equalsIgnoreCase(testName)){				
				String runmode = excel.getCellData(sheetName, "Runmode", rNum);				
				if(runmode.equalsIgnoreCase("Y"))
					return true;
				else
					return false;
			}						
		}
		return false;
	} 

	    /**
	     * Move the mouse to the specified element.
	     *
	     * @param element WebElement to hover over
	     */
	    public void hoverOverElement(WebElement element) {
	        actions.moveToElement(element).perform();
	    }

	    /**
	     * Click on the specified element.
	     *
	     * @param element WebElement to click
	     */
	    public void clickElement(WebElement element) {
	    	actions.moveToElement(element).click().perform();
	    }

	    /**
	     * Double-click on the specified element.
	     *
	     * @param element WebElement to double-click
	     */
	    public void doubleClickElement(WebElement element) {
	        actions.doubleClick(element).perform();
	    }

	    /**
	     * Right-click (context-click) on the specified element.
	     *
	     * @param element WebElement to right-click
	     */
	    public void rightClickElement(WebElement element) {
	        actions.contextClick(element).perform();
	    }

	    /**
	     * Type text into the specified element.
	     *
	     * @param element WebElement to type into
	     * @param text    Text to type
	     */
	    public void typeText(WebElement element, String text) {
	        element.sendKeys(text);
	    }
	    public void performAllActions() {
	        actions.perform();
	    }
	    
	    //=============================
		public void AssrtEquals(String ActualValue, String ExpectedValue,String Comments) {
			softAssert.assertEquals(ActualValue,ExpectedValue,Comments );
		}
		public void AssrtNotEquals(String ActualValue, String ExpectedValue,String Comments) {
			softAssert.assertEquals(ActualValue,ExpectedValue,Comments );
		}
		public void AssrtTrue(boolean True,String Comments) {
			softAssert.assertTrue(True, Comments);
		}
		public void AssrtFalse(boolean False,String Comments) {
			softAssert.assertTrue(False,Comments);
		}
		public void assertAllSoftAssertions() {
			softAssert.assertAll();
		}

}


