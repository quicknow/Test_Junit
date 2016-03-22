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


//测试类代码
public class TestFailCaptureScreen {
	public WebDriver driver;
	String baseUrl = "http://www.sogou.com/"; //设定访问网站的地址
	
	@Test
	public void testSearch(){
		driver.get(baseUrl+"/");
		driver.findElement(By.id("query")).sendKeys("认识你自己");
		driver.findElement(By.id("stb")).click();
		
		try{
			/*
			 * 断言页面的代码中是否存在“事在人为”这4个关键字，因为页面中没有这4个字，所以
			 * 会触发catch语句的执行，并触发截图操作
			 */
			Assert.assertTrue(driver.getPageSource().contains("事在人为"));
			System.out.println("assert 后继续执行了");
		} catch(AssertionError e){
			System.out.println("catch中的代码被执行了");
			takeTakesScreenshot(driver);
		}
	}
	
	@BeforeMethod
	public void beforeMethod(){
		
		driver = new FirefoxDriver(); //打开Firefox浏览器
		
	}
	
	@AfterMethod
	public void afterMethod(){
		driver.quit();  //关闭打开的浏览器
	}
	
	/*
	 * 在测试类中声明截图的方法，截图方法调用了时间类和文件操作类的静态方法，用来以时间格式生成目录名称和截图文件名称
	 */
	
	public void takeTakesScreenshot(WebDriver driver){
		try{
			//生成日期对象
			Date date = new Date();
			//调用DateUtil类中的方法，生成截图所在的文件夹日期名称
			String picDir="d:\\"+String.valueOf(DateUtil.getYear(date))+"-"+
			String.valueOf(DateUtil.getMonth(date))+"-"+ String.valueOf(DateUtil.getDay(date));
			if(!new File(picDir).exists()){
				FileUtil.createDir(picDir);
			}
			
			//调用DateUtil类中的方法，生成截图文件的时间名称
			String filePath= picDir+"\\"+String.valueOf(DateUtil.getHour(new Date())+"-"+String.valueOf(DateUtil.getMinute(new Date())))
					+"-"+String.valueOf(DateUtil.getSecond(new Date()))+".png";
			//进行截图，并将文件内容保存在srcFile对象中
			File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			//将截图文件内容写入到磁盘中，生成截图文件
			FileUtils.copyFile(srcFile, new File(filePath));
			
		}  catch(Exception e){
			e.printStackTrace();
		}
	}
}
