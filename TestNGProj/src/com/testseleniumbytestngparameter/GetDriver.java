package com.testseleniumbytestngparameter;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class GetDriver {
	public static WebDriver driver;
	
	//�趨Զ�̽ڵ����ӵ�URL
	public static String nodeUrl="http://192.168.0.102:6655/wd/hub";
	
	//��ȡIE�����Driver����ķ�װ����
	public static WebDriver getRemoteIEdriver(String remoteNodeUrl) throws MalformedURLException{
		//Զ��ʹ��IE�����ִ�в���
		DesiredCapabilities capabilitie = DesiredCapabilities.internetExplorer();		
		capabilitie.setBrowserName("internetExplorer");
		
		capabilitie.setPlatform(Platform.XP);		
		driver = new RemoteWebDriver(new URL(nodeUrl),capabilitie);
		return driver;
	}
	
	
	//��ȡchrome�����Driver����ķ�װ����
	public static WebDriver getRemoteChromedriver(String remoteNodeUrl) throws MalformedURLException{
		//Զ��ʹ��chrome�����ִ�в���
		DesiredCapabilities capabilitie = DesiredCapabilities.chrome();		
		capabilitie.setBrowserName("chrome");
		
		capabilitie.setPlatform(Platform.XP);		
		driver = new RemoteWebDriver(new URL(nodeUrl),capabilitie);
		return driver;
	}
	
	//��ȡchrome�����Driver����ķ�װ����
	public static WebDriver getRemoteFirefoxdriver(String remoteNodeUrl) throws MalformedURLException{
		//Զ��ʹ��chrome�����ִ�в���
		DesiredCapabilities capabilitie = DesiredCapabilities.firefox();		
		capabilitie.setBrowserName("firefox");
		
		capabilitie.setPlatform(Platform.XP);		
		driver = new RemoteWebDriver(new URL(nodeUrl),capabilitie);
		return driver;
	}

}
