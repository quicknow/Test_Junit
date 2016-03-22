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
		  
		  driver.findElement(By.linkText("������")).click();
		  
		  driver.findElement(By.linkText("����ѯ")).click();
		  
		 /* WebElement queryButton =driver.findElement(By.xpath("//li[@id='inventoryquery']/a/span[contains(text(),'����ѯ')]"));
		  highlightElement(queryButton);
		  queryButton.click();*/
		  
		  
		  
		  driver.findElement(By.id("Q_startTime")).click();		 
		  
		  Thread.sleep(1000);
		  
		  //ʱ��ѡ��ؼ�����һ��iframe���棬��Ҫ���л�
		  WebElement iframe=driver.findElement(By.tagName("iframe"));
		  driver.switchTo().frame(iframe);
		  
		  driver.findElement(By.xpath("//td[@onclick='day_Click(2016,3,1);']")).click();
		  driver.switchTo().defaultContent();
		  
		  Thread.sleep(1000);
		  driver.findElement(By.id("Q_endTime")).click();		 
		  
		  Thread.sleep(1000);
		  
		  //ʱ��ѡ��ؼ�����һ��iframe���棬��Ҫ���л���iframeӦ�ÿ�����һ��Ԫ�أ�
		  WebElement iframe2=driver.findElement(By.tagName("iframe"));
		  driver.switchTo().frame(iframe2);
		  
		  driver.findElement(By.xpath("//td[@onclick='day_Click(2016,3,16);']")).click();
		  driver.switchTo().defaultContent();
		  
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//span[contains(.,'����')]")).click();
		  
		  /*
		  driver.findElement(By.id("Q_endTime")).click();
		  driver.findElement(By.xpath("//td[@onclick='day_Click(2016,3,14);']")).click();
		  driver.findElement(By.xpath("//a[@id='searchButton']/span/span")).click();*/

	  }
	  
	  
	  public void JavaScriptClick(WebElement element) throws Exception{
		  
		  try {
			if(element.isEnabled()&&element.isDisplayed()){
				System.out.println("ʹ��javascriptexecuter���е������");
				 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				  
			  }else {
				  System.out.println("ҳ���ϵ�Ԫ���޷����е�������");
			  }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		  	  	  	  
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
