package com.autolearn.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.autolearn.utilities.BrowserFactory;
import com.autolearn.utilities.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {

	public WebDriver driver;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUp()
	{
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File("./Reports/AutoLearn_"+Helper.getCurrentDateTime()+".html"));
		
		report=new ExtentReports();
		report.attachReporter(extent);
	}
	
	@BeforeClass
	public void launchApp()
	{
		driver = BrowserFactory.launchBrowser(driver, "Firefox", "https://classic.freecrm.com/login.cfm");
		//return driver;
		System.out.println("before test");
	}
	
	
	@AfterClass
	public void quitApp()
	{
		BrowserFactory.quirBrowser(driver);
		System.out.println("after test");
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			Helper.captureScreenshot(driver);
			logger.fail("Test skipped", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		
		report.flush();
	}
	
}
