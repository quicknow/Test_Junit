package launch_browsers;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class LaunchIE {
	private static WebDriver driver = null;
	private static DesiredCapabilities caps = null;
	private String projectpath = System.getProperty("user.dir"); //������Ŀ�ľ���·��
	
	@BeforeClass
	public void startIE(){		
		System.setProperty("webdriver.ie.driver",projectpath+"/tool/IEDriverServer.exe");
		caps=DesiredCapabilities.internetExplorer();
		caps.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, false);
		
		caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);  //��ֹ��ȫģʽ���õļ�����ߣ�����ɵĴ���
		caps.setCapability(InternetExplorerDriver.IE_SWITCHES,"-private");  //inPrivateģʽ��� �����ᱣ��cookies��cache
		caps.setCapability("ignoreZoomSetting",true);  //���Կ�ʼ�������С�����ã������
		driver = new InternetExplorerDriver(caps);	
		//driver.manage().window().maximize();	
		/*
		 * Ie�������ã�
		 * import org.snipecode.reg.RegUtil;
		 * int hangdle=RegUtil.RegOpenKey(RegUtil.HKEY_CURRENT_USER,"SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Internet Settings",RegUtil.KEY_ALL_ACCESS)[RegUtil.NATIVE_HANDLE];
		 * RegUtil.RegSetValueEx(handle,"ProxyEnable","dword:00000000"); //�����Ҫ���ô���word:00000001
		 * RegUtil.RegSetValueEx(handle,"ProxyServer",PROXY);
		 */
	}
	
	@Test
	public void searchOnBaidu(){
		driver.get("http://www.baidu.com");
		
		//driver.get(url);
		//driver.get("javascript:document.getElementById('overridelink');");  ���ϲ�������ַ������
		
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public void quitIEDriver(){
		driver.quit();
	}
	

}
