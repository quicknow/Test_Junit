package launch_browsers;

import java.io.File;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class LaunchFirefox {

	private static WebDriver driver = null;
	private FirefoxProfile firfoxprofile = null;	
	private String projectpath = System.getProperty("user.dir"); //������Ŀ�ľ���·��
	
	@BeforeClass
	public void startFirefox(){	
		System.setProperty("webdriver.firefox.bin","C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		File firebug= new File(projectpath+"/tool/firebug@software.joehewitt.com.xpi");  //����firebug���
		File firepath= new File(projectpath+"/tool/FireXPath@pierre.tholence.com.xpi");  //����firepath���
		File firefinder= new File(projectpath+"/tool/firefinder@robertnyman.com.xpi"); //����firefinder���
		firfoxprofile = new FirefoxProfile();
		
		try{
			firfoxprofile.addExtension(firebug);
			firfoxprofile.addExtension(firepath);
			firfoxprofile.addExtension(firefinder);
			firfoxprofile.setPreference("webdriver.accept.untrusted.certs","true");  //���ܲ����ε�֤�����վ
			firfoxprofile.setPreference("extensions.firebug.currentVersion","1.9.2.1"); //firebug�汾
			/*��������
			firfoxprofile.setPreference("network.proxy.type",0);
			firfoxprofile.setPreference("network.proxy.http","10.1.0");
			firfoxprofile.setPreference("network.proxy.http_port",3128);*/
		} catch(Exception e){
			e.printStackTrace();
		}
		driver = new FirefoxDriver(firfoxprofile);
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
	public void quitDriver(){
		//driver.quit();
	}
}
