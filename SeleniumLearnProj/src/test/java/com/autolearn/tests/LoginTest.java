package com.autolearn.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.autolearn.pages.BaseClass;

public class LoginTest extends BaseClass {

	//Login Test
	
	@Test
	public void Login()
	{
		
		logger = report.createTest("Login to CRM");
		System.out.println("Login Test");
		driver.findElement(By.name("username")).sendKeys("Selenium_50");
		driver.findElement(By.name("password1")).sendKeys("Abcd@123456");
		driver.findElement(By.xpath("//input[@value='Login']1")).click();
		System.out.println("Login Done");
	}
}
