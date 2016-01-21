package cn.loryroad;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestSendMail {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://www.126.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testTeatAddPerson() throws Exception {
	  	driver.get(baseUrl + "/");
	    driver.findElement(By.id("idInput")).click();
	    driver.findElement(By.id("idInput")).sendKeys("testform1");
	    
	    driver.findElement(By.id("pwdInput")).clear();	    
	    driver.findElement(By.id("pwdInput")).sendKeys("zwb888888");
	    driver.findElement(By.id("loginBtn")).click();
	    
	    //driver.findElement(By.cssSelector("#_mail_component_61_61 > span.oz0")).click();
	    
	  
	    
	    //driver.findElement(By.xpath("//*[contains(@id,'_mail_component_')]/span[contains(.,'写信')]")).click();	    
	    driver.findElement(By.xpath("html/body/div[1]/nav/div[1]/ul/li[2]/span[2]")).click();
	    

	    //定位收件人
	    //driver.findElement(By.xpath("//section[@class='tH0']/header/div[1]/div[1]/div/div[2]/div/input")).sendKeys("1123");
	    
	    driver.findElement(By.xpath("//*[contains(@id,'_mail_emailinput_0_')]/input")).sendKeys("1123@qq.com");
	    
	    //定位标题输入框  //*[contains(@id,'_mail_input_2')]/input
	    //driver.findElement(By.xpath("//section[@class='tH0']/header/div[2]/div[1]/div/div/input")).sendKeys("1123");
	    driver.findElement(By.xpath("//*[contains(@id,'_mail_input_2')]/input")).sendKeys("1123");
	    //Thread.sleep(2000);
	   // driver.switchTo().frame("1453259606042_attachUpload");
	    
	   //driver.findElement(By.xpath("//section[@class='tH0']/div[3]/div[1]/a[1]")).click();
	    //driver.findElement(By.cssSelector("input[class='O0']"));
	    //driver.findElement(By.xpath("//div[contains(@id,'_attachBrowser')]/input")).click();
	    driver.findElement(By.xpath("//a[contains(@id,'_attachAdd')]")).click();
	    												
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

