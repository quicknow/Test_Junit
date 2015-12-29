package cn.gloryroad.testScript;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.lang.reflect.Method;
import cn.gloryroad.configuration.*;
import cn.gloryroad.util.*;

public class TestSendMailWithAttachmentByExcel {
	
	public static Method method[];
	public static String keyword;
	public static String value;
	public static KeyWordsAction keyWordsaction;
	
	@Test
	public void testSendmailWithAttachment() throws Exception{
		//声明一个关键动作类的实例
		keyWordsaction = new KeyWordsAction();
		
		//使用Java的发射机制获取KeyWordsactoion类的所有方法对象
		method = keyWordsaction.getClass().getMethods();
		
		//定义Excel关键文件的路径
		String excelFilePath = "F:\\selenium_java\\Test_Junit\\KeyWordsFrameWork\\src\\cn\\gloryroad\\data\\关键字驱动测试用例.xlsx";
		
		//设定读取Excel文件中的“发送邮件” Sheet 为操作目标
		ExcelUtil.setExcelFile(excelFilePath, "发送邮件");
		
		/*
		 * 从Excel文件的“发送邮件” Sheet中，将每一行的第四列读取出来作为关键字信息
		 * 通过遍历比较的方法，执行关键字在KeyWordsAction类中对应的映射方法。从Excel
		 * 文件的“发送邮件”Sheet中，将每一行的第五列读取出来作为映射方法的函数参数，调用execute_Actions函数完成映射方法的调用执行过程
		 * 
		 */
		
		for(int iRow=1;iRow<=ExcelUtil.getLastRowNum();iRow++){
			//读取Excel文件Sheet中的第四列
			keyword = ExcelUtil.getCellData(iRow, 3);
			
			//读取Excel文件Sheet中的第五列
			value = ExcelUtil.getCellData(iRow, 4);
			execute_Actions();
			
		}
		
		private static void execute_Actions(){
			try{
				for(int i =0;i<method.length;i++){
					//通过遍历，判断关键字和KeyWordsaction类中的哪个方法名称一致
					if(method[i].getName().equals(keyword)){
						//找到KeyWordsaction类中的映射方法会，通过调用invoke方法完成函数调用
						method[i].invoke(keyWordsaction, value);
						
						break;
					}
				}
			} catch(Exception e){
				//执行中出现异常，则将测试用例设定为失败状态
				Assert.fail("执行异常，测试用例执行失败");
			}
		}
		
		
	}

}
