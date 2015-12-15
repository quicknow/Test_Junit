package cn.gloryroad;

//练习按顺序执行方法的注解
import org.testng.annotations.Test;

public class SequenceTest {
	@Test(priority = 2)
	public void test3(){
		System.out.println("test3方法被调用");
	}
	
	@Test(priority = 3)
	public void test4(){
		System.out.println("test4方法被调用");
	}
	
	@Test(priority = 0)
	public void test1(){
		System.out.println("test1方法被调用");
	}
	//跳过该方法
	@Test(priority = 1,enabled=false)
	public void test2(){
		System.out.println("test2方法被调用");
	}
	
}
