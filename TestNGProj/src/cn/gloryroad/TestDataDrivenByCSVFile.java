package cn.gloryroad;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class TestDataDrivenByCSVFile {
	public WebDriver driver;
	String baseUrl = "http://www.sogou.com/";
	
	@DataProvider(name="testData")
	public static Object[][] words() throws IOException{
		return getTestData("d:\\testData.csv");
	}
	
	@Test(dataProvider="testData")
	public void testSearch(String searchWord1,String searchWord2,String searchResult){
		driver.get(baseUrl + "/");
		driver.findElement(By.id("query")).sendKeys(searchWord1+" "+searchWord2);
		driver.findElement(By.id("stb")).click();
		
		(new WebDriverWait(driver,10)).until(new ExpectedCondition<Boolean>(){
			@Override
			public Boolean apply(WebDriver d){
				
				return d.findElement(By.id("s_footer")).getText().contains("ËÑË÷°ïÖú");
			} 
		});
		
		Assert.assertTrue(driver.getPageSource().contains(searchResult));
	}
	
	
	@BeforeMethod
	public void afterMethod(){
		driver = new FirefoxDriver();
	}
	
	@AfterMethod
	public void afterMehtod(){		
		driver.quit();
	}
	
	public static Object[][] getTestData(String fileName) throws IOException{
		List<Object[]> records = new ArrayList<Object[]>();
		String record;
		BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
		
		file.readLine();
		
		while((record=file.readLine())!=null){
			String fields[]=record.split(",");
			records.add(fields);
		}
		
		file.close();
		Object[][] results = new Object[records.size()][];
		
		for(int i=0; i<records.size();i++){
			results[i]=records.get(i);
		}
		
		return results;	
	}
	

}


