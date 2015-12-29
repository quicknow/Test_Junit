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
	//������̬WebDriver ���������ڴ�����Driver�Ĳ���
	public static WebDriver driver;
	//�����洢��λ���ʽ�����ļ���ObjectMap����
	private static ObjectMap objectMap = new ObjectMap("F:\\selenium_java\\Test_Junit\\KeyWordsFrameWork\\objectMap.properties");
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
		} else if(browsername.equals("firefox")){
			driver = new FirefoxDriver();
		} else {
			System.setProperty("webdriver.chrome.driver","C:\\Python27\\chromedriver.exe");
			driver= new ChromeDriver();
		}
	}
	
	//�˷��������ƶ�ӦExcel�ļ����ؼ��֡����е�navigate�ؼ���
	//��ȡExcel�ļ�������ֵ�����е���ַ������Ϊ��������ʵ���ַ
	public static void navigate(String url){
		
		driver.get(url);
	}
	
	//�˷��������ƶ�ӦExcel�ļ����ؼ��֡����е�input_userName �ؼ���
	//��ȡExcel�ļ�������ֵ�����е������û����ƣ���Ϊ��¼�û�������������
	public static void input_userName(String userName){
		
		System.out.println("�յ��Ĳ���ֵ��"+userName);
		
		try{
			driver.findElement(objectMap.getLocator("login.username")).clear();
			driver.findElement(objectMap.getLocator("login.username")).sendKeys(userName);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//�˷��������ƶ�ӦExcel�ļ����ؼ��֡����е�input_passWord�ؼ���
	//��ȡExcel�ļ�������ֵ�����е��������룬��Ϊ��¼�������������
	
	public static void input_passWord(String password) throws Exception{
		
		try{
			driver.findElement(objectMap.getLocator("login.password")).clear();
			driver.findElement(objectMap.getLocator("login.password")).sendKeys(password);
		}catch(Exception e){
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
		} catch(Exception e){
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
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	//�˷��������ƶ�ӦExcel�ļ����ؼ��֡����е�click_writeLetterLink�ؼ���
	//���ڵ���д������
	public static void click_writeLetterLink(String string){
		
		try{
			driver.findElement(objectMap.getLocator("homepage.writeLetterLink")).click();
		} catch(Exception e){
			e.printStackTrace();
		}	
	}
	
	
	//�˷��������ƶ�ӦExcel�ļ����ؼ��֡����е�input_recipients�ؼ���
	//�������ռ��������������ָ�����ռ�����Ϣ����������recipientsΪ�ռ�����Ϣ
	public static void input_recipients(String recipients){
		
		try{
			driver.findElement(objectMap.getLocator("writemailpage.recipients")).sendKeys(recipients);;
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	//�˷��������ƶ�ӦExcel�ļ����ؼ��֡����е�input_mailSubject�ؼ���
	//�������ʼ����������������ָ�����ַ�������������mailSubjectΪ��������
	public static void input_mailSubject(String mailSubject){
		
		try{
			driver.findElement(objectMap.getLocator("writemailpage.mailsubject")).sendKeys(mailSubject);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//�˷��������ƶ�ӦExcel�ļ����ؼ��֡����е�press_Tab�ؼ���
	//���ڰ�Tab���Ĳ���
	
	public static void press_Tab(String string){
		
		try{
			
			Thread.sleep(2000);
			//����KeyBoardUtil��ķ�װ����pressTabKey
			KeyBoardUtil.pressEnterKey();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//�˷��������ƶ�ӦExce�ļ����ؼ��֡����е�paste_mailContent�ؼ���
	//ͨ�����а�ճ���ķ�ʽ����ָ��������������ַ������磬�ʼ�����
	public static void paste_mailContent(String mailContent){
		try{			
				KeyBoardUtil.setAndctrlVClipboardData(mailContent);
			} catch(Exception e){
				e.printStackTrace();
			}
			
	}
	
	//�˷��������ƶ�ӦExcel�ļ����ؼ��֡����е�click_addAttachment�ؼ���
	//���ڵ�����Ӹ����İ�ť
	public static void click_addAttachment(String string){
		
		try{
			driver.findElement(objectMap.getLocator("writemailpage.addattachementlink")).click();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	//�˷��������ƶ�ӦExcel�ļ����ؼ��֡����е�paste_uploadFileName�ؼ���
	//ͨ�����а�ճ���ķ�ʽ�����ļ��ϴ�������ļ��������������Ҫ�ϴ��ļ���·��������
	public static void paste_uploadFileName(String uploadFileName){
		try{
			KeyBoardUtil.setAndctrlVClipboardData(uploadFileName);
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	//�˷��������ƶ�ӦExcel�ļ����ؼ��֡����е�press_enter�ؼ���
	//���ڰ�Enter��
	public static void press_enter(String string){
		try{
			KeyBoardUtil.pressEnterKey();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//�˷��������ƶ�ӦExcel�ļ����ؼ��֡����е�sleep�ؼ���
	//���ڵȴ���������ͣ���룬�����������Ժ���Ϊ��λ�ĵȴ�ʱ��
	public static void sleep(String sleepTime){
		
		try{
			WaitUitl.sleep(Integer.parseInt(sleepTime));
		} catch(Exception e){
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
			
			List<WebElement> buttons = driver.findElements(objectMap.getLocator("writemailpage.sendmilbuttons"));
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	//�˷��������ƶ�ӦExcel�ļ����ؼ��֡����е�Assert_String�ؼ���
	//������ɶ��ԵĲ�������������Ϊ���Ե���������
	
	public static void Assert_String(String assertString){
		
		try{
			Assert.assertTrue(driver.getPageSource().contains(assertString));
		} catch(AssertionError e){
			System.out.println("����ʧ��");
		}
	}
	
	
	//�˷��������ƶ�ӦExcel�ļ����ؼ��֡����е�close_browser�ؼ���
	//���ڹر�������Ĳ���
	
	public static void close_browser(String string){
		
		try{
			System.out.println("������رպ�����ִ��");
			driver.quit();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
}
