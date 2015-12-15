package cn.gloryroad.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	
	public static void setExcelFile(String Path, String SheetName) throws Exception {
		
		FileInputStream ExcelFile;
		try{
			//ʵ����Excel�ļ���FileInputStream����
			ExcelFile = new FileInputStream(Path);
			
			//ʵ����Excel�ļ��е�XSSFWorkbook����
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			/*
			 * ʵ����XSSFSheet����ָ��Excel�ļ��е�Sheet���ƣ���������Sheet���С��к͵�Ԫ��Ĳ���
			 */
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
		} catch(Exception e){
			throw(e);
		}	
	}
	
	//��ȡExcel�ļ�ָ����Ԫ��ĺ���
	public static String getCellData(int RowNum, int ColNum) throws Exception{
		try{
			//ͨ����������ָ����Ԫ����кź��кţ���ȡָ���ĵ�Ԫ�����
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			/*
			 * �����Ԫ�������Ϊ�ַ������ͣ���ʹ��getStringCellValue������ȡ��Ԫ�������
			 * �����Ԫ�������Ϊ�������ͣ���ʹ��getNumericeCellValue()������ȡ��Ԫ�������
			 * ע��getNumericeCellValue��������ֵΪdouble���ͣ�����ת���ַ�������
			 * ��Cell.getNumericeCellValue()ǰ�����ӡ���,����ǿ��ת��double���͵�
			 * String����,���ӡ��� ����׳�double�����޷�ת����String���͵��쳣
			 */
			String CellData=Cell.getCellType()==XSSFCell.CELL_TYPE_STRING? Cell
					.getStringCellValue()+""
					:String.valueOf(Math.round(Cell.getNumericCellValue()));
			return CellData;
		} catch(Exception e){
			return "";
		}
	}
	
	public static void setCellData(int RowNum,int ColNum, String Result) throws Exception{
		try{
			Row = ExcelWSheet.getRow(RowNum);
			Cell = Row.getCell(ColNum,Row.RETURN_BLANK_AS_NULL);
			
			if(Cell == null){
				Cell = Row.createCell(ColNum);
				
				Cell.setCellValue(Result);
			} else{
				Cell.setCellValue(Result);
			}
			
			FileOutputStream fileOut = new FileOutputStream(Constant.TestDataExcelFilePath);
			ExcelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch(Exception e){
			throw (e);
		}
	}
}
