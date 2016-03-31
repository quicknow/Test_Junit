package com.alert;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;




public class TestConfirm {
	
	public WebDriver driver;
	//设定访问网站的地址
	String baseUrl = "d:\\test\\confirm.html";

	
	@Test
	public void TestConfirm() {
		
		
		driver.get(baseUrl);
		
		//使用Xpath定位方法，查找被测试页面上的唯一按钮元素
		WebElement button=driver.findElement(By.xpath("//input"));
		//单击按钮元素
		button.click();
		
		try {
			Alert alert = driver.switchTo().alert();
			
			Assert.assertEquals("这是一个confirm弹出框",alert.getText());
			
			//使用Alert对象的accept方法，单击Alert框上的“确定”按钮，关闭Alert框
			//alert.accept();
			
			//点击取消按钮
			alert.dismiss();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	
	@BeforeMethod
	public void beforeMethod(){
		//driver = new FirefoxDriver(); //打开Firefox浏览器
		driver = new InternetExplorerDriver();
	}
	
	
	@AfterMethod
	public void afterMethod(){
		driver.quit(); //关闭浏览器
	}

}
