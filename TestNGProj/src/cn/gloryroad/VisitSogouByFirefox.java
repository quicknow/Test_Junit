package cn.gloryroad;

import org.testng.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VisitSogouByFirefox {
	
	WebDriver driver;
	String baseUrl;
	
	@BeforeMethod
	public void setUp() throws Exception{
		
		baseUrl="http://www.sogou.com";
		
		driver=new FirefoxDriver();
	}
	
	@Test
	public void visitSogou(){
		
		driver.get(baseUrl+"/");
	}
	
	@AfterMethod
	public void tearDown() throws Exception{
		driver.quit(); //¹Ø±Õä¯ÀÀÆ÷
	}

}

