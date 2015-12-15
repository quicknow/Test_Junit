package cn.gloryroad.testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import cn.gloryroad.pageobjects.LoginPage;

public class Test126mail {
	private WebDriver driver;
	private String baseUrl="http://mail.126.com";
	@Test
	public void testLogin() throws InterruptedException{
		driver.get(baseUrl);
		LoginPage loginpage = new LoginPage(driver);
		loginpage.userName.sendKeys("testman1978");
		loginpage.password.sendKeys("wulaoshi1978");
		loginpage.loginButton.click();
		Thread.sleep(5000);
		
		Assert.assertTrue(driver.getPageSource().contains("Î´¶ÁÓÊ¼þ"));		
	}
	@BeforeMethod
	public void beforeMethod(){
		driver=new FirefoxDriver();
	}
	
	@AfterMethod
	public void afterMethod(){
		driver.quit();
	}

}
