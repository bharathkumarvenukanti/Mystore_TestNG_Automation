package com.mystore.testcases;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.driverscript.TestBase;
import com.mystore.objectrepository.MyStoreTitlesRepository;
import com.mystore.pages.MyStoreAccountsPage;
import com.mystore.pages.MyStoreLoginPage;
import com.mystore.pages.MyStoreLogo;
import com.mystore.pages.MyStoreRegistrationPage;
import com.mystore.pages.MystoreHomePage;
import com.mystore.utilities.RetryAnalyzer;
import com.mystore.utilities.TestUtil;

public class MystoreUserRegistration extends TestBase{
	public HomepageNavigation Navigation;
	public MyStoreTitlesRepository Titlesrepo;
	public TestUtil utils;
	//public MyStoreLogo Logo;
	public MystoreHomePage homePage;
	public MyStoreRegistrationPage regPage;
	public MyStoreAccountsPage accounts;
	public MyStoreLoginPage LoginPage;

	//Declaring titles
	public String MystoreExpectedTitle=Titlesrepo.MystoreHomePageTitle;
	public String MystoreRegpageExpectedTitle=Titlesrepo.MystoreHomePageTitle;
	//Declaring Messages/Coments
	String LoginInfo="Account information is not displayed after successful login.";
	String ErrorInfo="Error message after invalid login does not match expectation.";
	@BeforeMethod
	public void VerifyMystoreHomepage() {
		Navigation=new HomepageNavigation();
		homePage=PageFactory.initElements(driver, MystoreHomePage.class);
		regPage=PageFactory.initElements(driver, MyStoreRegistrationPage.class);
		accounts=PageFactory.initElements(driver, MyStoreAccountsPage.class);
		// Initialize utility and page objects
		utils=new TestUtil();
	}

	@Test(dataProviderClass = com.mystore.utilities.TestUtil.class, dataProvider ="register",retryAnalyzer = RetryAnalyzer.class)
	public void registerUser(Hashtable<String,String> data) throws InterruptedException{
		// Verify homepage title using TestUtil
		Navigation.LaunchHomepage();
		String ActualHomepageTitle=driver.getTitle();
		utils.AssrtEquals(ActualHomepageTitle, MystoreExpectedTitle, "Title are not matched");
		homePage.clickSignInButton();
		if (homePage.isAccountInfoDisplayed()) {
			// Soft assert for successful login 
			utils.AssrtTrue(true, LoginInfo);
		} else {
			// Soft assert for failed login
			utils.AssrtTrue(true, ErrorInfo);
		}
		//regPage=PageFactory.initElements(driver, MyStoreRegistrationPage.class);
		regPage.validatePageTitle(MystoreRegpageExpectedTitle);
		LoginPage.EnterEmail(data.get("Email"));
		LoginPage.ClickOnCreateanaccountButton();
		regPage.selectGenderRadioBtn(data.get("Title"));
		regPage.enterFirstName(data.get("FirstName"));
		regPage.enterLastName(data.get("LastName"));
		regPage.enterPassword(data.get("Password"));
		//		regPage.selectDayDropDown(data.get("Day"));
		//		regPage.selectMonthDropDown(data.get("Month"));
		//		regPage.selectYearDropDown(data.get("Year"));
		regPage.selectNewsLettersChkBox(data.get("Newsletter"));
		regPage.clickRegisterButton();
		regPage.getSuccessMessage();
		accounts.ClickOnSignOut();


	}
	@AfterMethod
	public void Assertall() {
		// Assert all soft assertions from TestUtil

		utils.assertAllSoftAssertions();
	}


}
