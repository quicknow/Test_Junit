package cn.loryroad;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TeatAddPerson {
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
    driver.findElement(By.id("idInput")).clear();
    driver.findElement(By.id("idInput")).sendKeys("testform1");
    driver.findElement(By.id("pwdInput")).clear();
    driver.findElement(By.id("pwdInput")).sendKeys("zwb888888");
    driver.findElement(By.id("loginBtn")).click();
    driver.findElement(By.id("_mail_tabitem_1_39text")).click();
   // driver.findElement(By.cssSelector("#_mail_button_14_227 > span.nui-btn-text")).click();
    
    driver.findElement(By.xpath("//span[contains(text(),'新建联系人')]")).click();
    //driver.findElement(By.cssSelector("#_mail_input_5_248 > input.nui-ipt-input")).clear();
    //driver.findElement(By.cssSelector("#_mail_input_5_248 > input.nui-ipt-input")).sendKeys("testadd");
    
    driver.findElement(By.xpath("//dt[contains(text(),'姓名')]/parent::dl/dd/div/input")).sendKeys("testman2");
    
    driver.findElement(By.xpath("//div[@id='iaddress_MAIL_wrap']/dl/dd/div/input")).sendKeys("6665@qq.com");
    
    driver.findElement(By.xpath("//div[@id='iaddress_TEL_wrap']/dl/dd/div/input")).sendKeys("15712772089");
    
    driver.findElement(By.xpath("//div[@class='nui-msgbox-ft-btns']/div/span")).click();
 
  }

  @After
  public void tearDown() throws Exception {
    //driver.quit();
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
