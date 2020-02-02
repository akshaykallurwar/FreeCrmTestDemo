package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase
{
	public static long PAGE_LOAD_TIMEOUT =20;
	public static long IMPLICIT_WAIT =10;
	public static long EXPLICIT_WAIT =20;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static Object[][] data;
	
	
	/*public void switchToFrame()
	{
		driver.switchTo().frame("mainpanel");
	}*/
	
	public static Object[][] getTestData(String sName) 
	{
		
		try 
		{
		File f = new File("F:\\Sep2019\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\util\\testData.xlsx");
		FileInputStream file = new FileInputStream(f);
		workbook = new XSSFWorkbook(file); 
		sheet = workbook.getSheetAt(0);
		System.out.println(sheet.getLastRowNum());
		System.out.println(sheet.getRow(0).getLastCellNum());
		data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		
		
		for (int i = 0; i < sheet.getLastRowNum(); i++) 
		{
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) 
			{
				data[i][k] = sheet.getRow(i + 1).getCell(k).getStringCellValue();
				// System.out.println(data[i][k]);
			}
		}
		
		}
		
		
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
		
		
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException 
	{
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		
	}
	
	
	
	

}
