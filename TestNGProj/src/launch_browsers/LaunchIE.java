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
	private String projectpath = System.getProperty("user.dir"); //工程项目的绝对路径
	
	@BeforeClass
	public void startIE(){		
		System.setProperty("webdriver.ie.driver",projectpath+"/tool/IEDriverServer.exe");
		caps=DesiredCapabilities.internetExplorer();
		caps.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, false);
		
		caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);  //防止安全模式设置的级别过高，而造成的错误
		caps.setCapability(InternetExplorerDriver.IE_SWITCHES,"-private");  //inPrivate模式浏览 ，不会保存cookies和cache
		caps.setCapability("ignoreZoomSetting",true);  //忽略开始浏览器大小的设置，即最大化
		driver = new InternetExplorerDriver(caps);	
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
	public void quitIEDriver(){
		driver.quit();
	}
	

}
