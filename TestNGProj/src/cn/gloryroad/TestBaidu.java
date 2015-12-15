package cn.gloryroad;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBaidu {
  public WebDriver driver;
  	String baseUrl = "http://www.baidu.com/"; //设定访问网站的地址
	
  @Test
  public void testSearch() {
	 //打开sogou首页
	  driver.get(baseUrl+"/");
	  //在搜索框中输入“光荣之路自动化测试”
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
