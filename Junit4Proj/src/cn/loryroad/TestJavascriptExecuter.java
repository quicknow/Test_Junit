package cn.loryroad;

import java.util.regex.Pattern;


import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestJavascriptExecuter {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.sogou.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testJavascriptexecuter() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.id("query")).clear();
    driver.findElement(By.id("query")).sendKeys("javascriptexecutor单击元素");
   // driver.findElement(By.id("stb")).click();
    WebElement searchButton = driver.findElement(By.id("stb"));
    JavaScriptClick(searchButton);
    
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