package cn.gloryroad;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBaidu {
  public WebDriver driver;
  	String baseUrl = "http://www.baidu.com/"; //�趨������վ�ĵ�ַ
	
  @Test
  public void testSearch() {
	 //��sogou��ҳ
	  driver.get(baseUrl+"/");
	  //�������������롰����֮·�Զ������ԡ�
	  driver.findElement(By.id("kw")).sendKeys("HelloWorld");
	  
	  driver.findElement(By.id("su")).click();
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  driver=new FirefoxDriver();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
