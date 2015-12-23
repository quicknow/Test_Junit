package cn.gloryroad.appModules;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.openqa.selenium.support.*;

import cn.gloryroad.pageObjects.AddressBookPage;
import cn.gloryroad.pageObjects.HomePage;
import cn.gloryroad.util.Log;

public class AddContactPerson_Action {
	
	public static void execute(WebDriver driver,String userName,String password,String contactName,String contactEmail,String contactMobile) throws Exception{
		Log.info("���� Login_Action���execute����");
		Login_Action.execute(driver, userName, password);
		
		Thread.sleep(3000);
		Log.info("���Ե�¼���ҳ���Ƿ������δ���ʼ����Ĺؼ���");
		Assert.assertTrue(driver.getPageSource().contains("δ���ʼ�"));		
		
		HomePage homePage = new HomePage(driver);
		Log.info("�ڵ�¼����û���ҳ�У�������ͨѶ¼������");
		homePage.addressLink().click();
		
		AddressBookPage addressBookPage = new AddressBookPage(driver);
		Log.info("����3�룬�ȴ���ͨѶ¼ҳ��");		
		Thread.sleep(3000);	
		addressBookPage.createContactPersonButton().click();
		
		Thread.sleep(1000);
		Log.info("����ϵ��������������У����룺"+contactName);		
		addressBookPage.contactPersonName().sendKeys(contactName);
		
		Log.info("����ϵ�˵����ʼ���������У����룺"+contactEmail);
		addressBookPage.contactPersonEmail().sendKeys(contactEmail);
		
		Log.info("����ϵ���ֻ��ŵ�������У����룺"+contactMobile);
		addressBookPage.contactPersonMobile().sendKeys(contactMobile);
		
		Log.info("����ϵ�˺Ｑ�õ�������У�������ȷ������ť");
		addressBookPage.saveButton().click();
		Log.info("����5�룬�ȴ�������ϵ�˺󷵻ص�ͨѶ¼����ҳ��");
		Thread.sleep(5000);		
	}
		

}
