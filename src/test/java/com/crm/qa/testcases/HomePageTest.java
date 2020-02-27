package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.listeners.CustomListener;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

@Listeners(CustomListener.class)
public class HomePageTest extends TestBase 
{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	TasksPage tasksPage;
	//TestUtil testUtil;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		//testUtil= new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = new ContactsPage();
	}
	
	//test cases should be independent with each other
	//before each test case ---lunch the browser and login
	//@Test --- execute the test cases
	//after each test case--- close the browser
	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM","Home page title is not matched");
	}
	
	@Test(priority=2)
	public void verifyCorrectUsernameTest()
	{
		//testUtil.switchToFrame();=====required when frame is present in the application
		Assert.assertTrue(homePage.verifyCorrectUsername());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest()
	{
		//testUtil.switchToFrame();=====required when frame is present in the application
		
		contactsPage=homePage.clickOnContactsLink();
	}
	
	@Test(priority=4)
	public void clickOnDealsLinkTest()
	{
		dealsPage=homePage.clickOnDealsLink();
	}
	
	@Test(priority=5)
	public void clickOnTasksLinkTest()
	{
		tasksPage=homePage.clickOnTasksLink();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	

}
