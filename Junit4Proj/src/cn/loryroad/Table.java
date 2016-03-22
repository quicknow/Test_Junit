package cn.loryroad;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class Table {
	
	//声明一个WebElement对象，用于存储页面的表格元素对象
	private WebElement _table;
	
	//为构造函数传入页面表格元素对象参数，调用Table类的setTable方法，将页面表格元素赋值给Table类的_table成员变量
	public Table(WebElement table){
		setTable(table);
		
	}
	
	//获取页面表格对象的方法
	public WebElement getTable(){
		return _table;
	}
	
	//将页面表格元素赋值给Table类中_Table成员变量的方法
	public void setTable(WebElement _table){
		this._table=_table;
	}
	
	//获取表格元素的行数，查找表格元素有几个tr元素
	//有几个tr元素，就可以知道表格有几行，tr数量和表格行数一致
	public int getRowCount(){
		List<WebElement> tableRows= _table.findElements(By.tagName("tr"));
		return tableRows.size();
	}
	
	//获取表格元素的列数
	//使用get(0)从容器中取出表格第一行的元素，查找有几个“td”,td数量和列数一致
	public int getColumnCount(){
		List<WebElement> tableRows = _table.findElements(By.tagName("tr"));
		return tableRows.get(0).findElements(By.tagName("td")).size();
	}
	
	//获取表格总某行某列的单元格对象
	public WebElement getCell(int rowNo, int colNO) throws NoSuchElementException{
		WebElement cell=null;  
		
		try {
			
			List<WebElement> tableRows = _table.findElements(By.tagName("tr"));
			System.out.println("行总数"+tableRows.size());
			System.out.println("行号："+rowNo);
			WebElement currentRow= tableRows.get(rowNo-1);
			
			List<WebElement> tablecols = currentRow.findElements(By.tagName("td"));
			System.out.println("列总数："+tablecols.size());
			
			cell= tablecols.get(colNO-1);
			System.out.println("列号："+colNO);			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			
		return cell;
	}
	
	
	/*
	 * 获得表格中某行某列的单元格中的某个页面的元素对象，by参数用于定位某个表格中的页面元素，例如，
	 * by.xpath("input[@type='text']")可以定义到表格中的输入框
	 */
	
	public WebElement getWebElementInCell(int rowNo,int colNO,By by) throws NoSuchElementException{
		WebElement cell=null;
		
		try {
			List<WebElement> tableRows = _table.findElements(By.tagName("tr"));
			//找到表格中的某一列，因为行号从0开始
			//例如要找第三行，则需要进行3-1的减法来获取第三行的行号，即2
			WebElement currentRow = tableRows.get(rowNo-1);
			List<WebElement> tablecols = currentRow.findElements(By.tagName("td"));
			
			/*
			 * 找到表格中的某一列，因为列号也从0开始，所以要找第三列，需要进行3-1的减法运算来获取
			 * 第三列的列号，即2.例如要查找第二列，则需进行2-1的减法来获取第二列的行号，即1
			 */
			cell = tablecols.get(colNO-1);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cell.findElement(by);
	}

}
