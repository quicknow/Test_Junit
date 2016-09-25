package cn.gloryroad;

import org.testng.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class VisitSogouByChrome {
	
	WebDriver driver;
	String baseUrl;
	@BeforeMethod
	public void setUp() throws Exception{
		
		baseUrl="http://www.sogou.com";
		System.setProperty("webdriver.chrome.driver","C:\\Python27\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	
	@Test
	public void visitSogou(){
		
		driver.get(baseUrl+"/");
	}
	
	@AfterMethod
	public void tearDown() throws Exception{
		//driver.quit();
	}

}
