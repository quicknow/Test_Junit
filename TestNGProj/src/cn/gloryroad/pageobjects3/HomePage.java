package cn.gloryroad.pageobjects3;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;
	//@FindBy(xpath="//*[contains(@id,'_mail_component_')]/span[contains(.,'写信')]")
	@FindBy(xpath="//*[contains(@id,'_mail_component_')]/span[2]")
	//@FindBy(xpath="//*[@id='_mail_component_61_61']/span[2]")
	public WebElement wirteMaillink;
	//@FindBy(xpath="//*[contains(@id,'_mail_button_')]/span[contains(.,'发送')]")
	@FindBy(xpath="//*[@id='_mail_button_2_189']/span[2]")
	public WebElement sendMailbutton;
	public HomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public void writemail() throws InterruptedException{
		Thread.sleep(1500);
		wirteMaillink.click();
		Thread.sleep(5000);
		SetAndctrlVClipboardData("testman1978@126.com");
		pressTabKey();
		SetAndctrlVClipboardData("邮件标题");
		pressTabKey();
		SetAndctrlVClipboardData("邮件正文");
		sendMailbutton.click();
	}
	
	public String getPageSource(){
		return driver.getPageSource();
	}
	
	public void close(){
		//this.driver.close();
	}
	
	public static void SetAndctrlVClipboardData(String string){
		StringSelection stringSelection = new StringSelection(string);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);
		Robot robot = null;
		
		try{
			robot = new Robot();
		} catch(AWTException e1){
			e1.printStackTrace();			
		}
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	
		try{
			Thread.sleep(3000);
		} catch(Exception e){
			e.printStackTrace();
		}
	
	}
	
	public static void pressTabKey(){
		Robot robot =null;
		try{
			robot = new Robot();
		} catch(AWTException e1){
			e1.printStackTrace();
		}
		
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
	}
	

}
