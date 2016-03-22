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
		  
		  //获取被测试页面中的表格元素，并存储到webTable中
		  WebElement webTable =   driver.findElement(By.xpath("//table"));
		
		  Table table = new Table(webTable);
		  
		  WebElement cell=table.getCell(3, 2);
		  
		  System.out.println(cell.getText());
		  
		  //JavaScriptClick(cell);
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
