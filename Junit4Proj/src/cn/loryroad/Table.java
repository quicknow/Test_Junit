package cn.loryroad;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class Table {
	
	//����һ��WebElement�������ڴ洢ҳ��ı��Ԫ�ض���
	private WebElement _table;
	
	//Ϊ���캯������ҳ����Ԫ�ض������������Table���setTable��������ҳ����Ԫ�ظ�ֵ��Table���_table��Ա����
	public Table(WebElement table){
		setTable(table);
		
	}
	
	//��ȡҳ�������ķ���
	public WebElement getTable(){
		return _table;
	}
	
	//��ҳ����Ԫ�ظ�ֵ��Table����_Table��Ա�����ķ���
	public void setTable(WebElement _table){
		this._table=_table;
	}
	
	//��ȡ���Ԫ�ص����������ұ��Ԫ���м���trԪ��
	//�м���trԪ�أ��Ϳ���֪������м��У�tr�����ͱ������һ��
	public int getRowCount(){
		List<WebElement> tableRows= _table.findElements(By.tagName("tr"));
		return tableRows.size();
	}
	
	//��ȡ���Ԫ�ص�����
	//ʹ��get(0)��������ȡ������һ�е�Ԫ�أ������м�����td��,td����������һ��
	public int getColumnCount(){
		List<WebElement> tableRows = _table.findElements(By.tagName("tr"));
		return tableRows.get(0).findElements(By.tagName("td")).size();
	}
	
	//��ȡ�����ĳ��ĳ�еĵ�Ԫ�����
	public WebElement getCell(int rowNo, int colNO) throws NoSuchElementException{
		WebElement cell=null;  
		
		try {
			
			List<WebElement> tableRows = _table.findElements(By.tagName("tr"));
			System.out.println("������"+tableRows.size());
			System.out.println("�кţ�"+rowNo);
			WebElement currentRow= tableRows.get(rowNo-1);
			
			List<WebElement> tablecols = currentRow.findElements(By.tagName("td"));
			System.out.println("��������"+tablecols.size());
			
			cell= tablecols.get(colNO-1);
			System.out.println("�кţ�"+colNO);			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			
		return cell;
	}
	
	
	/*
	 * ��ñ����ĳ��ĳ�еĵ�Ԫ���е�ĳ��ҳ���Ԫ�ض���by�������ڶ�λĳ������е�ҳ��Ԫ�أ����磬
	 * by.xpath("input[@type='text']")���Զ��嵽����е������
	 */
	
	public WebElement getWebElementInCell(int rowNo,int colNO,By by) throws NoSuchElementException{
		WebElement cell=null;
		
		try {
			List<WebElement> tableRows = _table.findElements(By.tagName("tr"));
			//�ҵ�����е�ĳһ�У���Ϊ�кŴ�0��ʼ
			//����Ҫ�ҵ����У�����Ҫ����3-1�ļ�������ȡ�����е��кţ���2
			WebElement currentRow = tableRows.get(rowNo-1);
			List<WebElement> tablecols = currentRow.findElements(By.tagName("td"));
			
			/*
			 * �ҵ�����е�ĳһ�У���Ϊ�к�Ҳ��0��ʼ������Ҫ�ҵ����У���Ҫ����3-1�ļ�����������ȡ
			 * �����е��кţ���2.����Ҫ���ҵڶ��У��������2-1�ļ�������ȡ�ڶ��е��кţ���1
			 */
			cell = tablecols.get(colNO-1);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cell.findElement(by);
	}

}
