package com.Testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Utilities.Exceldataprovider;
import com.pages.Baseclass;
import com.pages.Search_addtocart_item_page;
import com.pages.linkcountpage;

public class Itemcount_incart_checkout extends Baseclass
{
	
	@Test(priority=1)
	public void printtitle()
	{
	logger=report.createTest("Print page Title");	
	System.out.println(driver.getTitle());
	logger.pass("Title printed");
	}
	
	@Test(priority=2)
	public void totallinksonpage()
	{
		logger=report.createTest("Count Total no. of Links");
		linkcountpage links=PageFactory.initElements(driver, linkcountpage.class);
		links.Linkcount();
		logger.pass("Count Printed");
	}
	
	@Test(priority=3)
	public void Enteritem_checkout()
	{
		logger=report.createTest("Count No. of Item in cart and checkout");
		Exceldataprovider excel=new Exceldataprovider();
		Search_addtocart_item_page searchpage = PageFactory.initElements(driver, Search_addtocart_item_page.class);
		searchpage.enteritemdata(excel.getStringData("Items", 0, 0));
		searchpage.cartcount();
		searchpage.checkout();
		logger.pass("Count Printed and checkout sucessfully");
	}
	
	
	
	

}
