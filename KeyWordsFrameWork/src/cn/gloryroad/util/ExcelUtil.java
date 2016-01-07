package cn.gloryroad.util;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cn.gloryroad.configuration.Constants;

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
	
	//�趨Ҫ������Excel���ļ�·��
	public static void setExcelFile(String Path){
		
		FileInputStream ExcelFile;
		try{
			//ʵ����Excel �ļ���FileInputSteam����
			ExcelFile = new FileInputStream(Path);
			
			//ʵ����Excel�ļ���XSSFWorkbook����
			ExcelWBook = new XSSFWorkbook(ExcelFile);
		} catch(Exception e){
			System.out.println("Excel·���趨ʧ��");
			e.printStackTrace();
		}
	}
	
	
	//��ȡָ��Sheet�е�ָ����Ԫ�������˺���ֻ֧����չ��Ϊ.xlsx��Excel�ļ�
	public static String getCellData(String SheetName, int RowNum,int ColNum) throws Exception{
		
		ExcelWSheet = ExcelWBook.getSheet(SheetName);
		try{
			//ͨ����������ָ����Ԫ����кź��кţ���ȡָ���ĵ�Ԫ�����
			Cell =ExcelWSheet.getRow(RowNum).getCell(ColNum);
			//�����Ԫ�������Ϊ�ַ������ͣ���ʹ��getStringCellValue������ȡ��Ԫ�������
			//�����Ԫ�������Ϊ�������ͣ���ʹ��getNumericeCellValue������ȡ��Ԫ�������
			String CellData = Cell.getCellType()==XSSFCell.CELL_TYPE_STRING?Cell.getStringCellValue()+""
					: String.valueOf(Math.round(Cell.getNumericCellValue()));
			
			//��������ָ����Ԫ����ַ�������
			return CellData;
			
		} catch(Exception e){
			e.printStackTrace();
			//��ȡ�����쳣���򷵻ؿ��ַ���
			return "";
		}
		
	}
	
	//��ȡָ��Sheet�е�������
	public static int getRowCount(String SheetName){
		
		//System.out.println(SheetName);
		ExcelWSheet = ExcelWBook.getSheet(SheetName);
		int number = ExcelWSheet.getLastRowNum();
		//System.out.println(number);
		return number;
	}
	
   //��Excel��ָ��Sheet�У���ȡ��һ�ΰ���ָ����������������ֵ��к�
	public static int getFirstRowContainsTestCaseID(String sheetName,String testCaseName,int colNum) throws Exception{
		
		int i;
		ExcelWSheet = ExcelWBook.getSheet(sheetName);
		int rowCount = ExcelUtil.getRowCount(sheetName);
		for(i=0;i<rowCount;i++){
			//ʹ��ѭ���ķ�������������������е������У��ж��Ƿ����ĳ������������Źؼ���
			if(ExcelUtil.getCellData(sheetName,i,colNum).equalsIgnoreCase(testCaseName)){
				//������������˳�forѭ���������ذ�������������Źؼ��ֵ��к�
				break;
			}
		}
		
		return i;
	}
	
	//��ȡָ��Sheet��ĳ��������������ĸ���
	public static int getTestCaseLastStepRow(String SheetName,String testCaseID,int testCaseStartRowNumber) throws Exception{
		
		ExcelWSheet = ExcelWBook.getSheet(SheetName);
		/*
		 * �Ӱ���ָ������������ŵĵ�һ�п�ʼ���б�����ֱ��ĳһ�в�����ָ�������������
		 * ��ʱ�ı������Ծ��Ǵ˲�����������ĸ���
		 * 
		 */
		
		for(int i=testCaseStartRowNumber;i<=ExcelUtil.getRowCount(SheetName)-1;i++){
			
			if(!testCaseID.equals(ExcelUtil.getCellData(SheetName,i,Constants.Col_TestCaseID))){
				
				int number=i;
				return number;
			}
		}
		
		int number = ExcelWSheet.getLastRowNum()+1;
		return number;
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
