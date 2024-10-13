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
  public HomepageNavigation homePage;
  public MyStoreTitlesRepository Titlesrepo;
  public TestUtil utils;
  public MyStoreHomePageLogo Logo;
  
  //Declaring titles
  public String MystoreExpectedTitle=Titlesrepo.MystoreHomePageTitle;

	@BeforeMethod
  public void VerifyMystoreHomepage() {
		utils=new TestUtil();
		homePage=new HomepageNavigation();
		Logo=PageFactory.initElements(driver, MyStoreHomePageLogo.class);
		homePage.LaunchHomepage();
		String ActualHomepageTitle=driver.getTitle();
		utils.AssrtEquals(ActualHomepageTitle, MystoreExpectedTitle, "Title are not matched");
  }
	@Test
	public void verifyMystoreHomePageLogo() {
		//Logo.isLogoDisplayed();
		boolean islogo=Logo.isLogoDisplayed();
		try {
			utils.AssrtTrue(islogo, "Title is not displayed");
			Logo.clickLogo();
			utils.AssrtEquals(driver.getTitle(), MystoreExpectedTitle, "Title are not matched");
			Logo.LogoRedirectsToHomepage(MystoreExpectedTitle);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@AfterMethod
	public void Assertall() {
		
		utils.assertAllSoftAssertions();
	}
	
}
