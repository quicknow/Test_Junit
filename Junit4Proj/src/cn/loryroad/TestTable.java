package cn.loryroad;

import java.util.List;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestTable  {

	private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
	    driver = new ChromeDriver();
	    baseUrl = "c:\\table.html";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get(baseUrl);
	  }

	  @Test
	  public void testDataPicker() throws Exception {
		  
		  //��ȡ������ҳ���еı��Ԫ�أ����洢��webTable��
		  WebElement webTable =   driver.findElement(By.xpath("//table"));
		
		  Table table = new Table(webTable);
		  
		  WebElement cell=table.getCell(3, 2);
		  
		  System.out.println(cell.getText());
		  
		  //JavaScriptClick(cell);
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
