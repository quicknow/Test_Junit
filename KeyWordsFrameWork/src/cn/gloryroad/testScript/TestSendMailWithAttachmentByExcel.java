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
		//����һ���ؼ��������ʵ��
		keyWordsaction = new KeyWordsAction();
		
		//ʹ��Java�ķ�����ƻ�ȡKeyWordsactoion������з�������
		method = keyWordsaction.getClass().getMethods();
		
		//����Excel�ؼ��ļ���·��
		String excelFilePath = "F:\\selenium_java\\Test_Junit\\KeyWordsFrameWork\\src\\cn\\gloryroad\\data\\�ؼ���������������.xlsx";
		
		//�趨��ȡExcel�ļ��еġ������ʼ��� Sheet Ϊ����Ŀ��
		ExcelUtil.setExcelFile(excelFilePath, "�����ʼ�");
		
		/*
		 * ��Excel�ļ��ġ������ʼ��� Sheet�У���ÿһ�еĵ����ж�ȡ������Ϊ�ؼ�����Ϣ
		 * ͨ�������Ƚϵķ�����ִ�йؼ�����KeyWordsAction���ж�Ӧ��ӳ�䷽������Excel
		 * �ļ��ġ������ʼ���Sheet�У���ÿһ�еĵ����ж�ȡ������Ϊӳ�䷽���ĺ�������������execute_Actions�������ӳ�䷽���ĵ���ִ�й���
		 * 
		 */
		
		for(int iRow=1;iRow<=ExcelUtil.getLastRowNum();iRow++){
			//��ȡExcel�ļ�Sheet�еĵ�����
			keyword = ExcelUtil.getCellData(iRow, 3);
			
			//��ȡExcel�ļ�Sheet�еĵ�����
			value = ExcelUtil.getCellData(iRow, 4);
			execute_Actions();
			
		}
		
		private static void execute_Actions(){
			try{
				for(int i =0;i<method.length;i++){
					//ͨ���������жϹؼ��ֺ�KeyWordsaction���е��ĸ���������һ��
					if(method[i].getName().equals(keyword)){
						//�ҵ�KeyWordsaction���е�ӳ�䷽���ᣬͨ������invoke������ɺ�������
						method[i].invoke(keyWordsaction, value);
						
						break;
					}
				}
			} catch(Exception e){
				//ִ���г����쳣���򽫲��������趨Ϊʧ��״̬
				Assert.fail("ִ���쳣����������ִ��ʧ��");
			}
		}
		
		
	}

}
