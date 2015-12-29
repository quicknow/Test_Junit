package cn.gloryroad.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUitl {
	//���ڲ���ִ�й�������ͣ����ִ�е����߷���
	public static void sleep(long millisecond){
		
		try{
			//�߳�����millisecond��������ĺ�����
			Thread.sleep(millisecond);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//��ʽ�ȴ�ҳ��Ԫ�س��ֵķ�װ����������Ϊҳ��Ԫ�ص�XPath��λ�ַ���
	public static void waitWebElement(WebDriver driver,String xpathExpression){
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		//����ExpectedCondititons��presenceOfElementLocated �����ж�ҳ��Ԫ���Ƿ����
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathExpression)));
	}
	
	//��ʽ�ȴ�ҳ��Ԫ�س��ֵķ�װ����������Ϊ��ʾҳ��Ԫ�ص�By���󣬴˺�������֧�ָ��ඨλ���ʽ
	public static void waitWebElement(WebDriver driver, By by){
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		//����ExpectedConditions ��presenceOfElementLocated�����ж�ҳ��Ԫ���Ƿ����
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}

}
