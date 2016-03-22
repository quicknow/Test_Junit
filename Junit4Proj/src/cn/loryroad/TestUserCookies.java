package cn.loryroad;


import java.util.Set;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestUserCookies {
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
  public void TestUserCookies() throws Exception {
	  
	Cookie ck1 = new Cookie("P_INFO","testform1@126.com|1458269760|0|mail126|00&99|gud&1458268437&mail126#gud&440300#10#0#0|&0|mail126|testform1@126.com");
	Cookie ck2 = new Cookie("S_INFO","1458269760|0|#3&20#|testform1@126.com");
	driver.manage().addCookie(ck1);
	driver.manage().addCookie(ck2);  
    driver.get(baseUrl + "/");    
    /*
    driver.findElement(By.id("idPlaceholder")).click();
    driver.findElement(By.id("idInput")).clear();
    driver.findElement(By.id("idInput")).sendKeys("testform1");
    driver.findElement(By.id("pwdPlaceholder")).click();
    driver.findElement(By.id("pwdInput")).clear();
    driver.findElement(By.id("pwdInput")).sendKeys("zwb888888");
    driver.findElement(By.xpath("//div[@id='lfAutoLogin']/b")).click();
    driver.findElement(By.id("loginBtn")).click();*/
    
    /*
    while(true){
    	
    	Thread.sleep(500);
    	
    	if(driver.getCurrentUrl().contains("http://mail.126.com/js6/main.jsp?sid=")){
    		
    		Set<Cookie> cookies=driver.manage().getCookies();
    	    Cookie newCookie = new Cookie("cookieName","cookieValue");
    	    System.out.println(String.format("name->value->Domain->path->expiry->isSecure"));
    	    
    	    for(Cookie cookie:cookies){
    	    	System.out.println(String.format("%s-> %s-> %s-> %s-> %s->%s",cookie.getName(),cookie.getValue(),cookie.getDomain(),cookie.getPath(),cookie.getExpiry(),cookie.isSecure()));
    	    }
    		
    		break;
    	}
    }
    
    Thread.sleep(1000);  */
    
    
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