package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase
{
	//we need to define Page factory/ Object repository
	
	@FindBy(xpath ="//span[contains(text(),'Log In')]")
	WebElement login;
	
	@FindBy(name = "email")
	WebElement userNameTextBox;
	
	@FindBy(name = "password")
	WebElement passwordTextBox;
	
	@FindBy(xpath = "//div[contains(text(),'Login')]")
	WebElement loginButton;
	
	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement signUpButton;
	
	@FindBy(xpath = "//span[contains(text(),'your business cloud partner ')]")
	WebElement brandSlogan;
	
	//initializing the page objects
	public LoginPage()
	{
		//we will initialize web elements using PageFactory and use the method initElements for the same
		//this means the current class objects will be initialized using driver instance
		PageFactory.initElements(driver, this);
		//PageFactory.initElements(driver, LoginPage.class);
	}
	
	//Actions/Features
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public String validateBrandSlogan()
	{
		return brandSlogan.getText();
	}
	
	public HomePage login(String un,String pwd)
	{
		login.click();
		userNameTextBox.sendKeys(un);
		passwordTextBox.sendKeys(pwd);
		loginButton.click();
		
		return new HomePage();
	}
	
	
	

}
