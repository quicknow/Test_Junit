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
		//测试网址为sogou首页的视频搜索首页
		baseUrl="http://v.sogou.com";
		//设定连接IE浏览器驱动程序所在的磁盘位置，并添加为系统属性值
		driver = new InternetExplorerDriver();
		driver.get(baseUrl);		
	}
	
	//priority=1 表示测试用例以第一优先级运行
	@Test(priority=1)
	public void scrollingToBottomofAPage(){
		//使用JavaScript的scrollTo函数和document.body.scrollHeight参数
		//将页面的滚动条滑动到页面的最下方
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
		//停顿3秒，用于人工验证滚动条是否滑动到指定的位置。根据测试需要，可注释下面的停顿代码
		try{
			Thread.sleep(3000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	//priority=2表示测试用例以第二优先级运行
	@Test(priority=2)
	public void scrollingToElementofAPage(){
		//进入搜索视频页面中的ID值为main_frame的frame页面
		driver.switchTo().frame("main_frame");
		//定位frame页面中的h2标签元素，且标签文字为“电视剧分类”
		WebElement element = driver.findElement(By.xpath("//h2[text()='电视剧分类']"));
		
		//使用JavaScript的scrollIntoView()函数将滚动条滑动到页面的指定元素位置
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
		
		try{
			Thread.sleep(3000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//priority =3 表示测试用例以第三优先级运行
	@Test(priority=3)
	public void scrollingByCoordinatesofAPage(){
		//使用JavaScript的scrollTo函数，使用0和800的横纵坐标参数
		//将页面的滚动条纵向下滑800个像素
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,800)");
		//停顿3秒，用于人工验证滚动条是否滑动到指定的位置。根据测试需要，可注释下面的停顿代码
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
