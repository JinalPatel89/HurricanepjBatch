package org.h2k.mmp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InformationPage {

	WebDriver driver;
	
	//parameterized cons
	public InformationPage(WebDriver driver) {
	
	  this.driver = driver;
	}

	public boolean verifyInformationDetails(String name)
	{
		String text = driver.findElement(By.className("panel-title")).getText();
		System.out.println("Text " + text);
		System.out.println("Name::::" + name);
		boolean result = text.contains(name);
		return result;
	
	}
}
