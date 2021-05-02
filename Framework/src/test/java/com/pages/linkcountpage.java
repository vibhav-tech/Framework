package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class linkcountpage {
	
	WebDriver driver;
	public linkcountpage(WebDriver Idriver)
	{
		this.driver=Idriver;
	}

	public void Linkcount()
	{
	List<WebElement>objlist= driver.findElements(By.tagName("a"));
	System.out.println(objlist.size());
	}
}
