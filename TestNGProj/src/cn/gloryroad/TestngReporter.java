package cn.gloryroad;
import org.testng.annotations.Test;
import org.testng.Reporter;

public class TestngReporter {

	@Test
	public void OpenBrowser(){
		System.out.println("OpenBrowser����������");
		Reporter.log("���ô�������ķ���");;
	}
	
	@Test
	public void SignIn(){
		System.out.println("Sigin ���������ã�");
		Reporter.log("���õ�½����");		
	}
	
	@Test
	public void Logout(){
		
		System.out.println("LogOut����������");
		Reporter.log("����ע������");
	}
}
