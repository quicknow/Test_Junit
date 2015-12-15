package cn.gloryroad;

//����ע������в���
import org.testng.annotations.Test;

public class DependentTest {

	@Test(dependsOnMethods= {"OpenBrowser"})
	public void SignIn(){
		
		System.out.println("SignIn ����������");
	}
	
	@Test
	public void OpenBrowser(){
		System.out.println("OpenBrowser����������");
	}
	@Test (dependsOnMethods = {"SignIn"})
	public void LogOut(){
		System.out.println("LogOut����������");
	}
	
}
