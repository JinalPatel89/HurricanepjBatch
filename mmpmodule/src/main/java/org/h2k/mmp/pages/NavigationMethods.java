package org.h2k.mmp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationMethods {

	WebDriver driver;
	public NavigationMethods(WebDriver driver) {
		
		this.driver = driver;
	}
	public void navigateToAURL(String url)
	{
		driver.get(url);
	}
	public void navigateToAPage(String tabName)
	{
		driver.findElement(By.xpath("//a/span[contains(text(),'"+tabName+"')]")).click();
	}
	 
}
