package cn.gloryroad;

//��ϰ��˳��ִ�з�����ע��
import org.testng.annotations.Test;

public class SequenceTest {
	@Test(priority = 2)
	public void test3(){
		System.out.println("test3����������");
	}
	
	@Test(priority = 3)
	public void test4(){
		System.out.println("test4����������");
	}
	
	@Test(priority = 0)
	public void test1(){
		System.out.println("test1����������");
	}
	//�����÷���
	@Test(priority = 1,enabled=false)
	public void test2(){
		System.out.println("test2����������");
	}
	
}
