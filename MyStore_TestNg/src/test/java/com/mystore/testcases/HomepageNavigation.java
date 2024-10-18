package com.mystore.testcases;

import org.testng.annotations.Test;

import com.mystore.driverscript.TestBase;
/**
 * This class represents the HomepageNavigation test case for the "mystore" module.
 * It extends the TestBase class, which provides common test setup and teardown functionality.
 */
public class HomepageNavigation extends TestBase  {
	/**
     * This test method launches the homepage of the "mystore" application.
     *
     * It checks the "module" property in the configuration file. If it's equal to "mystore",
     * it navigates to the URL specified in the "mystoreurl" property. Otherwise,
     * it prints an error message indicating an issue with the URL.
     */
  @Test
  public void LaunchHomepage(){
		if(config.getProperty("module").equalsIgnoreCase("mystore")) {
			  driver.get(config.getProperty("mystoreurl"));
			  System.out.println("Launched targetted website");
			  }else {
				  System.out.println("Issue with the url: "+config.getProperty("mystoreurl"));
	  }
	 
	}

}
