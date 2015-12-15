package cn.gloryroad;

import org.testng.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class VisitSogouByIE {
	
	WebDriver driver;
	String baseUrl;
	@BeforeMethod
	public void setUp() throws Exception{
		
		baseUrl="http://www.sogou.com";
		System.setProperty("webdriver.ie.driver","C:\\Python27\\IEDriverServer.exe");
		driver=new InternetExplorerDriver();
	}
	
	@Test
	public void visitSogou(){
		
		driver.get(baseUrl+"/");
	}
	
	@AfterMethod
	public void tearDown() throws Exception{
		driver.quit();
	}

}
