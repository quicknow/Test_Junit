package com.testseleniumgrid;
import java.net.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.beust.jcommander.ParametersDelegate;

public class TestSeleniumGrid {
	WebDriver driver;
	public static String baseUrl ="http://www.sogou.com/";	
	
	
	//访问node节点的URL地址,注意nat方式需要使用端口转发技术来访问nat内部的主机
	public static String nodeUrl ="http://192.168.0.102:6655/wd/hub";
	@Test
	public void testSogouSearch(){
		
		driver.get(baseUrl+"/");
		
		driver.findElement(By.id("query")).sendKeys("光荣之路自动化测试");
		
		driver.findElement(By.id("stb")).click();
		
		Assert.assertTrue(driver.getPageSource().contains("光荣之路自动化测试"));
	}
	
	@BeforeMethod
	public void beforeMethod() throws MalformedURLException{
		//远程使用火狐浏览器执行测试
//		DesiredCapabilities capabilitie = DesiredCapabilities.firefox();		
//		capabilitie.setBrowserName("firefox");
		
		//远程使用IE浏览器执行测试
//		DesiredCapabilities capabilitie = DesiredCapabilities.internetExplorer();		
//		capabilitie.setBrowserName("internetExplorer");
//		
		//远程使用chrome浏览器执行测试
		DesiredCapabilities capabilitie = DesiredCapabilities.chrome();		
		capabilitie.setBrowserName("chrome");
		
		capabilitie.setPlatform(Platform.XP);		
		driver = new RemoteWebDriver(new URL(nodeUrl),capabilitie);
		
		
		
	}
	
	@AfterMethod
	public void afterMethod(){
		driver.quit();
	}
	
}