package com.crm.qa.testcases;


import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.qa.base.TestBase;
import com.crm.qa.listeners.CustomListener;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

@Listeners(CustomListener.class)
public class ContactsPageTest extends TestBase
{

//test
	LoginPage loginPage;
	ContactsPage contactsPage;
	HomePage homePage;
	WebElement checkBox;
	TestUtil testUtil;
	String sheetName = "firstSheet";
	
	
	public ContactsPageTest() 
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage =homePage.clickOnContactsLink();
		
	}
	
	@Test(priority =1)
	public void verifyContactsLabelTest()
	{
		boolean flag = contactsPage.verifyContactsLabel();
		Assert.assertTrue(flag,"issue with contact label");
	}
	
	@Test(priority =2)
	public void selectContactsByNameTest()
	{
		boolean flag =contactsPage.selectContactsByName("Tom Holland");
		Assert.assertTrue(flag);
	}
	
	
	@Test(priority =3)
	public void selectMultipleContactsByNameTest()
	{
		boolean flag1 =contactsPage.selectContactsByName("Tom Holland");
		boolean flag2 =contactsPage.selectContactsByName("Emma Watson");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(flag1, "issue with first contact checkbox");
		softAssert.assertTrue(flag2, "issue with second contact checkbox");
		softAssert.assertAll();
	}
	
	@DataProvider
	public Object[][] getCrmTestData()
	{
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority =4,dataProvider="getCrmTestData")
	public void validateCreateNewContactTest(String firstName,String lastName,String companyName,String emailId)
	{
		//contactsPage.createNewContact("Pat", "Cummins","Cognizant","patcummins23@gmail.com");
		contactsPage.createNewContact(firstName, lastName, companyName, emailId);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}