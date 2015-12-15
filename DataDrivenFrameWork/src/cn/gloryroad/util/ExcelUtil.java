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
			//实例化Excel文件的FileInputStream对象
			ExcelFile = new FileInputStream(Path);
			
			//实例化Excel文件中的XSSFWorkbook对象
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			/*
			 * 实例化XSSFSheet对象，指定Excel文件中的Sheet名称，后续用于Sheet中行、列和单元格的操作
			 */
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
		} catch(Exception e){
			throw(e);
		}	
	}
	
	//读取Excel文件指定单元格的函数
	public static String getCellData(int RowNum, int ColNum) throws Exception{
		try{
			//通过函数参数指定单元格的行号和列号，获取指定的单元格对象
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			/*
			 * 如果单元格的内容为字符串类型，则使用getStringCellValue方法获取单元格的内容
			 * 如果单元格的内容为数字类型，则使用getNumericeCellValue()方法获取单元格的内容
			 * 注意getNumericeCellValue方法返回值为double类型，必须转换字符串类型
			 * 在Cell.getNumericeCellValue()前面增加“”,用于强制转换double类型到
			 * String类型,不加“” 则会抛出double类型无法转换到String类型的异常
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
