package cn.gloryroad.util;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//������Ҫʵ����չ��Ϊ.xlsx��Excel�ļ�����
public class ExcelUtil {
	
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	
	//�趨Ҫ������Excel���ļ�·����Excel�ļ��е�Sheet����
	//�ڶ�/дExcel�ļ���ʱ�򣬾���Ҫ�ȵ��ô˷������趨Ҫ������Excel�ļ�·����Ҫ������Sheet����
	
	public static void setExcelFile(String Path, String SheetName) throws Exception{
		
		FileInputStream ExcelFile;
		
		try{
			//ʵ����Excel�ļ���FileInputStream����
			ExcelFile = new FileInputStream(Path);
			
			//ʵ����Excel �ļ���XSSFWorkbook����
			ExcelWSheet = ExcelWBook.getSheet(SheetName);			
		} catch(Exception e) {
			throw (e);
		}
		
	}
	
	//��ȡExcel �ļ�ָ����Ԫ��ĺ������˺���ֻ֧����չ��Ϊ.xlsx��Excel�ļ�
	public static String getCellData(int RowNum, int ColNum) throws Exception{
		try{
			//ͨ����������ָ����Ԫ����кź��кţ���ȡָ���ĵ�Ԫ�����
			
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			//�����Ԫ�������Ϊ�ַ������ͣ���ʹ��getStringCellValue������ȡ��Ԫ�������
			//�����Ԫ�������Ϊ�������ͣ���ʹ��getNumericCellValue������ȡ��Ԫ�������			
			String CellData=Cell.getCellType()==XSSFCell.CELL_TYPE_STRING? Cell
					.getStringCellValue()+""
					:String.valueOf(Math.round(Cell.getNumericCellValue()));
			//��������ָ����Ԫ����ַ�������
			return CellData;			
		} catch(Exception e) {
			e.printStackTrace();
			//��ȡ�����쳣���򷵻ؿ��ַ���
			return "";
		}
	}
	
	//��ȡExcel�ļ����һ�е��к�
	public static int getLastRowNum(){
		//��������Sheet�����һ�е��к�
		return ExcelWSheet.getLastRowNum();
		
	}

}
