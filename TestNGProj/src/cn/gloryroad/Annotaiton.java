package cn.gloryroad;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotaiton {
	@Test
	public void testCase1(){
		
		System.out.println("��������1��ִ��");
	}
	
	@Test
	public void testCase2(){
		
		System.out.println("��������2��ִ��");
	}
	
	@BeforeMethod
	public void beforeMethod(){
		
		System.out.println("��ÿ�����Է�����ʼ����ǰִ��");
	}
	
	@AfterMethod
	public void afterMethod(){
		
		System.out.println("��ÿ�����Է���������ִ��");
	}
	
	@BeforeClass
	public void beforeClass(){
		
		System.out.println("�ڵ�ǰ������ĵ�һ�����Է�����ʼ����ǰִ��");
	}
	
	@AfterClass
	public void afterClass(){
		
		System.out.println("�ڵ�ǰ����������һ�����Է����������к�ִ��");
	}
	
	@BeforeTest
	public void beforeTest(){
		
		System.out.println("�ڲ������е�Test��ʼ����ǰִ��");
	}
	
	@AfterTest
	public void afterTest(){
		
		System.out.println("�ڲ������е�Test���н�����ִ��");
	}
	
	@BeforeSuite
	public void beforeSuite(){
		
		System.out.println("�ڵ�ǰ���Լƻ�(Suite)�е����в��Գ���ʼ����֮ǰ��ɲ���");
	}
	
	@AfterSuite
	public void afterSuite(){
		
		System.out.println("�ڵ�ǰ���Լƻ�(Suite)�е����в��Գ������н���֮����ɲ���");
	}

}
