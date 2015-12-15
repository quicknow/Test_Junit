package cn.gloryroad.appModules;

import org.openqa.selenium.WebDriver;
import cn.gloryroad.pageObjects.LoginPage;
import org.openqa.selenium.support.*;
import cn.gloryroad.util.Log;


public class Login_Action {
	
	public static void execute(WebDriver driver, String userName, String passWord) throws Exception{
		
		Log.info("������ַ http://mail.126.com");
		driver.get("http://mail.126.com");
		
		LoginPage loginPage = new LoginPage(driver);
		
		Log.info("��126�����¼ҳ����û������������"+userName);
		loginPage.userName().sendKeys(userName);
		
		Log.info("��126�����¼ҳ����������������"+passWord);
		loginPage.password().sendKeys(passWord);
		
		Log.info("������¼ҳ��ĵ�¼��ť");
		loginPage.loginButton().click();
		
		Log.info("�ڵ�����¼��ť������5�룬�ȴ��ӵ�¼ҳ��ת����¼����û���ҳ"+passWord);
		Thread.sleep(5000);
	}

}
