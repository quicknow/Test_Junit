package cn.gloryroad.testScript;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import static cn.gloryroad.util.KeyBoardUtil.*;
import static cn.gloryroad.util.WaitUtil.*;

public class TestSendmailWithAttachment {
	WebDriver driver;
	String baseurl;
	
	@Test
	public void testSendMailWithAttachment(){
		
		//访问被测试网址 http://mail.126.com
		driver.get("http://mail.126.com");
		
		//定位126邮箱登陆首页的用户名输入框
		WebElement userName = driver.findElement(By.id("idInput"));
		
		//定位126邮箱登陆首页的密码输入框
		WebElement passWord = driver.findElement(By.id("pwdInput"));
		
		//定位126邮箱登陆首页的登陆按钮
		WebElement loginButton = driver.findElement(By.id("loginBtn"));
		//清除用户名输入框的内容，防止缓存的内容影响测试输入
		userName.clear();
		
		userName.sendKeys("testform1");
		
		//清除密码输入框的内容，防止缓存的内容影响测试输入
		passWord.clear();
		
		passWord.sendKeys("zwb888888");
		
		//点击登陆按钮
		loginButton.click();
		
		//调用封装的显示等待函数，在页面显示退出链接后，继续执行后续代码逻辑
		waitWebElement(driver,"//a[contains(.'退出')]");
		
		//定位页面的“写信” 链接
		WebElement writeMailLink = driver.findElement(By.xpath("//*[contains(@id,'_mail_component_')]/span[contais(.,'写信')]"));
		
		//单击“写信”链接
		writeMailLink.click();
		
		//调用封装的显示等待函数，在页面显示出“收件人”的链接后，继续执行后续代码逻辑
		waitWebElement(driver,"//a[contains(.,'收件人')]");
		
		//定位写信页面的收件人输入框
		WebElement recipients = driver.findElement(By.xpath("//*[contains(@id,'_mail_emailinput_0_')]/input"));
		
		//定位写信页面的邮件主题输入框
		WebElement mailSubject = driver.findElement(By.xpath("//*[contains(@id,'_mail_input_2')]/input"));
		
		//在收件人输入框输入收件人地址，本列输入收件人自己的邮箱
		recipients.sendKeys("testform1@126.com");
		
		//在邮件主题输入框输入邮件标题
		mailSubject.sendKeys("这是一封测试邮件");
		
		/*
		 * 调用KeyBoardUtil类中的pressTabKey方法，程序会执行Tab键的操作
		 * 执行按Tab键操作后，页面的输入焦点自动切换到邮件正文的输入框
		 */
		
		pressTabKey();
		/*
		 * 调用KeyBoardutil类中的setAndctrlVclipboardData方法
		 * 模拟剪切板粘贴的操作，将自定义的字符串内容粘贴如邮件正文输入框
		 */
		setAndctrlVClipboardData("这是一封自动化发送的测试邮件正文");
		
		//定位添加附件的链接
		driver.findElement(By.xpath("//a[contais(@id,'_attachAdd')]")).click();
		//调用WaitUtil类中的sleep方法休眠0.5秒， 等待页面弹出文件选择的Window框体
		sleep(500);
		/*
		 * 调用KeyBoardUtil类中的setAndctrlVclipboardData方法
		 * 将上传文件的绝对路径字符串粘贴入文件选择框中的文件名输入框
		 */
		setAndctrlVClipboardData("c:\\a.log");
		pressEnterKey();
		
		//调用WaitUtil类中的sleep方法休眠4秒，等待附件文件上传完毕
		sleep(4000);
		/*
		 * 定位页面上的两个发送按钮，并存储到List容器中页面
		 * 由于两个发送按钮在页面中属性基本相同，所以很难只定位到唯一的发送按钮
		 * 所以使用发送按钮的文字属性将两个发送按钮同时定位，存储到List容器中，然后调用容器中的其中一个按钮，可定位唯一一个发送按钮
		 */
		
		List<WebElement> buttons = driver.findElements(By.xpath("//*[contais(@id,'_mail_button_')]/span[contais(.,'发送')]"));
		//单击容器中存储的第二个发送按钮来发送编辑好的邮件
		buttons.get(1).click();
		
		/*
		 * 调用封装的显示等待函数，在页面显示出包含关键字“_succInfo”的ID属性元素后，继续执行
		 * 后续代码逻辑
		 */
		
		waitWebElement(driver,"//*[contains(@id,'_succInfo')]");
		//断言页面中是否包含“发送成功” 的信息，以此判断邮件是否发送成功
		
		Assert.assertTrue(driver.getPageSource().contains("发送成功"));
	}
	
	@BeforeMethod
	public void beforeMethod() throws InterruptedException{
		//设定IE浏览器驱动文件的绝对路径
		System.setProperty("webdriver.ie.dirver","C:\\Python27\\IEDriverServer.exe");
		driver= new InternetExplorerDriver();
	}
	
	@AfterMethod
	public void afterMethod(){
		driver.quit();
	}
	

}
