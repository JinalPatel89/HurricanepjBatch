package org.h2k.mmp.mmpmodule;

 
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.h2k.mmp.pages.InformationPage;
import org.h2k.mmp.pages.NavigationMethods;
import org.h2k.util.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.read.biff.BiffException;

public class MMPTests extends BaseClass{
	/**
	 * Number of columns in the Excel refer to number of arguments for the @Test method
	 * Number of rows in the Excel refer to the number of times the @Test methods execute
	 * 
	 * @param infoData
	 */
	 
	@Test(dataProvider="infoData")
	public void verifyMMPInformation(String infoData)
	{
		
		NavigationMethods ng = new NavigationMethods(driver);
		System.out.println("url value is "+ url);
		ng.navigateToAURL(url);
		ng.navigateToAPage("HOME");
		ng.navigateToAPage("Information");	
		InformationPage info = new InformationPage(driver);
		boolean result = info.verifyInformationDetails(infoData);
		AssertJUnit.assertTrue(result);
	}
	
	
	@DataProvider(name="infoData")
	public String[][] storeArrDataintoDP() throws BiffException, IOException
	{
		String data[][] =readXLSfile("data.xls");
		return data;
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
		driver = null;
	}
	

}
