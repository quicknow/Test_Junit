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




public class TestHandleAlert {
	
	public WebDriver driver;
	//�趨������վ�ĵ�ַ
	String baseUrl = "d:\\test\\Alert.html";

	
	@Test
	public void TestHandleAlert() {
		
		
		driver.get(baseUrl);
		
		//ʹ��Xpath��λ���������ұ�����ҳ���ϵ�Ψһ��ťԪ��
		WebElement button=driver.findElement(By.xpath("//input"));
		//������ťԪ��
		button.click();
		
		try {
			Alert alert = driver.switchTo().alert();
			
			Assert.assertEquals("����һ��alert������",alert.getText());
			
			//ʹ��Alert�����accept����������Alert���ϵġ�ȷ������ť���ر�Alert��
			alert.accept();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	
	@BeforeMethod
	public void beforeMethod(){
		//driver = new FirefoxDriver(); //��Firefox�����
		driver = new InternetExplorerDriver();
	}
	
	
	@AfterMethod
	public void afterMethod(){
		driver.quit(); //�ر������
	}

}