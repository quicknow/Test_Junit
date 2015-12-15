package cn.gloryroad.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import cn.gloryroad.util.ObjectMap;

public class HomePage {
	private WebElement element=null;
	private ObjectMap objectMap=new ObjectMap("F:\\selenium_java\\Test_Junit\\DataDrivenFrameWork\\objectMap.properties");

	private WebDriver driver;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
	}
	
	//获取登陆后主页中的“通讯录”链接
	public WebElement addressLink() throws Exception{
		element = driver.findElement(objectMap.getLocator("126mail.homepage.addressbook"));
		return element;
	}
}
