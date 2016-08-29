package com.testseleniumgrid;

import java.net.*;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSeleniumGrid2 {
	
	public static String baseUrl ="http://www.sogou.com/";	

	
	@Test
	public void testSogouSearch1() throws MalformedURLException{
		
		WebDriver driver=GetDriver.getRemoteIEdriver();
		driver.get(baseUrl+"/");
		
		driver.findElement(By.id("query")).sendKeys("光荣之路自动化测试");
		
		driver.findElement(By.id("stb")).click();
		
		Assert.assertTrue(driver.getPageSource().contains("光荣之路自动化测试"));
		driver.quit();
	}
	
	@Test
	public void testSogouSearch2() throws MalformedURLException{
		
		WebDriver driver=GetDriver.getRemoteChromedriver();
		driver.get(baseUrl+"/");
		
		driver.findElement(By.id("query")).sendKeys("光荣之路自动化测试");
		
		driver.findElement(By.id("stb")).click();
		
		Assert.assertTrue(driver.getPageSource().contains("光荣之路自动化测试"));
		driver.quit();
	}
	
	@Test
	public void testSogouSearch3() throws MalformedURLException{
		
		WebDriver driver=GetDriver.getRemoteFirefoxdriver();
		driver.get(baseUrl+"/");
		
		driver.findElement(By.id("query")).sendKeys("光荣之路自动化测试");
		
		driver.findElement(By.id("stb")).click();
		
		Assert.assertTrue(driver.getPageSource().contains("光荣之路自动化测试"));
		driver.quit();
	}
	
	
}