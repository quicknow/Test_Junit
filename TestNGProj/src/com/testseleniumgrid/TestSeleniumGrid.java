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
	
	
	//����node�ڵ��URL��ַ,ע��nat��ʽ��Ҫʹ�ö˿�ת������������nat�ڲ�������
	public static String nodeUrl ="http://192.168.0.102:6655/wd/hub";
	@Test
	public void testSogouSearch(){
		
		driver.get(baseUrl+"/");
		
		driver.findElement(By.id("query")).sendKeys("����֮·�Զ�������");
		
		driver.findElement(By.id("stb")).click();
		
		Assert.assertTrue(driver.getPageSource().contains("����֮·�Զ�������"));
	}
	
	@BeforeMethod
	public void beforeMethod() throws MalformedURLException{
		//Զ��ʹ�û�������ִ�в���
//		DesiredCapabilities capabilitie = DesiredCapabilities.firefox();		
//		capabilitie.setBrowserName("firefox");
		
		//Զ��ʹ��IE�����ִ�в���
//		DesiredCapabilities capabilitie = DesiredCapabilities.internetExplorer();		
//		capabilitie.setBrowserName("internetExplorer");
//		
		//Զ��ʹ��chrome�����ִ�в���
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