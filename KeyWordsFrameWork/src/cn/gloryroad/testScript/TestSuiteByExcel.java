package cn.gloryroad.testScript;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.lang.reflect.Method;
import cn.gloryroad.configuration.*;
import cn.gloryroad.util.*;
public class TestSuiteByExcel {
	
	public static Method method[];
	public static String keyword;
	public static String value;
	public static KeyWordsAction keyWordsaction;
	public static int testStep;
	public static int testLastStep;
	public static String testCaseID;
	public static String testCaseRunFlag;
	
	@Test
	public void testTestSuite() throws Exception{
		//����һ���ؼ��������ʵ��
		keyWordsaction = new KeyWordsAction();
		//ʹ��Java �ķ�����ƻ�ȡKeyWordsaction������з�������
		method = keyWordsaction.getClass().getMethods();
		
		//����Excel�ؼ��ļ���·��
		String excelFilePath=Constants.Path_ExcelFile;
		
		//�趨��ȡExcel�ļ��еġ������ʼ���SheetΪ����Ŀ��
		ExcelUtil.setExcelFile(excelFilePath);
		
		//��ȡ�������������ϡ�Sheet�еĲ�����������
		int testCasesCount = ExcelUtil.getRowCount(Constants.Sheet_TestSuite);
		//System.out.println("testCasesCount="+testCasesCount);
		//ʹ��forѭ����ִ�����б�ǡ�y���Ĳ�������
		for(int testCaseNo=1;testCaseNo<=testCasesCount;testCaseNo++){
			
			//��ȡ�������������ϡ�Sheet��ÿ�еĲ����������
			testCaseID= ExcelUtil.getCellData(Constants.Sheet_TestSuite,testCaseNo,Constants.Col_TestCaseID);
			System.out.println("testCaseID="+testCaseID);
			//��ȡ�������������ϡ�Sheet��ÿ�е��Ƿ��������е�ֵ
			testCaseRunFlag=ExcelUtil.getCellData(Constants.Sheet_TestSuite, testCaseNo,Constants.Col_RunFlag);
			System.out.println("testCaseRunFlag="+testCaseRunFlag);
			//����Ƿ��������е�ֵΪ��y��,��ִ�в��������е����в���
			if(testCaseRunFlag.equalsIgnoreCase("y")){
				//����־�д�ӡ����������ʼִ��
				Log.startTestCase(testCaseID);
				//�ڡ������ʼ���Sheet�У���ȡ��ǰҪִ�в��������ĵ�һ�������������к�
				System.out.println("hehe");
				testStep = ExcelUtil.getFirstRowContainsTestCaseID(Constants.Sheet_TestSteps, testCaseID, Constants.Col_TestCaseID);
				System.out.println("testStep="+testStep);
				//�ڡ������ʼ���Sheet�У���ȡ��ǰҪִ�в������������һ�������������к�
				testLastStep = ExcelUtil.getTestCaseLastStepRow(Constants.Sheet_TestSteps, testCaseID, testStep);
				System.out.println("testLastStep="+testLastStep);
				//�������������е����в��Բ���
				for(;testStep<testLastStep;testStep++){
					//�ӡ������ʼ���Sheet�ж�ȡ�ؼ��ֺͲ���ֵ������execute_Actions����
					keyword = ExcelUtil.getCellData(Constants.Sheet_TestSteps, testStep,Constants.Col_KeyWordAction);
					
					//����־�ļ��д�ӡ����ֵ��Ϣ
					Log.info("��Excel�ļ��ж�ȡ�Ĳ���ֵ��"+value);
					value= ExcelUtil.getCellData(Constants.Sheet_TestSteps, testStep,Constants.Col_ActionValue);
					
					execute_Actions();
					
				}
				
				//����־�д�ӡ��������ִ�����
				Log.endTestCase(testCaseID);
				
			}
			
			
			
		}
		
		
		
	}
	
			
	private static void execute_Actions(){
		
		try{
			
			for(int i =0; i< method.length; i++){
				/*
				 * ʹ�÷���ķ�ʽ���ҵ��ؼ��ֶ�Ӧ�Ĳ��Է�������ʹ��value(����ֵ)
				 * ��Ϊ���Է����ĺ���ֵ���е���
				 */
				
				if(method[i].getName().equals(keyword)){
					method[i].invoke(keyWordsaction, value);
					
					break;
				}
			}
			
		} catch(Exception e){
			//���ò��Է��������У��������쳣���򽫲����趨Ϊ�ǲ�״̬��ֹͣ��������ִ��
			Assert.fail("ִ�г����쳣����������ִ��ʧ��");
		}
	}		
	
	@BeforeClass
	public void BeforeClass(){
		//����Log4j�������ļ�Ϊlog4j.xml
		DOMConfigurator.configure("log4j.xml");
	}
	

}


