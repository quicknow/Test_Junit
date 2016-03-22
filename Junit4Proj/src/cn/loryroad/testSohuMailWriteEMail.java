package cn.loryroad;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class testSohuMailWriteEMail {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  
    driver = new FirefoxDriver();
    //Cookie ck=new Cookie(name,value,domain,path,expiry,isSecure);2017Äê3ÔÂ16ÈÕ 16:09:56
  //Cookie ck=new Cookie("Hm_lvt_51ba0423158dd0664ae016779d830e43","1458115797",".mail.sohu.com","/","SAT Mar 16 16:09:56 CST 2017");
	
	
    baseUrl = "http://www.126.com";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    Cookie ck2 = new Cookie("NTES_PASSPORT","hSZHghkQ2IE3pOVs6xV9YCyOn20hF6kPaP07ig44I1nVcceyqzgwG9tPevDnpSGja7D2qszop_TlcVbZB9.0K0rOTBeeGOkCm", ".126.com", "/", null, false);
   	driver.manage().addCookie(ck2);
  }

  @Test
  public void testSohuMailWriteEMail() throws Exception {
	
	//Cookie ck=new Cookie("NTES_PASSPORT","hSZHghkQ2IE3pOVs6xV9YCyOn20hF6kPaP07ig44I1nVcceyqzgwG9tPevDnpSGja7D2qszop_TlcVbZB9.0K0rOTBeeGOkCm");
	
	
    driver.get(baseUrl);
      
  
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