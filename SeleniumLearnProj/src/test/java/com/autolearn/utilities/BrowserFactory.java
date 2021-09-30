package com.autolearn.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	public static WebDriver launchBrowser(WebDriver driver, String browser, String appUrl)
	{
		if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Projects\\Jars\\geckodriver-v0.29.1-win64\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("Incorrect browser name");
		}
		
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get(appUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return driver;
		
	}
	
	public static void quirBrowser(WebDriver driver)
	{
		driver.quit();
	}
}
