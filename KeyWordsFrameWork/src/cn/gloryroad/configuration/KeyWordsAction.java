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
	//������̬WebDriver ���������ڴ�����Driver�Ĳ���
	public static WebDriver driver;
	//�����洢��λ���ʽ�����ļ���ObjectMap����
	private static ObjectMap objectMap = new ObjectMap(Constants.Path_ConfigurationFile);
	
	static{
		//ָ��Log4j�����ļ�Ϊlog4j.xml
		DOMConfigurator.configure("log4j.xml");
	}
	
	
	/*
	 * �˷��������ƶ�ӦExcel�ļ����ؼ��֡����е�open_browser�ؼ���
	 * Excel �ļ�������ֵ�����е���������ָ�����������ú�����������в�������
	 * ��ie��ʾ����IE��������в���������firefox��ʾ��������������chrome
	 * ��ʾ����chrome��������в���	 
	 */

	public static void open_browser(String browsername){
		
		if(browsername.equals("ie")){
			System.setProperty("webdriver.ie.driver", "C:\\Python27\\IEDriverServer.exe");
			driver= new InternetExplorerDriver();
			Log.info("IE�����ʵ���Ѿ�����");
		} else if(browsername.equals("firefox")){
			driver = new FirefoxDriver();
			Log.info("��������ʵ���Ѿ�����");
		} else {
			System.setProperty("webdriver.chrome.driver","C:\\Python27\\chromedriver.exe");
			driver= new ChromeDriver();
			Log.info("chrome�����ʵ���Ѿ�����");
		}
	}
	
	//�˷��������ƶ�ӦExcel�ļ����ؼ��֡����е�navigate�ؼ���
	//��ȡExcel�ļ�������ֵ�����е���ַ������Ϊ��������ʵ���ַ
	public static void navigate(String url){
		
		driver.get(url);
		Log.info("�����������ַ"+url);
	}
	
	//�˷��������ƶ�ӦExcel�ļ����ؼ��֡����е�input_userName �ؼ���
	//��ȡExcel�ļ�������ֵ�����е������û����ƣ���Ϊ��¼�û�������������
	public static void input_userName(String userName){
		
		System.out.println("�յ��Ĳ���ֵ��"+userName);
		
		try{
			driver.findElement(objectMap.getLocator("login.username")).clear();
			Log.info("����û�����������������");
			driver.findElement(objectMap.getLocator("login.username")).sendKeys(userName);
			Log.info("���û�������������û�����"+userName);
		}catch(Exception e){
			TestSuiteByExcel.testResult=false;
			Log.info("���û�������������û��������쳣�������쳣��Ϣ��"+e.getMessage());
			e.printStackTrace();
		}
	}
	
	//�˷��������ƶ�ӦExcel�ļ����ؼ��֡����е�input_passWord�ؼ���
	//��ȡExcel�ļ�������ֵ�����е��������룬��Ϊ��¼�������������
	
	public static void input_passWord(String password) throws Exception{
		
		try{
			driver.findElement(objectMap.getLocator("login.password")).clear();
			Log.info("������������");
			driver.findElement(objectMap.getLocator("login.password")).sendKeys(password);
		}catch(Exception e){
			TestSuiteByExcel.testResult=false;
			Log.info("���������������ʱ�����쳣�������쳣��Ϣ��"+e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	/*
	 * �˷��������ƶ�ӦExcel�ļ����ؼ��֡����е�click_login�ؼ���
	 * ʵ�ֵ�����¼��ť����������string ����������Ϊ����������ֵ���趨һ��
	 * ���õĺ�����������Ϊ��ͳһ���䷽���ĵ��÷�ʽ(������һ������)
	 */
	
	public static void click_login(String string){
		try{
			driver.findElement(objectMap.getLocator("login.button")).click();
			Log.info("������¼��ť");
		} catch(Exception e){
			TestSuiteByExcel.testResult=false;
			Log.info("������¼��ťʱ�����쳣�������쳣��Ϣ��"+e.getMessage());
			e.printStackTrace();
		}
	}
	
	/*
	 * �˷��������ƶ�ӦExcel�ļ����ؼ��֡����е�WaitFor_Element�ؼ���
	 * ������ʽ�ȴ�ҳ��Ԫ�س�����ҳ���С�������ȡExcelW�ļ�������ֵ�����еı��ʽ��Ϊ����������objectMap�����getLocator����
	 * ����ݺ�������ֵ�������ļ��в���keyֵ��Ӧ�Ķ�λ���ʽ
	 * 
	 */
	
	public static void WaitFor_Element(String xpathExpression){
		
		try{
			//���÷�װ��waitWebElement������ʾ�ȴ�ҳ��Ԫ���Ƿ����
			waitWebElement(driver,objectMap.getLocator(xpathExpression));
			Log.info("��ʽ�ȴ�Ԫ�س��ֳɹ���Ԫ����"+xpathExpression);
		} catch(Exception e){
			TestSuiteByExcel.testResult=false;
			Log.info("��ʾ�ȴ�Ԫ��ʱ�����쳣�������쳣��Ϣ��"+e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	//�˷��������ƶ�ӦExcel�ļ����ؼ��֡����е�click_writeLetterLink�ؼ���
	//���ڵ���д������
	public static void click_writeLetterLink(String string){
		
		try{
			driver.findElement(objectMap.getLocator(string)).click();
			Log.info("����д�����ӳɹ�");
		} catch(Exception e){
			TestSuiteByExcel.testResult=false;
			Log.info("����д������ʱ�����쳣�������쳣��Ϣ��"+e.getMessage());
			e.printStackTrace();
		}	
	}
	
	
	//�˷��������ƶ�ӦExcel�ļ����ؼ��֡����е�input_recipients�ؼ���
	//�������ռ��������������ָ�����ռ�����Ϣ����������recipientsΪ�ռ�����Ϣ
	public static void input_recipients(String recipients){
		
		try{
			driver.findElement(objectMap.getLocator("writemailpage.recipients")).sendKeys(recipients);
			Log.info("���ռ��������ɹ������ռ�����Ϣ��"+recipients);
		} catch(Exception e){
			TestSuiteByExcel.testResult=false;
			Log.info("���ռ���������������ռ�����Ϣʱ�����쳣�������쳣��Ϣ��"+e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	//�˷��������ƶ�ӦExcel�ļ����ؼ��֡����е�input_mailSubject�ؼ���
	//�������ʼ����������������ָ�����ַ�������������mailSubjectΪ��������
	public static void input_mailSubject(String mailSubject){
		
		try{
			driver.findElement(objectMap.getLocator("writemailpage.mailsubject")).sendKeys(mailSubject);
			Log.info("�ɹ������ʼ����⣺"+mailSubject);
		} catch(Exception e){
			TestSuiteByExcel.testResult=false;
			e.printStackTrace();
			Log.info("���ʼ���������������ʼ�����ʱ�����쳣�������쳣��Ϣ��"+e.getMessage());
		}
	}
	
	//�˷��������ƶ�ӦExcel�ļ����ؼ��֡����е�press_Tab�ؼ���
	//���ڰ�Tab���Ĳ���
	
	public static void press_Tab(String string){
		
		try{
			
			Thread.sleep(2000);
			//����KeyBoardUtil��ķ�װ����pressTabKey
			KeyBoardUtil.pressTabKey();
			Log.info("��tab���ɹ�");
		} catch(Exception e){
			TestSuiteByExcel.testResult=false;
			Log.info("��tab��ʱ�����쳣�������쳣��Ϣ��"+e.getMessage());
			e.printStackTrace();
		}
	}
	
	//�˷��������ƶ�ӦExce�ļ����ؼ��֡����е�paste_mailContent�ؼ���
	//ͨ�����а�ճ���ķ�ʽ����ָ��������������ַ������磬�ʼ�����
	public static void paste_mailContent(String mailContent){
		try{	
			    System.out.println("mailContent="+mailContent);
			    Thread.sleep(6000);
				KeyBoardUtil.setAndctrlVClipboardData(mailContent);				
				System.out.println("�ѽ�ִ����ճ������");
				Log.info("�ɹ�ճ���ʼ����ģ�"+mailContent);
			} catch(Exception e){
				TestSuiteByExcel.testResult=false;
				Log.info("�������ճ������ʱ�����쳣�������쳣��Ϣ��"+e.getMessage());
				e.printStackTrace();
			}
			
	}
	
	//�˷��������ƶ�ӦExcel�ļ����ؼ��֡����е�click_addAttachment�ؼ���
	//���ڵ�����Ӹ����İ�ť
	public static void click_addAttachment(String string){
		
		try{			
			Thread.sleep(5000);
			System.out.println("�ɹ�������ִ�к���"+string);
			driver.findElement(objectMap.getLocator(string)).click();			
			Log.info("������Ӹ�����ť�ɹ�");
		} catch(Exception e){
			TestSuiteByExcel.testResult=false;
			Log.info("������Ӹ�����ťʱ�����쳣�������쳣��Ϣ��"+e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	//�˷��������ƶ�ӦExcel�ļ����ؼ��֡����е�paste_uploadFileName�ؼ���
	//ͨ�����а�ճ���ķ�ʽ�����ļ��ϴ�������ļ��������������Ҫ�ϴ��ļ���·��������
	public static void paste_uploadFileName(String uploadFileName){
		try{
			Thread.sleep(5000);
			KeyBoardUtil.setAndctrlVClipboardData(uploadFileName);
			Log.info("�ɹ�ճ���ϴ��ļ�����"+uploadFileName);
		} catch(Exception e){
			TestSuiteByExcel.testResult=false;
			Log.info("���ļ�����������ϴ��ļ�����ʱ�����쳣�������쳣��Ϣ��"+e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	//�˷��������ƶ�ӦExcel�ļ����ؼ��֡����е�press_enter�ؼ���
	//���ڰ�Enter��
	public static void press_enter(String string){
		try{
			KeyBoardUtil.pressEnterKey();
			Log.info("����Enter���ɹ�");
		} catch(Exception e){
			TestSuiteByExcel.testResult=false;
			Log.info("��Enter��ʱ�����쳣�������쳣��Ϣ��"+e.getMessage());
			e.printStackTrace();
		}
	}
	
	//�˷��������ƶ�ӦExcel�ļ����ؼ��֡����е�sleep�ؼ���
	//���ڵȴ���������ͣ���룬�����������Ժ���Ϊ��λ�ĵȴ�ʱ��
	public static void sleep(String sleepTime){
		
		try{
			WaitUitl.sleep(Integer.parseInt(sleepTime));
			Log.info("����"+Integer.parseInt(sleepTime)/1000+"��ɹ�");
		} catch(Exception e){
			TestSuiteByExcel.testResult=false;
			Log.info("�߳�����ʱ�����쳣�������쳣��Ϣ��"+e.getMessage());
			e.printStackTrace();
		}
	}
	
	//�˷��������ƶ�ӦExcel�ļ����ؼ��֡����е�click_sendMailButton�ؼ���
	//���ڵ����ʼ����Ͱ�ť
	public static void click_sendMailButton(String string){
		
		try{
			/*
			 * ҳ�������������Ͱ�ť����ִ�з��͹��ܣ�Ϊ��ʹ��Xpathƥ�䷽�㣬
			 * ͬʱƥ�����������Ͱ�ť�����洢��list�����У����ȡ��һ��
			 * ��ť��������ɵ��������ʼ��Ĳ���
			 */
			
			List<WebElement> buttons = driver.findElements(objectMap.getLocator("writemailpage.sendmailbuttons"));
			
			buttons.get(0).click();
			Log.info("���������ʼ���ť�ɹ�");
		} catch(Exception e){
			TestSuiteByExcel.testResult=false;
			Log.info("���������ʼ���ťʱ�����쳣�������쳣��Ϣ��"+e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	//�˷��������ƶ�ӦExcel�ļ����ؼ��֡����е�Assert_String�ؼ���
	//������ɶ��ԵĲ�������������Ϊ���Ե���������
	
	public static void Assert_String(String assertString){
		
		try{
			Assert.assertTrue(driver.getPageSource().contains(assertString));
			Log.info("�ɹ����Թؼ��֡�"+assertString+"��");
		} catch(AssertionError e){
			TestSuiteByExcel.testResult=false;
			Log.info("���ֶ���ʧ�ܣ��������ʧ����Ϣ��"+e.getMessage());
			System.out.println("����ʧ��");
		}
	}
	
	
	//�˷��������ƶ�ӦExcel�ļ����ؼ��֡����е�close_browser�ؼ���
	//���ڹر�������Ĳ���
	
	public static void close_browser(String string){
		
		try{
			System.out.println("������رպ�����ִ��");
			Log.info("�ر����������");
			driver.quit();
		} catch(Exception e){
			TestSuiteByExcel.testResult=false;
			Log.info("�ر�����������쳣�������쳣��Ϣ��"+e.getMessage());
			e.printStackTrace();
		}
	}
	
	
}
