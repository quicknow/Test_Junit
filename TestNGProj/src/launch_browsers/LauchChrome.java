package launch_browsers;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class LauchChrome {

	private static WebDriver driver = null;
	private static DesiredCapabilities caps = null;
	private String projectpath = System.getProperty("user.dir"); //工程项目的绝对路径
	
	@BeforeClass
	public void startChrome(){		
		//System.setProperty("webdriver.chrome.driver",projectpath+"/tool/chromedriver.exe");
		//caps=DesiredCapabilities.chrome();
		//caps.setCapability("chrome.switches",Arrays.asList("--proxy-server=http://your-proxy-domain:4443")); //设置代理
		driver = new ChromeDriver();	
		//driver.manage().window().maximize();	
	
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
		driver.quit();
	}
	
	
}
