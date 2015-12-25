package cn.gloryorad.testScripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cn.gloryroad.appModules.AddContactPerson_Action;
import cn.gloryroad.appModules.Login_Action;
import cn.gloryroad.util.*;

public class TestMail126AddContactPerson {
	public WebDriver driver;
	//����Constant���еĳ���Constant.Url
	private String baseUrl = Constant.Url;
	
	
	//����dataProvider,������testData
	@DataProvider(name="testData")
	public static Object[][] data() throws Exception{
		return ExcelUtil.getTestData(Constant.TestDataExcelFilePath, Constant.TestDataExcelFileSheet);
	}
	
	@Test(dataProvider="testData")
	public void testAddressBook(String CaseRowNumber, String testCaseName,String mailUserName,
			String mailPassWord,String contactPersonName,String contactPersonEmail,
			String contactPersonMobile,String assertContactPersonName,
			String assertContactPersonEmail,String assertContactPersonMobile) throws Exception{
		
		Log.startTestCase(testCaseName);
		
		driver.get(baseUrl);
		
		Log.info("����AddContactPerson_Action ��� execute����");
		
		try{
			AddContactPerson_Action.execute(driver, mailUserName, mailPassWord, contactPersonName, contactPersonEmail, contactPersonMobile);
		} catch(AssertionError error){
			Log.info("�����ϵ��ʧ��");
			ExcelUtil.setCellData(Integer.parseInt(CaseRowNumber.split("[.]")[0]), ExcelUtil.getLastColumnNum(), "����ִ��ʧ��");
			Assert.fail("ִ��AddContactPerson_Action���execute����������3��");				
		}
		
		Log.info("����AddContactPerson_Action���execute����������3��");
		Thread.sleep(3000);
		Log.info("����ͨѶ¼��ҳ���Ƿ������ϵ�������Ĺؼ���");
		
		try{
			Assert.assertTrue(driver.getPageSource().contains(assertContactPersonName));
		} catch(AssertionError error){
			Log.info("����ͨѶ¼��ҳ���Ƿ������ϵ�������Ĺؼ���ʧ��");
			ExcelUtil.setCellData(Integer.parseInt(CaseRowNumber.split("[.]")[0]), ExcelUtil.getLastColumnNum(), "����ִ��ʧ��");
			Assert.fail("����ͨѶ¼��ҳ���Ƿ������ϵ�������Ĺؼ���ʧ��");
		}
		Log.info("����ͨѶ¼��ҳ���Ƿ������ϵ�˵����ʼ���ַ�Ĺؼ���");
		
		try{
			Assert.assertTrue(driver.getPageSource().contains(assertContactPersonEmail));
		} catch(AssertionError error){
			Log.info("����ͨѶ¼��ҳ���Ƿ������ϵ�������ĵ����ʼ���ַʧ��");
			ExcelUtil.setCellData(Integer.parseInt(CaseRowNumber.split("[.]")[0]), ExcelUtil.getLastColumnNum(), "����ִ��ʧ��");
			Assert.fail("����ͨѶ¼��ҳ���Ƿ������ϵ�������ĵ����ʼ���ַʧ��");
		}
		
		Log.info("����ͨѶ¼��ҳ���Ƿ������ϵ���ֻ��õĹؼ���");
		
		try{
			Assert.assertTrue(driver.getPageSource().contains(assertContactPersonMobile));
		} catch(AssertionError error){
			Log.info("����ͨѶ¼��ҳ���Ƿ������ϵ���ֻ��ŵĹؼ���ʧ��");
			ExcelUtil.setCellData(Integer.parseInt(CaseRowNumber.split("[.]")[0]), ExcelUtil.getLastColumnNum(), "����ִ��ʧ��");
			Assert.fail("����ͨѶ¼��ҳ���Ƿ������ϵ���ֻ��ŵĹؼ���ʧ��");
		}
		
		Log.info("�½���ϵ�˵�ȫ�����Գɹ�����Excel�Ĳ��������ļ��ġ�����ִ�н��������д�롰ִ�гɹ���");
		ExcelUtil.setCellData(Integer.parseInt(CaseRowNumber.split("[0]")[0]), ExcelUtil.getLastColumnNum(), "ִ�гɹ�");
		Log.info("���Խ���ɹ�д��excel�����ļ��ġ�����ִ�н������");
		Log.endTestCase(testCaseName);
	}
	
	
	
	@BeforeMethod
	public void beforeMethod(){
		
		//driver.manage().window().maximize();  ��driverʵ����֮ǰ�ӻᱨ����
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
