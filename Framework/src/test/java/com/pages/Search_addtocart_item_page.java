package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Search_addtocart_item_page {
	
	
	WebDriver driver;
	public Search_addtocart_item_page(WebDriver Idriver)
	{
		this.driver=Idriver;
	}
	
	@FindBy(xpath="//*[@id=\'twotabsearchtextbox\']") WebElement Searchbox;
	@FindBy(xpath="//*[@id=\"nav-search-submit-text\"]/input") WebElement Searchbutton;
	@FindBy(xpath="//*[@id=\"acs-product-block-0\"]/div[1]/a") WebElement bookimg;
	@FindBy(xpath="//*[@id=\"add-to-cart-button\"]") WebElement addtocart;
	@FindBy(xpath="//*[@id=\"hlb-ptc-btn-native\"]") WebElement Checkout;
	@FindBy(className="nav-cart-count") WebElement count;
	
	public void enteritemdata(String data)
	{
		Searchbox.sendKeys(data);
		Searchbutton.click();
		bookimg.click();
		addtocart.click();
	}
	
	public void checkout()
	{
		Checkout.click();
	}
	
	public void cartcount()
	{
		String ct= count.getText();
		System.out.println("The Item count in cart is " + ct);
	}

}
