package cn.gloryroad;

//依赖注解的运行测试
import org.testng.annotations.Test;

public class DependentTest {

	@Test(dependsOnMethods= {"OpenBrowser"})
	public void SignIn(){
		
		System.out.println("SignIn 方法被调用");
	}
	
	@Test
	public void OpenBrowser(){
		System.out.println("OpenBrowser方法被调用");
	}
	@Test (dependsOnMethods = {"SignIn"})
	public void LogOut(){
		System.out.println("LogOut方法被调用");
	}
	
}
