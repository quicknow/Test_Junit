package cn.loryroad;

import static org.junit.Assert.fail;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestAjaxDivOption {
	
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
	    driver.findElement(By.id("query")).click();
	    
	    List<WebElement> suggetionOptions = driver.findElements(By.xpath("//*[@id='vl']/div[1]/ul/li"));
	    
	    
	    for(WebElement element:suggetionOptions){
	    	if(element.getText().contains("Å®ÓÑÐ¶×±ºóÀÏ8Ëê")){
	    		System.out.println(element.getText());
	    		element.click();
	    		break;
	    	}
	    }
	   // driver.findElement(By.id("stb")).click(); .//*[@id='vl']/div[1]/ul/li[6]
	    WebElement searchButton = driver.findElement(By.id("stb"));
	    
	    
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
