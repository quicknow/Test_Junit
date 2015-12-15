package cn.gloryroad;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataFProviderTest {
	
	private static WebDriver driver;
	
	@DataProvider(name = "searchWords")	
	public static Object[][] words() {
		return new Object[][]{{"蝙蝠侠","主演","迈克尔"},{"超人","导演","唐纳"},{"生化危机","编剧","安德森"}};
	}
	
	
	@Test(dataProvider="searchWords")
	public void test(String searchWord1,String searchWord2,String SearchResult){
		
		driver= new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://www.sogou.com");
		
		driver.findElement(By.id("query")).sendKeys(searchWord1+" "+searchWord2);
		driver.findElement(By.id("stb")).click();
		try{
			Thread.sleep(3000);
		} catch(InterruptedException e){
			e.printStackTrace();
		}
		
		Assert.assertTrue(driver.getPageSource().contains(SearchResult));
		//driver.quit();
	}

}
