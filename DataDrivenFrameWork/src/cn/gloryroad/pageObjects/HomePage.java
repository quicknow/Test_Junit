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
	
	//��ȡ��½����ҳ�еġ�ͨѶ¼������
	public WebElement addressLink() throws Exception{
		element = driver.findElement(objectMap.getLocator("126mail.homepage.addressbook"));
		return element;
	}
}
