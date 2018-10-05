package org.h2k.util;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class BaseClass {

	protected WebDriver driver=null;
    protected String url = null;
	@Parameters({"browserType","url"})
	@BeforeClass
	protected void getDriverInstance(String browserType,String url)
	{
		System.out.println("in getDriverInstance");
		this.url = url;
		System.out.println("url is " + url);
		if(browserType.equals("IE"))
		{
			driver=new InternetExplorerDriver();
		}
		else if(browserType.equals("CH"))
		{
			driver = new ChromeDriver();
		}
		else
		{
			System.setProperty("webdriver.gecko.driver","geckodriver.exe");
			driver = new FirefoxDriver();
		}
		 
	}
	public   String[][] readXLSfile(String fileName) throws BiffException, IOException
	{
		File f = new File(fileName);
		Workbook wb = Workbook.getWorkbook(f);
		Sheet sh = wb.getSheet(0);
		int rows = sh.getRows();
		int cols = sh.getColumns();
		String arr [][] = new String[rows][cols];
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				Cell cell = sh.getCell(j,i);
				arr[i][j]=cell.getContents();
			}
		}
		return arr;
		
	}
}
