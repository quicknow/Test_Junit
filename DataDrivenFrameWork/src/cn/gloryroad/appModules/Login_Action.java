package cn.gloryroad.appModules;

import org.openqa.selenium.WebDriver;
import cn.gloryroad.pageObjects.LoginPage;
import org.openqa.selenium.support.*;
import cn.gloryroad.util.Log;


public class Login_Action {
	
	public static void execute(WebDriver driver, String userName, String passWord) throws Exception{
		
		Log.info("访问网址 http://mail.126.com");
		driver.get("http://mail.126.com");
		
		LoginPage loginPage = new LoginPage(driver);
		
		Log.info("在126邮箱登录页面的用户名输入框输入"+userName);
		loginPage.userName().sendKeys(userName);
		
		Log.info("在126邮箱登录页面的密码输入框输入"+passWord);
		loginPage.password().sendKeys(passWord);
		
		Log.info("单击登录页面的登录按钮");
		loginPage.loginButton().click();
		
		Log.info("在单击登录按钮后，休眠5秒，等待从登录页跳转到登录后的用户主页"+passWord);
		Thread.sleep(5000);
	}

}
