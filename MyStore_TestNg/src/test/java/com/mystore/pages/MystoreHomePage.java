package com.mystore.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.objectrepository.MyStoreObjectsRepository;
import com.mystore.utilities.TestUtil;

public class MystoreHomePage {
	private WebDriver driver;
	private TestUtil utils;
	public MystoreHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		utils=new TestUtil();
	}

	//	@FindBy(id =MyStoreObjectsRepository.SearchBoxID) 
	//	@CacheLookup
	//	private WebElement searchBox; 
	//	@FindBy(name =MyStoreObjectsRepository.SearchButtonName) 
	//	@CacheLookup
	//	private WebElement  searchButton; 
	//	@FindBy(css = "#product-name") 
	//	@CacheLookup
	//	private List<WebElement> productTitles; 
	@FindBy(xpath =MyStoreObjectsRepository.SigninButton )
	@CacheLookup
	private WebElement signInButton;
	@FindBy(xpath =MyStoreObjectsRepository.accountinfo )
	@CacheLookup
	private WebElement AccountInformation;
	@FindBy(xpath =MyStoreObjectsRepository.Errormsg)
	@CacheLookup
	private WebElement errorMessage;
	//	public void   
	//	searchForProduct(String product) { 
	//		searchBox.sendKeys(product); searchButton.click(); 
	//	} 
	//} 
	// SearchResultsPage
	//public class SearchResultsPage {
	//public boolean isProductPresent(String productName) { 
	//	for (WebElement title : productTitles) 
	//	{ 
	//		if (title.getText().contains(productName)) 
	//		{ return true; 
	//		} 
	//	} 
	//	return false; 
	//} 
	//}
	public void clickSignInButton() {
        signInButton.click();

    }
	 public boolean isAccountInfoDisplayed() {
	        return AccountInformation.isDisplayed();
	    }
	 public String getErrorMessageText() {
	        return errorMessage.getText();
	    }
	 

}
