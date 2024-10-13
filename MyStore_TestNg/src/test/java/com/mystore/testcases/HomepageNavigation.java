package com.mystore.testcases;

import org.testng.annotations.Test;

import com.mystore.driverscript.TestBase;

public class HomepageNavigation extends TestBase  {
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
