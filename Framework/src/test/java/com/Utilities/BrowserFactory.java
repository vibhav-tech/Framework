package com.Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory 
{
	
	
	public static WebDriver Startapplication(WebDriver driver,String browsername,String appURL)
	{
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
			 ChromeOptions opt=new ChromeOptions();
		     opt.addArguments("--disable-notifications");
			 driver = new ChromeDriver(opt);
			
		}
		else if(browsername.equals("Firefox"))
		{
			System.setProperty("webdriver.chrome.driver","./Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("we do not support this browser");
		}
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		return driver;
	}
	
	public static void quitbrowser(WebDriver driver)
	{
		driver.quit();
	}
	

}
