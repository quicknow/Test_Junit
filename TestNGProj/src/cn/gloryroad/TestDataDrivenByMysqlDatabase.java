package cn.gloryroad;
//使用Mysql数据库作为数据存储地

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

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

public class TestDataDrivenByMysqlDatabase {

	public WebDriver driver;
	String baseUrl ="http://www.sogou.com/";
	@DataProvider(name="testData")
	public static Object[][] words() throws IOException{
		return getTestData("testdata");
	}
	
	@Test(dataProvider="testData")
	public void testSearch(String searchWord1, String searchWord2, String searchResult){
		
		
		driver.get(baseUrl + "/");
		driver.findElement(By.id("query")).sendKeys(searchWord1+" "+searchWord2);
		driver.findElement(By.id("stb")).click();
		
		(new WebDriverWait(driver,10)).until(new ExpectedCondition<Boolean>(){
			@Override
			public Boolean apply(WebDriver d){
				
				return d.findElement(By.id("s_footer")).getText().contains("搜索帮助");
			} 
		});
		
		Assert.assertTrue(driver.getPageSource().contains(searchResult));
	}
	
	@BeforeMethod
	public void beforeMethod(){
		driver=new FirefoxDriver();
	}
	
	@AfterMethod
	public void afterMethod(){
		//driver.quit();
	}
	
	public static Object[][] getTestData(String tablename) throws IOException{
		//声明MySQL数据库的驱动
		String driver ="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://127.0.0.1:3306/gloryroad";
		String user="root";
		String password="88888888";
		List<Object[]> records = new ArrayList<Object[]>();
		try{
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,user,password);
			if(!conn.isClosed())
				System.out.println("连接数据库成功！");
			
			Statement statement = conn.createStatement();
			
			String sql = "select * from" +" "+ tablename; //注意，from后面一定要加上空格，否则会造成语法错误
			ResultSet rs = statement.executeQuery(sql);
			System.out.println(rs);
			ResultSetMetaData rsMetaData = rs.getMetaData();
			
			int cols = rsMetaData.getColumnCount();
			while(rs.next()){
				String fields[] = new String[cols];
				int col = 0;
				
				for(int colIdx = 0;colIdx<cols;colIdx++){
					fields[col]=rs.getString(colIdx+1);
					col++;
				}
				records.add(fields);
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
			}
			
			rs.close();
			conn.close();
		} catch(ClassNotFoundException e){
			System.out.println("未能找到Mysql的驱动类");
			e.printStackTrace();
		} catch(SQLException e){
			e.printStackTrace();
		} catch(Exception e){
			e.printStackTrace();
		}
				
		Object[][] results = new Object[records.size()][];		
		for(int i=0; i<records.size();i++){
			results[i]=records.get(i);
		}
		
		return results;	
		
	}
}
