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
	//设定访问网站的地址
	String baseUrl = "http://www.w3school.com.cn/tiy/loadtext.asp?f=html5_video_simple";

	
	@Test
	public void testVideoPlayer() throws InterruptedException, IOException{
		//定义页面截图文件对象，用于后面的屏幕截图存储
		File captureScreenFile=null;
		//访问HTML5实现播放器的网页页面
		driver.get(baseUrl);
		//打印出HTML5视频播放器页面的源代码，供参考
		System.out.println(driver.getPageSource());
		
		//获取页面中的video标签
		WebElement videoPlayer = driver.findElement(By.tagName("video"));
		
		//声明一个JavascriptExecutor对象
		JavascriptExecutor javascriptExecutor=(JavascriptExecutor) driver;
		
		//使用JavascriptExecutor 对象执行JavaScript语句，通过播放器内部的currentSrc属性获取视频文件的网络存储地址
		String videoSrc = (String) javascriptExecutor.executeScript("return arguments[0].currentSrc;", videoPlayer);
		
		//输出视频文件的网络存储地址
		System.out.println(videoSrc);
		
		//断言视频网络地址是否符合期望
		Assert.assertEquals("http://www.w3school.com.cn/i/movie.ogg", videoSrc);
		
		//使用JavascriptExecutor对象执行JavaScript语句，通过播放器内部的
		//duration属性获取视频文件的播放时长
		Double videoDuration =(Double)javascriptExecutor.executeScript("return arguments[0].duration", videoPlayer);
		
		//输出视频的播放时长
		System.out.println(videoDuration.intValue());
		
		//等待5s让视频加载完成
		Thread.sleep(5000);
		
		//使用JavascriptExecutor对象执行JavaScript 语句，通过调用播放器内部的play函数来播放影片
		javascriptExecutor.executeScript("return arguments[0].play()", videoPlayer);
		
		Thread.sleep(2000);
		
		//播放2秒后，使用JavascriptExecutor对象执行JavaScript语句，通过调用播放器内部的pause函数来暂停播放影片
		javascriptExecutor.executeScript("return arguments[0].pause();", videoPlayer);
		
		//暂停3秒验证暂停操作是否生效
		Thread.sleep(3000);
		
		//将暂停视频播放后的页面进行截屏，并保存为d盘上的videoPlay_pause.jpg文件
		captureScreenFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(captureScreenFile, new File("d:\\videoPlay_pause.jpg"));
		
	}
	
	
	@BeforeMethod
	public void beforeMethod(){
		driver = new FirefoxDriver(); //打开Firefox浏览器
	}
	
	
	@AfterMethod
	public void afterMethod(){
		driver.quit(); //关闭浏览器
	}

}
