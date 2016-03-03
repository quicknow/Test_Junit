package cn.gloryroad.configuration;

import static cn.gloryroad.util.WaitUitl.waitWebElement;

import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import cn.gloryroad.testScript.TestSuiteByExcel;
import cn.gloryroad.util.KeyBoardUtil;
import cn.gloryroad.util.Log;
import cn.gloryroad.util.ObjectMap;
import cn.gloryroad.util.WaitUitl;

public class KeyWordsAction {
	//声明静态WebDriver 对象，用于在此类中Driver的操作
	public static WebDriver driver;
	//声明存储定位表达式配置文件的ObjectMap对象
	private static ObjectMap objectMap = new ObjectMap(Constants.Path_ConfigurationFile);
	
	static{
		//指定Log4j配置文件为log4j.xml
		DOMConfigurator.configure("log4j.xml");
	}
	
	
	/*
	 * 此方法的名称对应Excel文件“关键字”列中的open_browser关键字
	 * Excel 文件“操作值”列中的内容用于指定测试用例用何种浏览器运行测试用例
	 * 。ie表示启动IE浏览器运行测试用例，firefox表示启动火狐浏览器，chrome
	 * 表示启动chrome浏览器进行测试	 
	 */

	public static void open_browser(String string,String browsername){
		
		if(browsername.equals("ie")){
			System.setProperty("webdriver.ie.driver", "C:\\Python27\\IEDriverServer.exe");
			driver= new InternetExplorerDriver();
			Log.info("IE浏览器实例已经声明");
		} else if(browsername.equals("firefox")){
			driver = new FirefoxDriver();
			Log.info("火狐浏览器实例已经声明");
		} else {
			System.setProperty("webdriver.chrome.driver","C:\\Python27\\chromedriver.exe");
			driver= new ChromeDriver();
			Log.info("chrome浏览器实例已经声明");
		}
	}
	
	//此方法的名称对应Excel文件“关键字”列中的navigate关键字
	//读取Excel文件“操作值”列中的网址内容作为浏览器访问的网址
	public static void navigate(String string,String url){
		
		driver.get(url);
		Log.info("浏览器访问网址"+url);
	}
	
	//此方法的名称对应Excel文件“关键字”列中的input 关键字
	//读取Excel文件“操作值”列中的邮箱用户名称，作为登录用户名的输入内容
	public static void input(String locatorExpression, String inputString){
		
		//System.out.println("收到的参数值："+userName);
		
		try{
			driver.findElement(objectMap.getLocator(locatorExpression)).clear();
			Log.info("清除用户名输入框的所有内容");
			driver.findElement(objectMap.getLocator(locatorExpression)).sendKeys(inputString);
			Log.info("在"+locatorExpression+"输入框中输入："+inputString);
		}catch(Exception e){
			TestSuiteByExcel.testResult=false;
			Log.info("在"+locatorExpression+"输入框中输入：“"+inputString+"”时出现异常,具体异常信息："+e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	
	/*
	 * 此方法的名称对应Excel文件“关键字”列中的click关键字
	 * 实现单击登录按钮操作，参数string 本身并不会作为操作的输入值，设定一个
	 * 无用的函数参数仅仅为了统一反射方法的调用方式(均传入一个参数)
	 */
	
	public static void click(String locatorExprssion, String string){
		try{
			driver.findElement(objectMap.getLocator(locatorExprssion)).click();
			Log.info("单击"+locatorExprssion+"页面元素成功");
		} catch(Exception e){
			TestSuiteByExcel.testResult=false;
			Log.info("单击"+locatorExprssion+"页面元素失败，具体异常信息："+e.getMessage());
			e.printStackTrace();
		}
	}
	
	/*
	 * 此方法的名称对应Excel文件“关键字”列中的WaitFor_Element关键字
	 * 用于显式等待页面元素出现在页面中。函数读取ExcelW文件“操作值”列中的表达式作为函数参数，objectMap对象的getLocator方法
	 * 会根据函数参数值在配置文件中查找key值对应的定位表达式
	 * 
	 */
	
	public static void WaitFor_Element(String locatorExpression,String string){
		
		try{
			//调用封装的waitWebElement函数显示等待页面元素是否出现
			waitWebElement(driver,objectMap.getLocator(locatorExpression));
			Log.info("显式等待元素出现成功，元素是"+locatorExpression);
		} catch(Exception e){
			TestSuiteByExcel.testResult=false;
			Log.info("显示等待元素时出现异常，具体异常信息："+e.getMessage());
			e.printStackTrace();
		}
		
	}		
	
	
	//此方法的名称对应Excel文件“关键字”列中的press_Tab关键字
	//用于按Tab键的操作
	
	public static void press_Tab(String string1,String string2){
		
		try{			
			Thread.sleep(2000);
			//调用KeyBoardUtil类的封装方法pressTabKey
			KeyBoardUtil.pressTabKey();
			Log.info("按tab键成功");
		} catch(Exception e){
			TestSuiteByExcel.testResult=false;
			Log.info("按tab键时出现异常，具体异常信息："+e.getMessage());
			e.printStackTrace();
		}
	}
	
	//此方法的名称对应Exce文件“关键字”列中的paste_mailContent关键字
	//通过剪切板粘贴的方式，在指定输入框再输入字符，列如，邮件正文
	public static void pasteString(String string,String pasteContent){
		try{	
			    
			    Thread.sleep(6000);
				KeyBoardUtil.setAndctrlVClipboardData(pasteContent);				
				System.out.println("已结执行了粘贴动作");
				Log.info("成功粘贴邮件正文："+pasteContent);
			} catch(Exception e){
				TestSuiteByExcel.testResult=false;
				Log.info("在输入框粘贴内容时出现异常，具体异常信息："+e.getMessage());
				e.printStackTrace();
			}
			
	}
	

	
	//此方法的名称对应Excel文件“关键字”列中的press_enter关键字
	//用于按Enter键
	public static void press_enter(String string1,String String2){
		try{
			KeyBoardUtil.pressEnterKey();
			Log.info("按键Enter键成功");
		} catch(Exception e){
			TestSuiteByExcel.testResult=false;
			Log.info("按Enter键时出现异常，具体异常信息："+e.getMessage());
			e.printStackTrace();
		}
	}
	
	//此方法的名称对应Excel文件“关键字”列中的sleep关键字
	//用于等待操作，暂停几秒，函数参数是以毫秒为单位的等待时间
	public static void sleep(String string,String sleepTime){
		
		try{
			WaitUitl.sleep(Integer.parseInt(sleepTime));
			Log.info("休眠"+Integer.parseInt(sleepTime)/1000+"秒成功");
		} catch(Exception e){
			TestSuiteByExcel.testResult=false;
			Log.info("线程休眠时出现异常，具体异常信息："+e.getMessage());
			e.printStackTrace();
		}
	}
	
	//此方法的名称对应Excel文件“关键字”列中的click_sendMailButton关键字
	//用于单击邮件发送按钮
	public static void click_sendMailButton(String locatorExpression,String string){
		
		try{
			/*
			 * 页面上有两个发送按钮可以执行发送功能，为了使用Xpath匹配方便，
			 * 同时匹配了两个发送按钮，并存储在list容器中，随便取出一个
			 * 按钮对象来完成单击发送邮件的操作
			 */
			
			List<WebElement> buttons = driver.findElements(objectMap.getLocator(locatorExpression));
			
			buttons.get(0).click();
			Log.info("单击发送邮件按钮成功");
		} catch(Exception e){
			TestSuiteByExcel.testResult=false;
			Log.info("单击发送邮件按钮时出现异常，具体异常信息："+e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	//此方法的名称对应Excel文件“关键字”列中的Assert_String关键字
	//用于完成断言的操作，函数参数为断言的文字内容
	
	public static void Assert_String(String string,String assertString){
		
		try{
			Assert.assertTrue(driver.getPageSource().contains(assertString));
			Log.info("成功断言关键字“"+assertString+"“");
		} catch(AssertionError e){
			TestSuiteByExcel.testResult=false;
			Log.info("出现断言失败，具体断言失败信息："+e.getMessage());
			System.out.println("断言失败");
		}
	}
	
	
	//此方法的名称对应Excel文件“关键字”列中的close_browser关键字
	//用于关闭浏览器的操作
	
	public static void close_browser(String string1,String string2){
		
		try{
			System.out.println("浏览器关闭函数被执行");
			Log.info("关闭浏览器窗口");
			driver.quit();
		} catch(Exception e){
			TestSuiteByExcel.testResult=false;
			Log.info("关闭浏览器出现异常，具体异常信息："+e.getMessage());
			e.printStackTrace();
		}
	}
	
	
}
