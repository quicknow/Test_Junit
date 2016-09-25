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
	private String projectpath = System.getProperty("user.dir"); //������Ŀ�ľ���·��
	
	@BeforeClass
	public void startChrome(){		
		//System.setProperty("webdriver.chrome.driver",projectpath+"/tool/chromedriver.exe");
		//caps=DesiredCapabilities.chrome();
		//caps.setCapability("chrome.switches",Arrays.asList("--proxy-server=http://your-proxy-domain:4443")); //���ô���
		driver = new ChromeDriver();	
		//driver.manage().window().maximize();	
	
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
		driver.quit();
	}
	
	
}
