package com.mystore.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.driverscript.TestBase;
import com.mystore.objectrepository.MyStoreTitlesRepository;
import com.mystore.pages.MyStoreHomePageLogo;
import com.mystore.utilities.TestUtil;

public class MystoreHomepageTest extends TestBase {
	// Declare page and utility instances
	public HomepageNavigation homePage;
	public MyStoreTitlesRepository Titlesrepo;
	public TestUtil utils;
	public MyStoreHomePageLogo Logo;

	//Declaring titles
	public String MystoreExpectedTitle=Titlesrepo.MystoreHomePageTitle;

	@BeforeMethod
	public void VerifyMystoreHomepage() {
		// Initialize utility and page objects
		utils=new TestUtil();
		homePage=new HomepageNavigation();
		Logo=PageFactory.initElements(driver, MyStoreHomePageLogo.class);
		// Launch homepage
		homePage.LaunchHomepage();
		// Get actual homepage title
		String ActualHomepageTitle=driver.getTitle();
		// Verify homepage title using TestUtil
		utils.AssrtEquals(ActualHomepageTitle, MystoreExpectedTitle, "Title are not matched");
	}
	@Test
	public void verifyMystoreHomePageLogo() {
		// Check if logo is displayed
		//Logo.isLogoDisplayed();
		boolean islogo=Logo.isLogoDisplayed();
		try {
			// Verify logo is displayed using TestUtil
			utils.AssrtTrue(islogo, "Title is not displayed");
			// Click on logo
			Logo.clickLogo();
			// Verify title after clicking logo
			utils.AssrtEquals(driver.getTitle(), MystoreExpectedTitle, "Title are not matched");
			// Verify logo redirects to homepage with expected title
			Logo.LogoRedirectsToHomepage(MystoreExpectedTitle);
		} catch (InterruptedException e) {
			// Handle potential interruption exception
			e.printStackTrace();
		}
	}
	@AfterMethod
	public void Assertall() {
		// Assert all soft assertions from TestUtil

		utils.assertAllSoftAssertions();
	}

}
