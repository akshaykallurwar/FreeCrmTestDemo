package com.crm.qa.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.crm.qa.base.TestBase;

public class CustomListener extends TestBase implements ITestListener
{

	public void onTestStart(ITestResult result) 
	{
		
	}

	public void onTestSuccess(ITestResult result) 
	{
		
	}

	//we will use this method
	public void onTestFailure(ITestResult result) 
	{
		System.out.println("FAILED test");
		failed(result.getMethod().getMethodName());
		
	}

	public void onTestSkipped(ITestResult result) 
	{
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		
	}

	public void onStart(ITestContext context) 
	{
		
	}

	public void onFinish(ITestContext context) 
	{
		
	}
	
	

}
