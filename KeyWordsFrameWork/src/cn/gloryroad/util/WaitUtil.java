package cn.gloryroad.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {
	//���ڲ���ִ�й�������ͣ����ִ�е����߷���
	public static void sleep(long millisecond){
		try{
			//�߳�����millisecond ��������ĺ�����
			Thread.sleep(millisecond);			
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//��ʾ�ȴ�ҳ��Ԫ�س��ֵķ�װ����������Ϊҳ��Ԫ�ص�XPath ��λ�ַ���
	public static void waitWebElement(WebDriver driver, String xpathExpression){
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		//����ExpectedConditons ��presenceOfElementLocated �����ж�ҳ��Ԫ���Ƿ����
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathExpression)));
		
	}

}
