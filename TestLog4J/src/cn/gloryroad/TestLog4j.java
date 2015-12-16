package cn.gloryroad;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class TestLog4j {
	public WebDriver driver;
	String baseUrl ="http://www.sogou.com/";
  @Test
  public void testSearch() {
	  Log.startTestCase("����");
	  
	  driver.get(baseUrl+"/");
	  
	  Log.info("��sogou��ҳ");
	  
	  driver.findElement(By.id("query")).sendKeys("����֮·�Զ�������");
	  
	  Log.info("���������ؼ��֡�����֮·�Զ������ԡ�");
	  
	  driver.findElement(By.id("stb")).click();
	  
	  Log.info("����������ť");
	  
	  Log.endTestCase("����");
  }
  
  @BeforeMethod
  public void beforeMethod(){
	  driver=new FirefoxDriver();
  }
  
  @AfterMethod
  public void afterMethod(){
	  driver.quit();
  }
  
  @BeforeClass
  public void beforeclass(){
	  DOMConfigurator.configure("log4j.xml");
  }
}
