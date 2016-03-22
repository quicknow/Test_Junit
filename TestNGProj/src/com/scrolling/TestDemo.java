package com.scrolling;

import org.openqa.selenium.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestDemo {

	WebDriver driver;
	String baseUrl;
	
	@BeforeMethod
	public void beforeMethod(){
		//������ַΪsogou��ҳ����Ƶ������ҳ
		baseUrl="http://v.sogou.com";
		//�趨����IE����������������ڵĴ���λ�ã������Ϊϵͳ����ֵ
		driver = new InternetExplorerDriver();
		driver.get(baseUrl);		
	}
	
	//priority=1 ��ʾ���������Ե�һ���ȼ�����
	@Test(priority=1)
	public void scrollingToBottomofAPage(){
		//ʹ��JavaScript��scrollTo������document.body.scrollHeight����
		//��ҳ��Ĺ�����������ҳ������·�
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
		//ͣ��3�룬�����˹���֤�������Ƿ񻬶���ָ����λ�á����ݲ�����Ҫ����ע�������ͣ�ٴ���
		try{
			Thread.sleep(3000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	//priority=2��ʾ���������Եڶ����ȼ�����
	@Test(priority=2)
	public void scrollingToElementofAPage(){
		//����������Ƶҳ���е�IDֵΪmain_frame��frameҳ��
		driver.switchTo().frame("main_frame");
		//��λframeҳ���е�h2��ǩԪ�أ��ұ�ǩ����Ϊ�����Ӿ���ࡱ
		WebElement element = driver.findElement(By.xpath("//h2[text()='���Ӿ����']"));
		
		//ʹ��JavaScript��scrollIntoView()������������������ҳ���ָ��Ԫ��λ��
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
		
		try{
			Thread.sleep(3000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//priority =3 ��ʾ���������Ե������ȼ�����
	@Test(priority=3)
	public void scrollingByCoordinatesofAPage(){
		//ʹ��JavaScript��scrollTo������ʹ��0��800�ĺ����������
		//��ҳ��Ĺ����������»�800������
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,800)");
		//ͣ��3�룬�����˹���֤�������Ƿ񻬶���ָ����λ�á����ݲ�����Ҫ����ע�������ͣ�ٴ���
		try{
			Thread.sleep(3000);			
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	@AfterMethod
	public void afterMethod(){		
		driver.quit();
	}
	
}
