package com.takescreenshot;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;


//���������
public class TestFailCaptureScreen {
	public WebDriver driver;
	String baseUrl = "http://www.sogou.com/"; //�趨������վ�ĵ�ַ
	
	@Test
	public void testSearch(){
		driver.get(baseUrl+"/");
		driver.findElement(By.id("query")).sendKeys("��ʶ���Լ�");
		driver.findElement(By.id("stb")).click();
		
		try{
			/*
			 * ����ҳ��Ĵ������Ƿ���ڡ�������Ϊ����4���ؼ��֣���Ϊҳ����û����4���֣�����
			 * �ᴥ��catch����ִ�У���������ͼ����
			 */
			Assert.assertTrue(driver.getPageSource().contains("������Ϊ"));
			System.out.println("assert �����ִ����");
		} catch(AssertionError e){
			System.out.println("catch�еĴ��뱻ִ����");
			takeTakesScreenshot(driver);
		}
	}
	
	@BeforeMethod
	public void beforeMethod(){
		
		driver = new FirefoxDriver(); //��Firefox�����
		
	}
	
	@AfterMethod
	public void afterMethod(){
		driver.quit();  //�رմ򿪵������
	}
	
	/*
	 * �ڲ�������������ͼ�ķ�������ͼ����������ʱ������ļ�������ľ�̬������������ʱ���ʽ����Ŀ¼���ƺͽ�ͼ�ļ�����
	 */
	
	public void takeTakesScreenshot(WebDriver driver){
		try{
			//�������ڶ���
			Date date = new Date();
			//����DateUtil���еķ��������ɽ�ͼ���ڵ��ļ�����������
			String picDir="d:\\"+String.valueOf(DateUtil.getYear(date))+"-"+
			String.valueOf(DateUtil.getMonth(date))+"-"+ String.valueOf(DateUtil.getDay(date));
			if(!new File(picDir).exists()){
				FileUtil.createDir(picDir);
			}
			
			//����DateUtil���еķ��������ɽ�ͼ�ļ���ʱ������
			String filePath= picDir+"\\"+String.valueOf(DateUtil.getHour(new Date())+"-"+String.valueOf(DateUtil.getMinute(new Date())))
					+"-"+String.valueOf(DateUtil.getSecond(new Date()))+".png";
			//���н�ͼ�������ļ����ݱ�����srcFile������
			File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			//����ͼ�ļ�����д�뵽�����У����ɽ�ͼ�ļ�
			FileUtils.copyFile(srcFile, new File(filePath));
			
		}  catch(Exception e){
			e.printStackTrace();
		}
	}
}
