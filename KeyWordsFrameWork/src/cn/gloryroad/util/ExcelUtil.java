package cn.gloryroad.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cn.gloryroad.configuration.Constants;
import cn.gloryroad.testScript.TestSuiteByExcel;

//������Ҫʵ����չ��Ϊ.xlsx��Excel�ļ�����
public class ExcelUtil {
	
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	
	
	//�趨Ҫ������Excel���ļ�·��
		public static void setExcelFile(String Path){
			
			FileInputStream ExcelFile;
			try{
				//ʵ����Excel �ļ���FileInputSteam����
				ExcelFile = new FileInputStream(Path);
				
				//ʵ����Excel�ļ���XSSFWorkbook����
				ExcelWBook = new XSSFWorkbook(ExcelFile);
			} catch(Exception e){
				TestSuiteByExcel.testResult=false;
				System.out.println("Excel·���趨ʧ��");
				e.printStackTrace();
			} 
			
		}
	
	//�趨Ҫ������Excel���ļ�·����Excel�ļ��е�Sheet����
	//�ڶ�/дExcel�ļ���ʱ�򣬾���Ҫ�ȵ��ô˷������趨Ҫ������Excel�ļ�·����Ҫ������Sheet����
	
	public static void setExcelFile(String Path, String SheetName){
		
		FileInputStream ExcelFile;
		
		try{
			//ʵ����Excel�ļ���FileInputStream����
			ExcelFile = new FileInputStream(Path);
			
			//ʵ����Excel �ļ���XSSFWorkbook����
			ExcelWSheet = ExcelWBook.getSheet(SheetName);			
		} catch(Exception e) {
			TestSuiteByExcel.testResult=false;
			System.out.println("Excel·���趨ʧ��");
			e.printStackTrace();
		}
		
	}
	
	
	
	
	//��ȡָ��Sheet�е�ָ����Ԫ�������˺���ֻ֧����չ��Ϊ.xlsx��Excel�ļ�
	public static String getCellData(String SheetName, int RowNum,int ColNum) {
		
		ExcelWSheet = ExcelWBook.getSheet(SheetName);
		try{
			//ͨ����������ָ����Ԫ����кź��кţ���ȡָ���ĵ�Ԫ�����
			Cell =ExcelWSheet.getRow(RowNum).getCell(ColNum);
			//�����Ԫ�������Ϊ�ַ������ͣ���ʹ��getStringCellValue������ȡ��Ԫ�������
			//�����Ԫ�������Ϊ�������ͣ���ʹ��getNumericeCellValue������ȡ��Ԫ�������
			String CellData = Cell.getCellType()==XSSFCell.CELL_TYPE_STRING?Cell.getStringCellValue()+""
					: String.valueOf(Math.round(Cell.getNumericCellValue()));
			//System.out.println("yyyeeeehehe-CellData="+CellData);
			//��������ָ����Ԫ����ַ�������
			return CellData;
			
		} catch(Exception e){
			TestSuiteByExcel.testResult=false;						
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
	
	//��ȡָ��Sheet�е�������
	public static int getRowCount(String SheetName){
		
		//System.out.println(SheetName);
		
		
		ExcelWSheet = ExcelWBook.getSheet(SheetName);
		int number = ExcelWSheet.getLastRowNum();
		//System.out.println(number);
		return number;
	}
	
   //��Excel��ָ��Sheet�У���ȡ��һ�ΰ���ָ����������������ֵ��к�
	public static int getFirstRowContainsTestCaseID(String sheetName,String testCaseName,int colNum){
		
		int i;
		try {
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
		} catch (Exception e) {
			TestSuiteByExcel.testResult=false;						
			e.printStackTrace();
			//��ȡ�����쳣���򷵻ؿ��ַ���
			return 0;
		}
	}
	
	//��ȡָ��Sheet��ĳ��������������ĸ���
	public static int getTestCaseLastStepRow(String SheetName,String testCaseID,int testCaseStartRowNumber) {
		
		try {
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
		} catch (Exception e) {
			TestSuiteByExcel.testResult=false;						
			e.printStackTrace();
			//��ȡ�����쳣���򷵻ؿ��ַ���
			return 0;
		}
	}
	
	//��Excel�ļ���ִ�е�Ԫ����д�����ݣ��˺���ֻ֧����չ��Ϊ.xlsx��Excel�ļ�д��
	public static void setCellData(String SheetName, int RowNum, int ColNum, String Result){
		ExcelWSheet = ExcelWBook.getSheet(SheetName);
		
		try{
			//��ȡExcel�ļ��е��ж���
			Row = ExcelWSheet.getRow(RowNum);
			
			//�����Ԫ��Ϊ�գ��򷵻�Null
			Cell = Row.getCell(ColNum,Row.RETURN_BLANK_AS_NULL);
			
			if(Cell==null){
			//����Ԫ�������Null��ʱ���򴴽���Ԫ��
			//�����Ԫ��Ϊ�գ��޷�ֱ�ӵ��õ�Ԫ������setCellValue�����趨��Ԫ���ֵ
				Cell = Row.createCell(ColNum);
			//������Ԫ�����Ե��õ�Ԫ������setCellValue�����趨��Ԫ���ֵ
				Cell.setCellValue(Result);
				
			} else{
			//��Ԫ���������ݣ������ֱ�ӵ��õ�Ԫ������setCellValue�����趨��Ԫ���ֵ
				Cell.setCellValue(Result);				
			}
			
			//ʵ����д��Excel�ļ����ļ����������
			FileOutputStream fileOut = new FileOutputStream(Constants.Path_ExcelFile);
			
			//������д��Excel�ļ���
			ExcelWBook.write(fileOut);
			//����flush����ǿ��ˢ��д���ļ�
			fileOut.flush();
			
			//�ر��ļ����������
			fileOut.close();
			
			
		} catch(Exception e){
			TestSuiteByExcel.testResult=false;
			e.printStackTrace();
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
	


}
