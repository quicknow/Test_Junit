package cn.gloryroad;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MultipleBrowserSearchTest {

	public WebDriver driver;
	String baseUrl = "http://www.sogou.com/"; //设定访问网站的地址
	
	@Parameters("browser")
	
	@BeforeClass
	public void beforeTest(String Browser){
		
		if(Browser.equalsIgnoreCase("firefox")){			
			driver= new FirefoxDriver();
		} else if(Browser.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver","C:\\Python27\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		} else if (Browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver","C:\\Python27\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		//driver.get("http://www..com");
	}
	
	@Test
	public void testSogouSearch(){
		//打开sogou首页
		driver.get(baseUrl+"/");
		
		WebElement inputBox=driver.findElement(By.id("query"));
		Assert.assertTrue(inputBox.isDisplayed());
		inputBox.sendKeys("光荣之路自动化测试");
		
		//单击“搜索”按钮
		driver.findElement(By.id("stb")).click();
		//
		
		try{
			Thread.sleep(3000);
		} catch(InterruptedException e){
			
			e.printStackTrace();
		}
		
		Assert.assertTrue(driver.getPageSource().contains("光荣之路"));
	}
	
	@AfterClass
	public void afterTest(){
		
		//driver.quit();
	}
	
}
