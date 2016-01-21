package cn.gloryroad.util;

import java.io.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;

public class ObjectMap {
	//Properties��������ɶ�ģ�
	Properties properties;
	public ObjectMap(String propFile){
		
		 properties = new Properties();
		try{
			System.out.println(propFile);
			//InputStream in = new BufferedInputStream (new FileInputStream(propFile));
			FileInputStream in = new FileInputStream(propFile);
			properties.load(in);		
			
			in.close();
		} catch(IOException e){
			System.out.println("��ȡ�����ļ�����");
			e.printStackTrace();
		}
	}
	
	public By getLocator(String ElementNameInpropFile) throws Exception{
		String locator = properties.getProperty(ElementNameInpropFile);
		String locatorType = locator.split(">")[0];
		String locatorValue= locator.split(">")[1];
		
		
		/*��Eclipse�е������ļ���Ĭ��ΪISO-8859-1����洢��ʹ��getBytes�������Խ��ַ�������ת��ΪU
		 * TF-8���룬�Դ�������������ļ���ȡ�������������
		 */
		locatorValue = new String(locatorValue.getBytes("ISO-8859-1"),"UTF-8");
		
		//System.out.println("�ܷ��ӡ�����أ��뿴��"+locatorValue);
		//locatorValue = new String(locatorValue.getBytes("ISO-8859-1"),"GBK");
		System.out.println("��ȡ�Ķ�λ���ͣ�"+ locatorType+"\t ��ȡ�Ķ�λ���ʽ"+locatorValue);
		
		if(locatorType.toLowerCase().equals("id"))
			return By.id(locatorValue);
		else if(locatorType.toLowerCase().equals("name"))
			return By.name(locatorValue);
		else if((locatorType.toLowerCase().equals("Classname"))||(locatorType.toLowerCase().equals("class")))
			return By.className(locatorValue);
		else if((locatorType.toLowerCase().equals("tagname"))||(locatorType.toLowerCase().equals("tag")))
			return By.className(locatorValue);
		else if((locatorType.toLowerCase().equals("linkText"))||(locatorType.toLowerCase().equals("link")))
			return By.linkText(locatorValue);
		else if(locatorType.toLowerCase().equals("partiallinktext"))
			return By.partialLinkText(locatorValue);
		else if((locatorType.toLowerCase().equals("cssselector"))||(locatorType.toLowerCase().equals("css")))
			return By.cssSelector(locatorValue);
		else if(locatorType.toLowerCase().equals("xpath"))
			return By.xpath(locatorValue);
		else
			throw new Exception("�����locator type δ�ڳ����ж��壺"+locatorType);		
	}
}
