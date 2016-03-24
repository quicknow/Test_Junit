package com.testHTML5VideoPlayer;

import java.io.File;
import java.io.IOException;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;



public class TestHTML5VideoPlayer {
	
	public WebDriver driver;
	//�趨������վ�ĵ�ַ
	String baseUrl = "http://www.w3school.com.cn/tiy/loadtext.asp?f=html5_video_simple";

	
	@Test
	public void testVideoPlayer() throws InterruptedException, IOException{
		//����ҳ���ͼ�ļ��������ں������Ļ��ͼ�洢
		File captureScreenFile=null;
		//����HTML5ʵ�ֲ���������ҳҳ��
		driver.get(baseUrl);
		//��ӡ��HTML5��Ƶ������ҳ���Դ���룬���ο�
		System.out.println(driver.getPageSource());
		
		//��ȡҳ���е�video��ǩ
		WebElement videoPlayer = driver.findElement(By.tagName("video"));
		
		//����һ��JavascriptExecutor����
		JavascriptExecutor javascriptExecutor=(JavascriptExecutor) driver;
		
		//ʹ��JavascriptExecutor ����ִ��JavaScript��䣬ͨ���������ڲ���currentSrc���Ի�ȡ��Ƶ�ļ�������洢��ַ
		String videoSrc = (String) javascriptExecutor.executeScript("return arguments[0].currentSrc;", videoPlayer);
		
		//�����Ƶ�ļ�������洢��ַ
		System.out.println(videoSrc);
		
		//������Ƶ�����ַ�Ƿ��������
		Assert.assertEquals("http://www.w3school.com.cn/i/movie.ogg", videoSrc);
		
		//ʹ��JavascriptExecutor����ִ��JavaScript��䣬ͨ���������ڲ���
		//duration���Ի�ȡ��Ƶ�ļ��Ĳ���ʱ��
		Double videoDuration =(Double)javascriptExecutor.executeScript("return arguments[0].duration", videoPlayer);
		
		//�����Ƶ�Ĳ���ʱ��
		System.out.println(videoDuration.intValue());
		
		//�ȴ�5s����Ƶ�������
		Thread.sleep(5000);
		
		//ʹ��JavascriptExecutor����ִ��JavaScript ��䣬ͨ�����ò������ڲ���play����������ӰƬ
		javascriptExecutor.executeScript("return arguments[0].play()", videoPlayer);
		
		Thread.sleep(2000);
		
		//����2���ʹ��JavascriptExecutor����ִ��JavaScript��䣬ͨ�����ò������ڲ���pause��������ͣ����ӰƬ
		javascriptExecutor.executeScript("return arguments[0].pause();", videoPlayer);
		
		//��ͣ3����֤��ͣ�����Ƿ���Ч
		Thread.sleep(3000);
		
		//����ͣ��Ƶ���ź��ҳ����н�����������Ϊd���ϵ�videoPlay_pause.jpg�ļ�
		captureScreenFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(captureScreenFile, new File("d:\\videoPlay_pause.jpg"));
		
	}
	
	
	@BeforeMethod
	public void beforeMethod(){
		driver = new FirefoxDriver(); //��Firefox�����
	}
	
	
	@AfterMethod
	public void afterMethod(){
		driver.quit(); //�ر������
	}

}
