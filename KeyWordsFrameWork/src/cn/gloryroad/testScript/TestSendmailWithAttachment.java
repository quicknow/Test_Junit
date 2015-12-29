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
		
		//���ʱ�������ַ http://mail.126.com
		driver.get("http://mail.126.com");
		
		//��λ126�����½��ҳ���û��������
		WebElement userName = driver.findElement(By.id("idInput"));
		
		//��λ126�����½��ҳ�����������
		WebElement passWord = driver.findElement(By.id("pwdInput"));
		
		//��λ126�����½��ҳ�ĵ�½��ť
		WebElement loginButton = driver.findElement(By.id("loginBtn"));
		//����û������������ݣ���ֹ���������Ӱ���������
		userName.clear();
		
		userName.sendKeys("testform1");
		
		//����������������ݣ���ֹ���������Ӱ���������
		passWord.clear();
		
		passWord.sendKeys("zwb888888");
		
		//�����½��ť
		loginButton.click();
		
		//���÷�װ����ʾ�ȴ���������ҳ����ʾ�˳����Ӻ󣬼���ִ�к��������߼�
		waitWebElement(driver,"//a[contains(.'�˳�')]");
		
		//��λҳ��ġ�д�š� ����
		WebElement writeMailLink = driver.findElement(By.xpath("//*[contains(@id,'_mail_component_')]/span[contais(.,'д��')]"));
		
		//������д�š�����
		writeMailLink.click();
		
		//���÷�װ����ʾ�ȴ���������ҳ����ʾ�����ռ��ˡ������Ӻ󣬼���ִ�к��������߼�
		waitWebElement(driver,"//a[contains(.,'�ռ���')]");
		
		//��λд��ҳ����ռ��������
		WebElement recipients = driver.findElement(By.xpath("//*[contains(@id,'_mail_emailinput_0_')]/input"));
		
		//��λд��ҳ����ʼ����������
		WebElement mailSubject = driver.findElement(By.xpath("//*[contains(@id,'_mail_input_2')]/input"));
		
		//���ռ�������������ռ��˵�ַ�����������ռ����Լ�������
		recipients.sendKeys("testform1@126.com");
		
		//���ʼ���������������ʼ�����
		mailSubject.sendKeys("����һ������ʼ�");
		
		/*
		 * ����KeyBoardUtil���е�pressTabKey�����������ִ��Tab���Ĳ���
		 * ִ�а�Tab��������ҳ������뽹���Զ��л����ʼ����ĵ������
		 */
		
		pressTabKey();
		/*
		 * ����KeyBoardutil���е�setAndctrlVclipboardData����
		 * ģ����а�ճ���Ĳ��������Զ�����ַ�������ճ�����ʼ����������
		 */
		setAndctrlVClipboardData("����һ���Զ������͵Ĳ����ʼ�����");
		
		//��λ��Ӹ���������
		driver.findElement(By.xpath("//a[contais(@id,'_attachAdd')]")).click();
		//����WaitUtil���е�sleep��������0.5�룬 �ȴ�ҳ�浯���ļ�ѡ���Window����
		sleep(500);
		/*
		 * ����KeyBoardUtil���е�setAndctrlVclipboardData����
		 * ���ϴ��ļ��ľ���·���ַ���ճ�����ļ�ѡ����е��ļ��������
		 */
		setAndctrlVClipboardData("c:\\a.log");
		pressEnterKey();
		
		//����WaitUtil���е�sleep��������4�룬�ȴ������ļ��ϴ����
		sleep(4000);
		/*
		 * ��λҳ���ϵ��������Ͱ�ť�����洢��List������ҳ��
		 * �����������Ͱ�ť��ҳ�������Ի�����ͬ�����Ժ���ֻ��λ��Ψһ�ķ��Ͱ�ť
		 * ����ʹ�÷��Ͱ�ť���������Խ��������Ͱ�ťͬʱ��λ���洢��List�����У�Ȼ����������е�����һ����ť���ɶ�λΨһһ�����Ͱ�ť
		 */
		
		List<WebElement> buttons = driver.findElements(By.xpath("//*[contais(@id,'_mail_button_')]/span[contais(.,'����')]"));
		//���������д洢�ĵڶ������Ͱ�ť�����ͱ༭�õ��ʼ�
		buttons.get(1).click();
		
		/*
		 * ���÷�װ����ʾ�ȴ���������ҳ����ʾ�������ؼ��֡�_succInfo����ID����Ԫ�غ󣬼���ִ��
		 * ���������߼�
		 */
		
		waitWebElement(driver,"//*[contains(@id,'_succInfo')]");
		//����ҳ�����Ƿ���������ͳɹ��� ����Ϣ���Դ��ж��ʼ��Ƿ��ͳɹ�
		
		Assert.assertTrue(driver.getPageSource().contains("���ͳɹ�"));
	}
	
	@BeforeMethod
	public void beforeMethod() throws InterruptedException{
		//�趨IE����������ļ��ľ���·��
		System.setProperty("webdriver.ie.dirver","C:\\Python27\\IEDriverServer.exe");
		driver= new InternetExplorerDriver();
	}
	
	@AfterMethod
	public void afterMethod(){
		driver.quit();
	}
	

}
