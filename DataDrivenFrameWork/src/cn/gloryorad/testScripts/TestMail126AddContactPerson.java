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
	//调用Constant类中的常量Constant.Url
	private String baseUrl = Constant.Url;
	
	@Test
	public void testAddContactPerson() throws Exception{
		driver.get(baseUrl);
		String mailUserName=ExcelUtil.getCellData(1, 1);
		String mailPassWord=ExcelUtil.getCellData(1, 2);
		String contactPersonName=ExcelUtil.getCellData(1, 3);
		String contactPersonEmail=ExcelUtil.getCellData(1,4);
		String contactPersonMobile = ExcelUtil.getCellData(1, 5);
		
		Log.info("调用AddContactPerson_Action类的execute方法");		
		AddContactPerson_Action.execute(driver,mailUserName, mailPassWord, contactPersonName, contactPersonEmail, contactPersonMobile);
		Log.info("调用AddContactPerson_Action类的execute方法后，休眠3秒");	
		Thread.sleep(3000);
		Log.info("断言通讯录的页面是否包含联系人姓名的关键字");
		Assert.assertTrue(driver.getPageSource().contains(contactPersonName));
		Log.info("断言通讯录的页面是否包含联系人邮件地址的关键字");
		Assert.assertTrue(driver.getPageSource().contains(contactPersonEmail));
		Log.info("断言通讯录的页面是否包含联系人手机号的关键字");
		Assert.assertTrue(driver.getPageSource().contains(contactPersonMobile));
		Log.info("新建联系人的全部断言成功，在Excel的测试数据文件的“测试执行结果”列中写入“执行成功”");
		ExcelUtil.setCellData(1, 9, "执行成功");
		Log.info("测试结果成功写入Excel数据文件的“测试执行结果”列");
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
	//使用Constand类中的常量，设定测试数据文件的文件路径和测试数据所在的Sheet名称
	public void BeforeClass() throws Exception{
		ExcelUtil.setExcelFile(Constant.TestDataExcelFilePath, Constant.TestDataExcelFileSheet);
		DOMConfigurator.configure("log4j.xml");
	}
	

}
