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
	private String projectpath = System.getProperty("user.dir"); //工程项目的绝对路径
	
	@BeforeClass
	public void startFirefox(){	
		System.setProperty("webdriver.firefox.bin","C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		File firebug= new File(projectpath+"/tool/firebug@software.joehewitt.com.xpi");  //加载firebug插件
		File firepath= new File(projectpath+"/tool/FireXPath@pierre.tholence.com.xpi");  //加载firepath插件
		File firefinder= new File(projectpath+"/tool/firefinder@robertnyman.com.xpi"); //加载firefinder插件
		firfoxprofile = new FirefoxProfile();
		
		try{
			firfoxprofile.addExtension(firebug);
			firfoxprofile.addExtension(firepath);
			firfoxprofile.addExtension(firefinder);
			firfoxprofile.setPreference("webdriver.accept.untrusted.certs","true");  //接受不信任的证书的网站
			firfoxprofile.setPreference("extensions.firebug.currentVersion","1.9.2.1"); //firebug版本
			/*代理设置
			firfoxprofile.setPreference("network.proxy.type",0);
			firfoxprofile.setPreference("network.proxy.http","10.1.0");
			firfoxprofile.setPreference("network.proxy.http_port",3128);*/
		} catch(Exception e){
			e.printStackTrace();
		}
		driver = new FirefoxDriver(firfoxprofile);
		//driver.manage().window().maximize();	
		/*
		 * Ie代理设置：
		 * import org.snipecode.reg.RegUtil;
		 * int hangdle=RegUtil.RegOpenKey(RegUtil.HKEY_CURRENT_USER,"SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Internet Settings",RegUtil.KEY_ALL_ACCESS)[RegUtil.NATIVE_HANDLE];
		 * RegUtil.RegSetValueEx(handle,"ProxyEnable","dword:00000000"); //如果需要设置代理：word:00000001
		 * RegUtil.RegSetValueEx(handle,"ProxyServer",PROXY);
		 */
	}
	
	@Test
	public void searchOnBaidu(){
		driver.get("http://www.baidu.com");
		
		//driver.get(url);
		//driver.get("javascript:document.getElementById('overridelink');");  承认不信任网址的设置
		
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
