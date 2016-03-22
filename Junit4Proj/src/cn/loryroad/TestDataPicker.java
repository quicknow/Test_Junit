package cn.loryroad;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestDataPicker {

	private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
	    driver = new ChromeDriver();
	    baseUrl = "http://10.128.165.111:7779/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testDataPicker() throws Exception {
		  driver.get(baseUrl + "/user/login");
		  driver.findElement(By.id("Username")).clear();
		  driver.findElement(By.id("Username")).sendKeys("admin");
		  driver.findElement(By.id("password")).clear();
		  driver.findElement(By.id("password")).sendKeys("admin");
		  driver.findElement(By.id("btn_submit")).click();
		  
		  driver.findElement(By.linkText("库存管理")).click();
		  
		  driver.findElement(By.linkText("库存查询")).click();
		  
		 /* WebElement queryButton =driver.findElement(By.xpath("//li[@id='inventoryquery']/a/span[contains(text(),'库存查询')]"));
		  highlightElement(queryButton);
		  queryButton.click();*/
		  
		  
		  
		  driver.findElement(By.id("Q_startTime")).click();		 
		  
		  Thread.sleep(1000);
		  
		  //时间选择控件是在一个iframe里面，需要做切换
		  WebElement iframe=driver.findElement(By.tagName("iframe"));
		  driver.switchTo().frame(iframe);
		  
		  driver.findElement(By.xpath("//td[@onclick='day_Click(2016,3,1);']")).click();
		  driver.switchTo().defaultContent();
		  
		  Thread.sleep(1000);
		  driver.findElement(By.id("Q_endTime")).click();		 
		  
		  Thread.sleep(1000);
		  
		  //时间选择控件是在一个iframe里面，需要做切换（iframe应该看着是一个元素）
		  WebElement iframe2=driver.findElement(By.tagName("iframe"));
		  driver.switchTo().frame(iframe2);
		  
		  driver.findElement(By.xpath("//td[@onclick='day_Click(2016,3,16);']")).click();
		  driver.switchTo().defaultContent();
		  
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//span[contains(.,'搜索')]")).click();
		  
		  /*
		  driver.findElement(By.id("Q_endTime")).click();
		  driver.findElement(By.xpath("//td[@onclick='day_Click(2016,3,14);']")).click();
		  driver.findElement(By.xpath("//a[@id='searchButton']/span/span")).click();*/

	  }
	  
	  
	  public void JavaScriptClick(WebElement element) throws Exception{
		  
		  try {
			if(element.isEnabled()&&element.isDisplayed()){
				System.out.println("使用javascriptexecuter进行点击操作");
				 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				  
			  }else {
				  System.out.println("页面上的元素无法进行单击操作");
			  }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		  	  	  	  
	  }
	  
	  //高亮显示元素的函数
	  public  void highlightElement(WebElement element){
			JavascriptExecutor js = (JavascriptExecutor) driver;
			/*
			 * 使用JavaScript 语句将传入参数的页面元素对象的背景颜色和边框颜色分别设定为黄色和红色
			 */
			js.executeScript("arguments[0].setAttribute('style',arguments[1]);",element, "background:yellow;border:2px solid red;");
		}

	  @After
	  public void tearDown() throws Exception {
	   // driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
	
}
