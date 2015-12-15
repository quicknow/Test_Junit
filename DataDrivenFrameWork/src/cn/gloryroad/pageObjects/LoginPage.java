package cn.gloryroad.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import cn.gloryroad.util.*;


public class LoginPage {
	private WebElement element = null;
	//ָ��ҳ��Ԫ�ض�λ���ʽ�����ļ��ľ����ļ�·��
	private ObjectMap objectMap = new ObjectMap("F:\\selenium_java\\Test_Junit\\DataDrivenFrameWork\\objectMap.properties");
	private WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	

 //���ص�½ҳ���е��û��������ҳ��Ԫ�ض���
	public WebElement userName() throws Exception{
		//ʹ��objectMap���е�getLocator������ȡ�����ļ��й����û����Ķ�λ��ʽ�Ͷ�λ���ʽ 126mail.loginPage.username
		element = driver.findElement(objectMap.getLocator("126mail.loginPage.username"));
		return element;
	}
	
	public WebElement password() throws Exception{
		element = driver.findElement(objectMap.getLocator("126mail.loginPage.password"));
		return element;
	}
	
	public WebElement loginButton() throws Exception{
		element= driver.findElement(objectMap.getLocator("126mail.loginPage.loginbutton"));
		return element;
	}
}
