package cn.gloryroad.configuration;

import static cn.gloryroad.util.WaitUitl.waitWebElement;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import cn.gloryroad.util.KeyBoardUtil;
import cn.gloryroad.util.ObjectMap;
import cn.gloryroad.util.WaitUitl;

public class KeyWordsAction {
	//声明静态WebDriver 对象，用于在此类中Driver的操作
	public static WebDriver driver;
	//声明存储定位表达式配置文件的ObjectMap对象
	private static ObjectMap objectMap = new ObjectMap("F:\\selenium_java\\Test_Junit\\KeyWordsFrameWork\\objectMap.properties");
	/*
	 * 此方法的名称对应Excel文件“关键字”列中的open_browser关键字
	 * Excel 文件“操作值”列中的内容用于指定测试用例用何种浏览器运行测试用例
	 * 。ie表示启动IE浏览器运行测试用例，firefox表示启动火狐浏览器，chrome
	 * 表示启动chrome浏览器进行测试	 
	 */

	public static void open_browser(String browsername){
		
		if(browsername.equals("ie")){
			System.setProperty("webdriver.ie.driver", "C:\\Python27\\IEDriverServer.exe");
			driver= new InternetExplorerDriver();
		} else if(browsername.equals("firefox")){
			driver = new FirefoxDriver();
		} else {
			System.setProperty("webdriver.chrome.driver","C:\\Python27\\chromedriver.exe");
			driver= new ChromeDriver();
		}
	}
	
	//此方法的名称对应Excel文件“关键字”列中的navigate关键字
	//读取Excel文件“操作值”列中的网址内容作为浏览器访问的网址
	public static void navigate(String url){
		
		driver.get(url);
	}
	
	//此方法的名称对应Excel文件“关键字”列中的input_userName 关键字
	//读取Excel文件“操作值”列中的邮箱用户名称，作为登录用户名的输入内容
	public static void input_userName(String userName){
		
		System.out.println("收到的参数值："+userName);
		
		try{
			driver.findElement(objectMap.getLocator("login.username")).clear();
			driver.findElement(objectMap.getLocator("login.username")).sendKeys(userName);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//此方法的名称对应Excel文件“关键字”列中的input_passWord关键字
	//读取Excel文件“操作值”列中的邮箱密码，作为登录密码的输入内容
	
	public static void input_passWord(String password) throws Exception{
		
		try{
			driver.findElement(objectMap.getLocator("login.password")).clear();
			driver.findElement(objectMap.getLocator("login.password")).sendKeys(password);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	/*
	 * 此方法的名称对应Excel文件“关键字”列中的click_login关键字
	 * 实现单击登录按钮操作，参数string 本身并不会作为操作的输入值，设定一个
	 * 无用的函数参数仅仅为了统一反射方法的调用方式(均传入一个参数)
	 */
	
	public static void click_login(String string){
		try{
			driver.findElement(objectMap.getLocator("login.button")).click();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*
	 * 此方法的名称对应Excel文件“关键字”列中的WaitFor_Element关键字
	 * 用于显式等待页面元素出现在页面中。函数读取ExcelW文件“操作值”列中的表达式作为函数参数，objectMap对象的getLocator方法
	 * 会根据函数参数值在配置文件中查找key值对应的定位表达式
	 * 
	 */
	
	public static void WaitFor_Element(String xpathExpression){
		
		try{
			//调用封装的waitWebElement函数显示等待页面元素是否出现
			waitWebElement(driver,objectMap.getLocator(xpathExpression));	
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	//此方法的名称对应Excel文件“关键字”列中的click_writeLetterLink关键字
	//用于单击写信链接
	public static void click_writeLetterLink(String string){
		
		try{
			driver.findElement(objectMap.getLocator("homepage.writeLetterLink")).click();
		} catch(Exception e){
			e.printStackTrace();
		}	
	}
	
	
	//此方法的名称对应Excel文件“关键字”列中的input_recipients关键字
	//用于在收件人输入框中输入指定的收件人信息，函数参数recipients为收件人信息
	public static void input_recipients(String recipients){
		
		try{
			driver.findElement(objectMap.getLocator("writemailpage.recipients")).sendKeys(recipients);;
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	//此方法的名称对应Excel文件“关键字”列中的input_mailSubject关键字
	//用于在邮件标题输入框中输入指定的字符串，函数参数mailSubject为输入内容
	public static void input_mailSubject(String mailSubject){
		
		try{
			driver.findElement(objectMap.getLocator("writemailpage.mailsubject")).sendKeys(mailSubject);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//此方法的名称对应Excel文件“关键字”列中的press_Tab关键字
	//用于按Tab键的操作
	
	public static void press_Tab(String string){
		
		try{
			
			Thread.sleep(2000);
			//调用KeyBoardUtil类的封装方法pressTabKey
			KeyBoardUtil.pressEnterKey();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//此方法的名称对应Exce文件“关键字”列中的paste_mailContent关键字
	//通过剪切板粘贴的方式，在指定输入框再输入字符，列如，邮件正文
	public static void paste_mailContent(String mailContent){
		try{			
				KeyBoardUtil.setAndctrlVClipboardData(mailContent);
			} catch(Exception e){
				e.printStackTrace();
			}
			
	}
	
	//此方法的名称对应Excel文件“关键字”列中的click_addAttachment关键字
	//用于单击添加附件的按钮
	public static void click_addAttachment(String string){
		
		try{
			driver.findElement(objectMap.getLocator("writemailpage.addattachementlink")).click();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	//此方法的名称对应Excel文件“关键字”列中的paste_uploadFileName关键字
	//通过剪切板粘贴的方式，在文件上传框体的文件名输入框中输入要上传文件的路径和名称
	public static void paste_uploadFileName(String uploadFileName){
		try{
			KeyBoardUtil.setAndctrlVClipboardData(uploadFileName);
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	//此方法的名称对应Excel文件“关键字”列中的press_enter关键字
	//用于按Enter键
	public static void press_enter(String string){
		try{
			KeyBoardUtil.pressEnterKey();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//此方法的名称对应Excel文件“关键字”列中的sleep关键字
	//用于等待操作，暂停几秒，函数参数是以毫秒为单位的等待时间
	public static void sleep(String sleepTime){
		
		try{
			WaitUitl.sleep(Integer.parseInt(sleepTime));
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//此方法的名称对应Excel文件“关键字”列中的click_sendMailButton关键字
	//用于单击邮件发送按钮
	public static void click_sendMailButton(String string){
		
		try{
			/*
			 * 页面上有两个发送按钮可以执行发送功能，为了使用Xpath匹配方便，
			 * 同时匹配了两个发送按钮，并存储在list容器中，随便取出一个
			 * 按钮对象来完成单击发送邮件的操作
			 */
			
			List<WebElement> buttons = driver.findElements(objectMap.getLocator("writemailpage.sendmilbuttons"));
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	//此方法的名称对应Excel文件“关键字”列中的Assert_String关键字
	//用于完成断言的操作，函数参数为断言的文字内容
	
	public static void Assert_String(String assertString){
		
		try{
			Assert.assertTrue(driver.getPageSource().contains(assertString));
		} catch(AssertionError e){
			System.out.println("断言失败");
		}
	}
	
	
	//此方法的名称对应Excel文件“关键字”列中的close_browser关键字
	//用于关闭浏览器的操作
	
	public static void close_browser(String string){
		
		try{
			System.out.println("浏览器关闭函数被执行");
			driver.quit();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
}
