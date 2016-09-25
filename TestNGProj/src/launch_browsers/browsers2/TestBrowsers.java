package launch_browsers.browsers2;

import org.testng.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBrowsers {
	
	WebDriver driver;
	String baseUrl;
	@BeforeMethod
	public void setUp() throws Exception{
		
		//Browsers browser= new Browsers(Browsers.ie);
		//driver = browser.driver;
	}
	
	@Test
	public void visitSogou(){
		
		driver.get("http://www.baidu.com");
	}
	
	@AfterMethod
	public void tearDown() throws Exception{
		//driver.quit();
	}	

}