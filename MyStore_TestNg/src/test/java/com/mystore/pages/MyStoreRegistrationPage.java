package com.mystore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mystore.objectrepository.MyStoreObjectsRepository;
import com.mystore.utilities.TestUtil;

public class MyStoreRegistrationPage {
	private WebDriver driver;
	private TestUtil utils;
	private Select DrpDn;
	//private WebElement element;
	public MyStoreRegistrationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		utils=new TestUtil();
	}
	@FindBy(xpath= MyStoreObjectsRepository.EmailXpath)
	@CacheLookup
	private WebElement Email;
	@FindBy(id = MyStoreObjectsRepository.CreateAnAcoountButtonID)
	@CacheLookup
	private WebElement CreateAnAcoount;
	@FindBy(id = MyStoreObjectsRepository.CreateAnAccountErrorMsgID)
	@CacheLookup
	private WebElement CreateAnAccountErrorMsg;
	@FindBy(xpath = MyStoreObjectsRepository.MrXpath)
	@CacheLookup
	private WebElement MrRadioButton;
	@FindBy(xpath = MyStoreObjectsRepository.MrsXpath)
	@CacheLookup
	private WebElement MrsRadioButton;
	@FindBy(xpath = MyStoreObjectsRepository.FirstNameTexboxXpath)
	@CacheLookup
	private WebElement FirstName;
	@FindBy(xpath = MyStoreObjectsRepository.LastNameTexboxXpath)
	@CacheLookup
	private WebElement LastName;
	@FindBy(id = MyStoreObjectsRepository.PasswordID)
	@CacheLookup
	private WebElement Password;
	@FindBy(xpath = MyStoreObjectsRepository.YearDDXpath)
	@CacheLookup
	private WebElement Yearofbirth;
	@FindBy(xpath = MyStoreObjectsRepository.DayDDXpath)
	@CacheLookup
	private WebElement DayofBirth;
	@FindBy(xpath = MyStoreObjectsRepository.MonthsDDXpath)
	@CacheLookup
	private WebElement Monthofbirth;
	@FindBy(xpath = MyStoreObjectsRepository.NewsLettersCheckBoxXpath)
	@CacheLookup
	private WebElement NewsLettersCheckbox;
	@FindBy(xpath = MyStoreObjectsRepository.RegisterButtonXpath)
	@CacheLookup
	private WebElement RegisterButton;
	@FindBy(xpath = MyStoreObjectsRepository.UserLogOut)
	@CacheLookup
	private WebElement UserSignOut;
	@FindBy(xpath = MyStoreObjectsRepository.RegSuccessMessageXpath)
	@CacheLookup
	private WebElement RegSuccessMessage;
	@FindBy(xpath = MyStoreObjectsRepository.RegErrorMessageXpath)
	@CacheLookup
	private WebElement RegErrorMessage;

	public void validatePageTitle(String PageTitle) {
		String actPageTitle = driver.getTitle();
		String expPageTitle = PageTitle;
		if(actPageTitle.equals(expPageTitle)) 
		{
			utils.AssrtEquals(actPageTitle, expPageTitle, "Titles are not matched");
			System.out.println("The Form Title is "+ actPageTitle);
		}
		else
		{
			utils.AssrtNotEquals(actPageTitle, expPageTitle,"Title are matched");
			System.out.println("The Actual Form Title is "+ actPageTitle);
			System.out.println("The Expected Form Title is "+ expPageTitle);
		}
	}
	public void EnterEmail(String EmailId) {
		Email.sendKeys(EmailId);
		System.out.println("Entered Emaiid is:"+EmailId);
	}
	public void ClickOnCreateanaccountButton() {
		CreateAnAcoount.click();
		utils.AssrtTrue(true, "Unable to click on targetted button");
	}
	public void selectGenderRadioBtn(String gender) {
		if (gender.equalsIgnoreCase("Mr.")) {
			MrRadioButton.click();
			System.out.println("Mr Radio Button is Selected");
		}
		else if (gender.equalsIgnoreCase("Mrs.")) {
			MrsRadioButton.click();
			System.out.println("Female Radio Button is Selected");
		}
		else {
			System.out.println("Other Radio Button is Selected");
		}
	}
	public void enterFirstName(String fname) {
		FirstName.sendKeys(fname);
		System.out.println("First Name is " + fname);
	}

	public void enterLastName(String lname) {
		LastName.sendKeys(lname);
		System.out.println("Last Name is " + lname);
	}
	public void enterPassword(String PasswordValue) {
		Password.sendKeys(PasswordValue);
		System.out.println("Password Name is " + PasswordValue);
	}
	public void selectDayDropDown(String aDay) {
		DrpDn = new Select(DayofBirth);
		DrpDn.selectByVisibleText(aDay);
		System.out.println(aDay + " is selected from Day drop down");
	}
	public void selectMonthDropDown(String month) {
		 DrpDn = new Select(Monthofbirth);
		 DrpDn.selectByVisibleText(month);
		System.out.println(month + " is selected from Day drop down");
	}
	public void selectYearDropDown(String Year) {
		DrpDn = new Select(Yearofbirth);
		DrpDn.selectByVisibleText(Year);
		System.out.println(Year + " is selected from Day drop down");
	}
	public void selectNewsLettersChkBox(String status) {		
		if(NewsLettersCheckbox.isSelected() && status.equalsIgnoreCase("OFF")) {
			// Code to uncheck the check box
			NewsLettersCheckbox.click();
			System.out.println("Selenium WebDriver Check Box is unchecked");
		}
		else if(status.equalsIgnoreCase("ON")) {
			// Code to check the check box
			NewsLettersCheckbox.click();
			System.out.println("Selenium WebDriver Check Box is checked");
		}
	}
	public void clickRegisterButton() {
		RegisterButton.click();
		System.out.println("Register Button is Clicked");
	}
	public String getSuccessMessage() {
		return RegSuccessMessage.getText();
	}
	public void ClickOnSignOut() {
		UserSignOut.click();
	}
	
	//Error Messages
	public String getCreateAnAccountErrorMsg() {
		return CreateAnAccountErrorMsg.getText();
	}
	public String getRegErrorMessage() {
		return RegErrorMessage.getText();
	}
}
