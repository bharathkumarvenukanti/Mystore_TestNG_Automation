package com.mystore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.objectrepository.MyStoreObjectsRepository;
import com.mystore.utilities.TestUtil;

public class MyStoreLogo {
	private WebDriver driver;
	private TestUtil utils;
	
	public MyStoreLogo(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		utils=new TestUtil();
	}
	
	// Initialize the web elements locators values using FINDBY class	
	@FindBy(xpath=MyStoreObjectsRepository.LogoXpath) 
	@CacheLookup
	WebElement logoImage;

	public boolean isLogoDisplayed() {
		return logoImage.isDisplayed();
	}
	
	public void clickLogo() throws InterruptedException {
		//logoImage.click();
		utils.clickElement(logoImage);
	}
	
	public String LogoRedirectsToHomepage(String actualTitle) {
		return actualTitle=driver.getTitle();
	}

}
