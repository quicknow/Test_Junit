package cn.gloryroad.tests3;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import cn.gloryroad.pageobjects3.HomePage;
import cn.gloryroad.pageobjects3.LoginPage;

public class Test126mail {
	public WebDriver driver;
	@BeforeMethod
	public void beforeMethod(){
		driver= new FirefoxDriver();
	}

	@AfterMethod
	public void aftermethod(){
		driver.quit();
	}
	
	//用户名或密码输入错误的测试案例
	@Test
	public void testLoginFail() throws InterruptedException{
		LoginPage loginpage = new LoginPage(driver);		
		loginpage.get();
		loginpage.LoginExpectingFailure();
		Thread.sleep(1500);
		Assert.assertTrue(loginpage.getPageSource().contains("帐号或密码错误"));
		loginpage.close();
	}
	//用户名和密码输入正确，正常登陆的测试案例
	@Test
	public void testLoginSuccess() throws InterruptedException{
		LoginPage loginpage = new LoginPage(driver);
		loginpage.get();
		HomePage homePage = loginpage.login();
		Thread.sleep(5000);
		Assert.assertTrue(homePage.getPageSource().contains("未读邮件"));
		homePage.close();
	}
	//用户登陆正常，并正常发送邮件的测试案例
	@Test
	public void testwritemail() throws InterruptedException{
		LoginPage loginpage = new LoginPage(driver);
		loginpage.get();
		HomePage homepage = loginpage.login();
		Thread.sleep(5000);
		homepage.writemail();
		Thread.sleep(5000);
		Assert.assertTrue(homepage.getPageSource().contains("发送成功"));
		homepage.close();
		
	}
	
}
