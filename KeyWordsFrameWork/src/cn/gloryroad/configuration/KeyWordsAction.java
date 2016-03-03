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

	public static void open_browser(String string,String browsername){
		
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
	public static void navigate(String string,String url){
		
		driver.get(url);
		Log.info("�����������ַ"+url);
	}
	
	//�˷��������ƶ�ӦExcel�ļ����ؼ��֡����е�input �ؼ���
	//��ȡExcel�ļ�������ֵ�����е������û����ƣ���Ϊ��¼�û�������������
	public static void input(String locatorExpression, String inputString){
		
		//System.out.println("�յ��Ĳ���ֵ��"+userName);
		
		try{
			driver.findElement(objectMap.getLocator(locatorExpression)).clear();
			Log.info("����û�����������������");
			driver.findElement(objectMap.getLocator(locatorExpression)).sendKeys(inputString);
			Log.info("��"+locatorExpression+"����������룺"+inputString);
		}catch(Exception e){
			TestSuiteByExcel.testResult=false;
			Log.info("��"+locatorExpression+"����������룺��"+inputString+"��ʱ�����쳣,�����쳣��Ϣ��"+e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	
	/*
	 * �˷��������ƶ�ӦExcel�ļ����ؼ��֡����е�click�ؼ���
	 * ʵ�ֵ�����¼��ť����������string ����������Ϊ����������ֵ���趨һ��
	 * ���õĺ�����������Ϊ��ͳһ���䷽���ĵ��÷�ʽ(������һ������)
	 */
	
	public static void click(String locatorExprssion, String string){
		try{
			driver.findElement(objectMap.getLocator(locatorExprssion)).click();
			Log.info("����"+locatorExprssion+"ҳ��Ԫ�سɹ�");
		} catch(Exception e){
			TestSuiteByExcel.testResult=false;
			Log.info("����"+locatorExprssion+"ҳ��Ԫ��ʧ�ܣ������쳣��Ϣ��"+e.getMessage());
			e.printStackTrace();
		}
	}
	
	/*
	 * �˷��������ƶ�ӦExcel�ļ����ؼ��֡����е�WaitFor_Element�ؼ���
	 * ������ʽ�ȴ�ҳ��Ԫ�س�����ҳ���С�������ȡExcelW�ļ�������ֵ�����еı��ʽ��Ϊ����������objectMap�����getLocator����
	 * ����ݺ�������ֵ�������ļ��в���keyֵ��Ӧ�Ķ�λ���ʽ
	 * 
	 */
	
	public static void WaitFor_Element(String locatorExpression,String string){
		
		try{
			//���÷�װ��waitWebElement������ʾ�ȴ�ҳ��Ԫ���Ƿ����
			waitWebElement(driver,objectMap.getLocator(locatorExpression));
			Log.info("��ʽ�ȴ�Ԫ�س��ֳɹ���Ԫ����"+locatorExpression);
		} catch(Exception e){
			TestSuiteByExcel.testResult=false;
			Log.info("��ʾ�ȴ�Ԫ��ʱ�����쳣�������쳣��Ϣ��"+e.getMessage());
			e.printStackTrace();
		}
		
	}		
	
	
	//�˷��������ƶ�ӦExcel�ļ����ؼ��֡����е�press_Tab�ؼ���
	//���ڰ�Tab���Ĳ���
	
	public static void press_Tab(String string1,String string2){
		
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
	public static void pasteString(String string,String pasteContent){
		try{	
			    
			    Thread.sleep(6000);
				KeyBoardUtil.setAndctrlVClipboardData(pasteContent);				
				System.out.println("�ѽ�ִ����ճ������");
				Log.info("�ɹ�ճ���ʼ����ģ�"+pasteContent);
			} catch(Exception e){
				TestSuiteByExcel.testResult=false;
				Log.info("�������ճ������ʱ�����쳣�������쳣��Ϣ��"+e.getMessage());
				e.printStackTrace();
			}
			
	}
	

	
	//�˷��������ƶ�ӦExcel�ļ����ؼ��֡����е�press_enter�ؼ���
	//���ڰ�Enter��
	public static void press_enter(String string1,String String2){
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
	public static void sleep(String string,String sleepTime){
		
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
	public static void click_sendMailButton(String locatorExpression,String string){
		
		try{
			/*
			 * ҳ�������������Ͱ�ť����ִ�з��͹��ܣ�Ϊ��ʹ��Xpathƥ�䷽�㣬
			 * ͬʱƥ�����������Ͱ�ť�����洢��list�����У����ȡ��һ��
			 * ��ť��������ɵ��������ʼ��Ĳ���
			 */
			
			List<WebElement> buttons = driver.findElements(objectMap.getLocator(locatorExpression));
			
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
	
	public static void Assert_String(String string,String assertString){
		
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
	
	public static void close_browser(String string1,String string2){
		
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
