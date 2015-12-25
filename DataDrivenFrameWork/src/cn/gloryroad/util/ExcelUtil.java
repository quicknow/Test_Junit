package cn.gloryroad.util;

import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

public class ExcelUtil {
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	
	public static void setExcelFile(String Path, String SheetName) throws IOException {
		
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
			 * String类型,不加“” 则会抛出double类型无法转换到String类型的异常 :String.valueOf(Math.round(Cell.getNumericCellValue()
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
		
		
	public static Object[][] getTestData(String excelFilePath,String sheetName) throws Exception{
			
			File file= new File(excelFilePath);
			
			FileInputStream inputStream = new FileInputStream(file);
			
			Workbook Workbook = null;
			String fileExtensionName= excelFilePath.substring(excelFilePath.indexOf("."));
			
			if(fileExtensionName.equals(".xlsx")){
				Workbook = new XSSFWorkbook(inputStream);
			} else if(fileExtensionName.equals(".xls")){
				Workbook = new HSSFWorkbook(inputStream);
			}
			
			
			Sheet Sheet = Workbook.getSheet(sheetName);
			
			int rowCount=Sheet.getLastRowNum() - Sheet.getFirstRowNum();
			
			List<Object[]> records = new ArrayList<Object[]>();
			
			for(int i = 1;i<rowCount+1;i++){
				Row row = Sheet.getRow(i);
				
				String fields[]=new String[row.getLastCellNum()-2];
				
				//String.valueOf(Math.round(Cell.getNumericCellValue()))
				if(row.getCell(row.getLastCellNum()-2).getStringCellValue().equals("y")){
					for(int j = 0 ;j<row.getLastCellNum()-2; j++){
						fields[j] = (String)(row.getCell(j).getCellType()==XSSFCell.CELL_TYPE_STRING?
								row.getCell(j).getStringCellValue():String.valueOf(Math.round(row.getCell(j).getNumericCellValue())));
					}
					
					records.add(fields);
				}
				
			}
			
				Object[][] results = new Object[records.size()][];
				
				for(int i = 0;i<records.size();i++){
					results[i]= records.get(i);
				}
				
				return results;
			}
			
			public static int getLastColumnNum(){
				return ExcelWSheet.getRow(0).getLastCellNum()-1;
			}
			
			
}
		
		
	

