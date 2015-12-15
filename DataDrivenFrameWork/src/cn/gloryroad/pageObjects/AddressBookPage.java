package cn.gloryroad.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import cn.gloryroad.util.ObjectMap;

public class AddressBookPage {
	private WebElement element = null;
	private ObjectMap objectMap = new ObjectMap("F:\\selenium_java\\Test_Junit\\DataDrivenFrameWork\\objectMap.properties");
	private WebDriver driver;
	
	public AddressBookPage(WebDriver driver){
		this.driver=driver;
	}
	//��ȡ�½���ϵ�˰�ť
	public WebElement createContactPersonButton() throws Exception{
		element =driver.findElement(objectMap.getLocator("126mail.addressBook.createContactPerson"));
		return element;
	}
	//��ȡ�½���ϵ�˽����е����������
	public WebElement contactPersonName() throws Exception{
		
		element = driver.findElement(objectMap.getLocator("126mail.addressBook.contactPessonName"));
		return element;		
	}
	
	//��ȡ�½���ϵ�˽����еĵ����ʼ������
	public WebElement contactPersonEmail() throws Exception{
		element = driver.findElement(objectMap.getLocator("126mail.addressBook.contactPersonEmail"));
		return element;
	}
	//��ȡ�½���ϵ�˽����е��ֻ��������
	public WebElement contactPersonMobile() throws Exception{
		
		element = driver.findElement(objectMap.getLocator("126mail.addressBook.contactPersonMobile"));
		return element;		
	}
	
	//��ȡ�½���ϵ�˽����б�����Ϣ�ġ�ȷ������ť
	public WebElement saveButton() throws Exception{
			
		element = driver.findElement(objectMap.getLocator("126mail.addressBook.saveButton"));
		return element;		
	}
	
}
