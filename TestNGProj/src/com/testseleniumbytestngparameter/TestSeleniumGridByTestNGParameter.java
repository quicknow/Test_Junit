package com.testseleniumbytestngparameter;

import java.net.*;


import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Assert;
public class TestSeleniumGridByTestNGParameter {
	
	public WebDriver driver;
	public static String baseUrl ="http://www.sogou.com/";	

	@Parameters({"remoteNodeUrl","browser"})	
	@BeforeClass
	public void beforeTest(String remoteNodeUrl,String browser) throws MalformedURLException{
		
		if(browser.equalsIgnoreCase("firefox")){
			driver=GetDriver.getRemoteFirefoxdriver(remoteNodeUrl);
		}else if(browser.equalsIgnoreCase("ie")){
			driver=GetDriver.getRemoteIEdriver(remoteNodeUrl);
		}else if(browser.equalsIgnoreCase("chrome")){
			driver=GetDriver.getRemoteChromedriver(remoteNodeUrl);
		}
	}
	
	
	@Test
	public void testSogouSearch1() throws MalformedURLException{		
		
		driver.get(baseUrl+"/");
		
		driver.findElement(By.id("query")).sendKeys("光荣之路性能测试");
		
		driver.findElement(By.id("stb")).click();
		
		Assert.assertTrue(driver.getPageSource().contains("光荣之路性能测试"));
		driver.quit();
	}
	
	@Test
	public void testSogouSearch2() throws MalformedURLException{		
		
		driver.get(baseUrl+"/");
		
		driver.findElement(By.id("query")).sendKeys("光荣之路自动化测试");
		
		driver.findElement(By.id("stb")).click();
		
		Assert.assertTrue(driver.getPageSource().contains("光荣之路自动化测试"));
		driver.quit();
	}
	
	@AfterClass
	public void afterTest(){
		//所有测试用例执行后，再关闭浏览器
		driver.quit();
	}
	
	
}