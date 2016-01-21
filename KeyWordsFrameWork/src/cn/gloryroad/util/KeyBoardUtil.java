package cn.gloryroad.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;


public class KeyBoardUtil {
	//��Tab���ķ�װ����
	public static void pressTabKey(){
		Robot robot =null;
		try{
			
			robot = new Robot();
			
		} catch(AWTException e){
			e.printStackTrace();
		}
		
		//����keyPress ������ʵ�ְ���Tab��
		robot.keyPress(KeyEvent.VK_TAB);
		
		//����keyRelease ������ʵ���ͷ�Tab��
		robot.keyPress(KeyEvent.VK_TAB);
		
	}
	
	//��Enter���ķ�װ����
	public static void pressEnterKey(){
		Robot robot = null;
		
		try{
			robot = new Robot();
		} catch(AWTException e){
			
			e.printStackTrace();
		}
		
		//����keyPress ������ʵ�ְ���Tab��
		robot.keyPress(KeyEvent.VK_ENTER);
				
		//����keyRelease ������ʵ���ͷ�Tab��
		robot.keyPress(KeyEvent.VK_ENTER);
	}
	
	/*
	 * ��ָ���ַ�����Ϊ���а�����ݣ�Ȼ��ִ���������
	 * ��ҳ�潹���л��������󣬵��ô˺������Խ�ָ���ַ���������������
	 */
	
	public static void setAndctrlVClipboardData(String string){
		
		StringSelection stringSelection = new StringSelection(string);
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		
		Robot robot = null;
		
		try{
			
			robot = new Robot();
		} catch(AWTException e1){
			e1.printStackTrace();
		}
		
		//����4�д����ʾ���º��ͷ�Ctrl + V ��ϼ�
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}

}
