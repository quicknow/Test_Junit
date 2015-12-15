package cn.gloryroad;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.Assert;

public class AssertTest {
	public WebDriver driver;
	String baseUrl ="http://www.sogou.com/";
	
	@Test
	public void testSogouSearch(){
		//��sogou��ҳ
		driver.get(baseUrl + "/");
		//�������������롰����֮·�Զ������ԡ�
		WebElement inputBox=driver.findElement(By.id("query"));
		
		Assert.assertTrue(inputBox.isDisplayed());
		inputBox.sendKeys("����֮·�Զ�������");
		//��������������ť
		driver.findElement(By.id("stb")).click();	
	}
	
	@BeforeMethod
	public void beforeMethod(){
		
		driver=new FirefoxDriver();
	}
	
	@AfterMethod
	public void afterMethod(){
		
		driver.quit();
	}
}
