package com.mystore.objectrepository;

public class MyStoreObjectsRepository {
	//Declaring Logo web Element
	public static final String LogoXpath="//img[@class='logo img-responsive']";

	//Declaring Home Page Web Elements
	public static final String SearchBoxID="search_query_top";
	public static final String SearchButtonName="submit_search";
	public static final String SigninButton="//a[@class='login']";
	public static final String accountinfo="//form[@id='create-account_form']";
	public static final String Errormsg="//div[@id='create_account_error']";
	//Declaring Creating accouts page web Elements
	public static final String EmailXpath="//input[@name='email_create']";
	public static final String CreateAnAcoountButtonID="SubmitCreate";
	public static final String CreateAnAccountErrorMsgID="create_account_error";
	//Declaring Personal Information page web elements
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
	public static final String UserLogOut="//a[@class='logout']";
	public static final String RegSuccessMessageXpath="//p[@class='alert alert-success']";
	public static final String RegErrorMessageXpath="//div[@class='alert alert-danger']";

}
