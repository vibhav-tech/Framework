package com.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.Utilities.BrowserFactory;
import com.Utilities.Configdataprovider;
import com.Utilities.Exceldataprovider;
import com.Utilities.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Baseclass 
{
	public WebDriver driver;
	public Configdataprovider config;
	public Exceldataprovider excel;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setupsuite()
	{
		Reporter.log("Setting up reports and Test is getting ready",true);
		config=new Configdataprovider();
		excel=new Exceldataprovider();
		
		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/Amazoncheckout.html"));
		report=new ExtentReports();
		report.attachReporter(extent);
		Reporter.log("Setting Done and Test can be Started",true);
	}
	@BeforeClass
	public void setup()
	{
		Reporter.log("Trying to start the browser and getting application ready",true);
		driver= BrowserFactory.Startapplication(driver,config.getbrowser(),config.gettestURL());
		Reporter.log("Browser and Application up and Running",true);
	}
	
	@AfterClass
	public void teardown()
	{
		BrowserFactory.quitbrowser(driver);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException
	{
		Reporter.log("Test is about to End",true);
		if(result.getStatus() == ITestResult.FAILURE)
		{
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		report.flush();
		Reporter.log("Test Completed>>> Reports Generated",true);
	}

}
