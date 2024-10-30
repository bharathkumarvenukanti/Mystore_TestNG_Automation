package com.mystore.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.driverscript.TestBase;
import com.mystore.objectrepository.MyStoreTitlesRepository;
import com.mystore.pages.MyStoreLogo;
import com.mystore.pages.MyStoreRegistrationPage;
import com.mystore.pages.MystoreHomePage;
import com.mystore.utilities.TestUtil;

public class MystoreHomepageTest extends TestBase {
	// Declare page and utility instances
	public HomepageNavigation homePage;
	public MyStoreTitlesRepository Titlesrepo;
	public TestUtil utils;
	public MyStoreLogo Logo;
	public MystoreHomePage homePageReg;
	public MyStoreRegistrationPage regPage;

	//Declaring titles
	public String MystoreExpectedTitle=Titlesrepo.MystoreHomePageTitle;
	//Declaring Messages/Coments
	String LoginInfo="Account information is not displayed after successful login.";
	String ErrorInfo="Error message after invalid login does not match expectation.";

	@BeforeMethod
	public void VerifyMystoreHomepage() {
		// Initialize utility and page objects
		utils=new TestUtil();
		homePage=new HomepageNavigation();
		Logo=PageFactory.initElements(driver, MyStoreLogo.class);
		// Launch homepage
		homePage.LaunchHomepage();
		// Get actual homepage title
		String ActualHomepageTitle=driver.getTitle();
		// Verify homepage title using TestUtil
		utils.AssrtEquals(ActualHomepageTitle, MystoreExpectedTitle, "Title are not matched");
		homePageReg=PageFactory.initElements(driver, MystoreHomePage.class);
		regPage=PageFactory.initElements(driver, MyStoreRegistrationPage.class);
		
	}
	@Test(priority = 1)
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
	@Test(priority = 2)
	public void testSignIn() throws InterruptedException {
		// Click sign-in button using MystoreHomePage methods (clarify purpose of homePageReg)
		homePageReg.clickSignInButton();
		// Check if account info is displayed 
		if (homePageReg.isAccountInfoDisplayed()) {
			// Soft assert for successful login 
            utils.AssrtTrue(true, LoginInfo);
        } else {
        	// Soft assert for failed login
        	 utils.AssrtTrue(true, ErrorInfo);
        }
		Thread.sleep(10000);
		regPage.validatePageTitle(Titlesrepo.MystoreHomePageTitle);
		regPage.EnterEmail("Bharathkkk@gmail.com");
		regPage.ClickOnCreateanaccountButton();
		regPage.selectGenderRadioBtn("mr");
		
	}
//	@Test(priority = 3, alwaysRun = true)
//	public void ValidateRegForm() {
//		
//	}
	@AfterMethod
	public void Assertall() {
		// Assert all soft assertions from TestUtil

		utils.assertAllSoftAssertions();
	}

}
