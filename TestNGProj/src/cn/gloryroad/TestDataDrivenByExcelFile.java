package cn.gloryroad;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;


public class TestDataDrivenByExcelFile {
	public WebDriver driver;
	String baseUrl = "http://www.sogou.com/";
	
	//ʹ��ע�� DataProvider,�����ݼ�������Ϊ"testData"
	@DataProvider(name="testData")
	public static Object[][] words() throws IOException{
		
		return getTestData("d:\\","testData.xlsx","Sheet1");
	}
	
	//����������������ʹ��testData����Դ�����ݣ�ÿһ�е���1�κ���
	@Test(dataProvider = "testData")
	public void testSearch(String searchWord1,String searchWord2,String searchResult){
		driver.get(baseUrl+"/");
		driver.findElement(By.id("query")).sendKeys(searchWord1+" "+searchWord2);
		driver.findElement(By.id("stb")).click();
		
		(new WebDriverWait(driver,10)).until(new ExpectedCondition<Boolean>(){
			@Override
			public Boolean apply(WebDriver d){
				
				return d.findElement(By.id("s_footer")).getText().contains("��������");
			} 
		});
		
		Assert.assertTrue(driver.getPageSource().contains(searchResult));		
		
	}
	
	@BeforeMethod
	public void beforeMehtod(){
		driver = new FirefoxDriver();
	}
	
	@AfterMethod
	public void afterMethod(){
		driver.quit();
	}
	
	public static Object[][] getTestData(String filePath, String fileName,String sheetName) throws IOException{
		
		File file = new File(filePath +"\\"+fileName);
		
		FileInputStream inputStream = new FileInputStream(file);
		
		Workbook Workbook = null;
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		
		System.out.println("fileExtensionName="+fileExtensionName);
		
		if (fileExtensionName.equals(".xlsx")){
			Workbook = new XSSFWorkbook(inputStream);
		}
		else if(fileExtensionName.equals(".xls")){
			Workbook = new HSSFWorkbook(inputStream);
		}
		
		Sheet Sheet = Workbook.getSheet(sheetName);
		
		int rowCount =Sheet.getLastRowNum() - Sheet.getFirstRowNum();
		
		List<Object[]> records = new ArrayList<Object[]>();
		/*
		System.out.println("Sheet.getLastRowNum()"+Sheet.getLastRowNum());
		
		System.out.println("Sheet.getFirstRowNum()"+Sheet.getFirstRowNum());
		
		System.out.println(Sheet.getRow(0).getLastCellNum());
		
		System.out.println(Sheet.getRow(0).getFirstCellNum());*/
		
		//ע�⣬�к��ж��Ǵ�0��ʼ�� Excel����=Sheet.getLastRowNum()+1���� ��=Sheet.getRow(0).getLastCellNum()
		for(int i = 0; i<rowCount+1;i++){
			
			Row row = Sheet.getRow(i);			
			String fields[] = new String[row.getLastCellNum()];
			for(int j =0;j<row.getLastCellNum();j++){
				fields[j]=row.getCell(j).getStringCellValue();
			}
			
			records.add(fields);
		}
		
		Object[][] results = new Object[records.size()][];
		
		for(int i=0;i<records.size();i++){		
			results[i] = records.get(i);
		}
		
		return results;
	}
	
}
