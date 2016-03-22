package cn.loryroad;

import cn.loryroad.*;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

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
	    
	  
	    
	    //driver.findElement(By.xpath("//*[contains(@id,'_mail_component_')]/span[contains(.,'д��')]")).click();	    
	    driver.findElement(By.xpath("html/body/div[1]/nav/div[1]/ul/li[2]/span[2]")).click();
	    

	    //��λ�ռ���
	    //driver.findElement(By.xpath("//section[@class='tH0']/header/div[1]/div[1]/div/div[2]/div/input")).sendKeys("1123");
	    
	    driver.findElement(By.xpath("//*[contains(@id,'_mail_emailinput_0_')]/input")).sendKeys("1123@qq.com");
	    

	    Thread.sleep(500);
	    //�ʼ�������������
	    driver.findElement(By.xpath("//div[contains(@id,'_mail_input') and (@aria-label='�ʼ�����������������ʼ�����')]/input")).sendKeys("��������");
	    
	    
	    Thread.sleep(500);
	    TestRob.PressTab();
	    
	    Thread.sleep(500);
	    TestRob.Paste("hi,�ֵܽ��Ǯ���ã�");	  

	    
	   driver.findElement(By.xpath("//a[contains(@id,'_attachAdd')]")).click();
	    
	    /*
	    Thread.sleep(500);
	    (new TestRob()).Paste("c:\\a.log");
	    
	    (new TestRob()).PressEnter();
	    
	    //(new TestRob()).PressEnter();*/
	    
	    Thread.sleep(2000);    	    
	  
	    
	    Runtime.getRuntime().exec("F:/selenium_java/Test_Junit/Junit4Proj/src/cn/loryroad/mail_uploadFile.exe");	    

	    Thread.sleep(1000);
	    WebElement submitButton = driver.findElement(By.xpath("//div[contains(@id,'_mail_button_')]/span[contains(.,'����')]"));
	    highlightElement(submitButton);
	    
	    driver.findElement(By.xpath("//div[contains(@id,'_mail_button_')]/span[contains(.,'����')]")).click(); //ע������span[contains(text(),'����')]������
	    
	    //�ϴ��˸������ᷢ�ͣ����س��ſ���
	    TestRob.PressEnter();    
	  
  }
  
  //������ʾԪ�صĺ���
  public  void highlightElement(WebElement element){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		/*
		 * ʹ��JavaScript ��佫���������ҳ��Ԫ�ض���ı�����ɫ�ͱ߿���ɫ�ֱ��趨Ϊ��ɫ�ͺ�ɫ
		 */
		js.executeScript("arguments[0].setAttribute('style',arguments[1]);",element, "background:yellow;border:2px solid red;");
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

