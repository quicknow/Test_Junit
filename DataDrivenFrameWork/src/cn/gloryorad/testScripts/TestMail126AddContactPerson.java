package cn.gloryorad.testScripts;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import cn.gloryroad.appModules.AddContactPerson_Action;
import cn.gloryroad.appModules.Login_Action;
import org.openqa.selenium.support.*;
import cn.gloryroad.util.*;

public class TestMail126AddContactPerson {
	public WebDriver driver;
	//����Constant���еĳ���Constant.Url
	private String baseUrl = Constant.Url;
	
	@Test
	public void testAddContactPerson() throws Exception{
		driver.get(baseUrl);
		String mailUserName=ExcelUtil.getCellData(1, 1);
		String mailPassWord=ExcelUtil.getCellData(1, 2);
		String contactPersonName=ExcelUtil.getCellData(1, 3);
		String contactPersonEmail=ExcelUtil.getCellData(1,4);
		String contactPersonMobile = ExcelUtil.getCellData(1, 5);
		
		Log.info("����AddContactPerson_Action���execute����");		
		AddContactPerson_Action.execute(driver,mailUserName, mailPassWord, contactPersonName, contactPersonEmail, contactPersonMobile);
		Log.info("����AddContactPerson_Action���execute����������3��");	
		Thread.sleep(3000);
		Log.info("����ͨѶ¼��ҳ���Ƿ������ϵ�������Ĺؼ���");
		Assert.assertTrue(driver.getPageSource().contains(contactPersonName));
		Log.info("����ͨѶ¼��ҳ���Ƿ������ϵ���ʼ���ַ�Ĺؼ���");
		Assert.assertTrue(driver.getPageSource().contains(contactPersonEmail));
		Log.info("����ͨѶ¼��ҳ���Ƿ������ϵ���ֻ��ŵĹؼ���");
		Assert.assertTrue(driver.getPageSource().contains(contactPersonMobile));
		Log.info("�½���ϵ�˵�ȫ�����Գɹ�����Excel�Ĳ��������ļ��ġ�����ִ�н��������д�롰ִ�гɹ���");
		ExcelUtil.setCellData(1, 9, "ִ�гɹ�");
		Log.info("���Խ���ɹ�д��Excel�����ļ��ġ�����ִ�н������");
		Log.endTestCase(ExcelUtil.getCellData(1, 0));
	}
	
	@BeforeMethod
	public void beforeMethod(){
		
		driver= new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void afterMethod(){
		driver.quit();
	}
	
	@BeforeClass
	//ʹ��Constand���еĳ������趨���������ļ����ļ�·���Ͳ����������ڵ�Sheet����
	public void BeforeClass() throws Exception{
		ExcelUtil.setExcelFile(Constant.TestDataExcelFilePath, Constant.TestDataExcelFileSheet);
		DOMConfigurator.configure("log4j.xml");
	}
	

}
