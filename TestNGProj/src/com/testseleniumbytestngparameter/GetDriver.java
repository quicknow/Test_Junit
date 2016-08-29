package com.testseleniumbytestngparameter;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class GetDriver {
	public static WebDriver driver;
	
	//设定远程节点连接的URL
	public static String nodeUrl="http://192.168.0.102:6655/wd/hub";
	
	//获取IE浏览器Driver对象的封装方法
	public static WebDriver getRemoteIEdriver(String remoteNodeUrl) throws MalformedURLException{
		//远程使用IE浏览器执行测试
		DesiredCapabilities capabilitie = DesiredCapabilities.internetExplorer();		
		capabilitie.setBrowserName("internetExplorer");
		
		capabilitie.setPlatform(Platform.XP);		
		driver = new RemoteWebDriver(new URL(nodeUrl),capabilitie);
		return driver;
	}
	
	
	//获取chrome浏览器Driver对象的封装方法
	public static WebDriver getRemoteChromedriver(String remoteNodeUrl) throws MalformedURLException{
		//远程使用chrome浏览器执行测试
		DesiredCapabilities capabilitie = DesiredCapabilities.chrome();		
		capabilitie.setBrowserName("chrome");
		
		capabilitie.setPlatform(Platform.XP);		
		driver = new RemoteWebDriver(new URL(nodeUrl),capabilitie);
		return driver;
	}
	
	//获取chrome浏览器Driver对象的封装方法
	public static WebDriver getRemoteFirefoxdriver(String remoteNodeUrl) throws MalformedURLException{
		//远程使用chrome浏览器执行测试
		DesiredCapabilities capabilitie = DesiredCapabilities.firefox();		
		capabilitie.setBrowserName("firefox");
		
		capabilitie.setPlatform(Platform.XP);		
		driver = new RemoteWebDriver(new URL(nodeUrl),capabilitie);
		return driver;
	}

}
