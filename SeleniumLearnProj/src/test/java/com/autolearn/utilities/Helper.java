package com.autolearn.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	public static String captureScreenshot(WebDriver driver)
	{
		String screenshotPath = System.getProperty("user.dir")+"./Screenshots/CRM_"+getCurrentDateTime()+".png";
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src, new File(screenshotPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("unable to capture SS "+e.getMessage());
		}
		
		return screenshotPath;
	}
	
	public static String getCurrentDateTime()
	{
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date date = new Date();
		return customFormat.format(date);	
	}
	
	
}
