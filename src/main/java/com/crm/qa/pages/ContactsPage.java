package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase;


public class ContactsPage extends TestBase
{
	
	
	
	@FindBy(xpath="//div[text()='Contacts']")
	@CacheLookup
	WebElement contactsLabel;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lastName;
	
	@FindBy(xpath="//div[@name='company']//descendant::input[@class='search']")
	WebElement companyName;
	
	@FindBy(xpath="//button[text()='New']")
	WebElement newContactButton;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement saveButton;
	
	@FindBy(xpath="//div[@name='channel_type' and @role='listbox']")
	WebElement divDropDown;
	
	@FindBy(xpath="//span[@class='item-text' and text()='Contacts']")
	WebElement LeftContactLabel;
	
	@FindBy(xpath="//input[@placeholder='Email address' and @name='value']")
	WebElement emailId;
	
	
	//td[text()='Emma Watson']//preceding-sibling::td//input[@name='id']
	
	//initializing page objects
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel()
	{
		return contactsLabel.isDisplayed();
	}
	
	public boolean selectContactsByName(String contactName)
	{
		try 
		{
			Thread.sleep(5000);
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		WebElement checkBox = driver.findElement(By.xpath("//td[text()='"+contactName+"']//preceding-sibling::td//input[@name='id']"));
		checkBox.click();
		
		return checkBox.isSelected();
	}
	
	public void createNewContact(String ftName,String ltName,String cName,String eId)
	{
		newContactButton.click();
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		companyName.sendKeys(cName);
		emailId.sendKeys(eId);
		//companyName.sendKeys(cName);
		//adding explicit wait for dropDown as it is throwing element not intractable exception
		/*new WebDriverWait(driver, TestUtil.EXPLICIT_WAIT).ignoring(ElementNotInteractableException.class).until(ExpectedConditions.elementToBeClickable(divDropDown));
		divDropDown.click();
		driver.findElement(By.xpath("//div[@class='visible menu transition']//descendant::div//span[text()='"+socialHandle+"']")).click();*/
		saveButton.click();
		try
		{
		Thread.sleep(5000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
			
	}

}
