package com.mystore.objectrepository;

public class MyStoreObjectsRepository {
	// Logo Element
	public static final String LogoXpath="//img[@class='logo img-responsive']";

	// Home Page Elements
	public static final String SearchBoxID="search_query_top";
	public static final String SearchButtonName="submit_search";
	public static final String SigninButton="//a[@class='login']";
	public static final String accountinfo="//form[@id='create-account_form']";
	public static final String Errormsg="//div[@id='create_account_error']";
	
	// Create Account Page Elements
	public static final String EmailXpath="//input[@name='email_create']";
	public static final String CreateAnAcoountButtonID="SubmitCreate";
	public static final String CreateAnAccountErrorMsgID="create_account_error";
	
	// Personal Information Page Elements
	public static final String MrXpath="//input[@id='id_gender1']";
	public static final String MrsXpath="//input[@id='id_gender2']";
	public static final String FirstNameTexboxXpath="//input[@id='customer_firstname']";
	public static final String LastNameTexboxXpath="//input[@id='customer_lastname']";
	public static final String PasswordID="passwd";
	public static final String DayDDXpath="//select[@id='days']";
	public static final String MonthsDDXpath="//select[@id='months']";
	public static final String YearDDXpath="//select[@id='years']";
	public static final String NewsLettersCheckBoxXpath="//input[@id='newsletter']";
	public static final String RegisterButtonXpath="//button[@id='submitAccount']";
	//Registrion success and failed Messages
	public static final String RegSuccessMessageXpath="//p[@class='alert alert-success']";
	public static final String RegErrorMessageXpath="//div[@class='alert alert-danger']";
	
	//My Accounts Page Elements
	public static final String UserLogOut="//a[@class='logout']";
	
	// Login Page Elements
	public static final String EmailAddress_FieldXpath="//input[@id='email']";
	public static final String Password_FieldXpath="//input[@id='passwd']";
	public static final String Forgot_PasswordXpath="//a[@title='Recover your forgotten password']";
	public static final String Signin_ButtonXpath="//button[@id='SubmitLogin']";
	
	// Forgot Password Page Elements
	public static final String Forgot_EmailXpath="//input[@id='email' and @name='email']";
	public static final String Retrive_PasswordXpath="//span[normalize-space()='Retrieve Password']";
	
	// Login Error Messages
	public static final String Login_ErrorMsgXpath="//*[@id=\"center_column\"]/div[1]/ol/li/text()";
	public static final String Password_ErrorMsgXpath="//li[normalize-space()='Password is required.']";


}
