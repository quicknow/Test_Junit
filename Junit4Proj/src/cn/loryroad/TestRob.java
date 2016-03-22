package cn.loryroad;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


public class TestRob {
	
	public static void Paste(String str){
		
		StringSelection ss = new StringSelection(str);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		Robot rb=null;
		
		try {
			rb = new Robot();
		
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		
		/*
		rb.delay(500);
		rb.keyPress(KeyEvent.VK_ENTER);		
		rb.keyRelease(KeyEvent.VK_ENTER);*/
	}
	
	public static void PressEnter(){
		
		//ע��ʹ�þ�̬�ĺ����Ļ���Robot �ı��������ܺ������һ��������᲻��Ч
		Robot rb2=null;
		
		try {
			rb2 = new Robot();
		
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rb2.keyPress(KeyEvent.VK_ENTER);		
		//rb.delay(100);
		rb2.keyRelease(KeyEvent.VK_ENTER);
		System.out.println("ִ����Enter��");
		
	}
	
	public static void PressTab(){
		
		Robot rb=null;
		
		try {
			rb = new Robot();
		
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		
	}
	
	

}
