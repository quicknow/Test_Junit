package cn.gloryroad.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(xpath="//*[@id='idPlaceholder']")
	public WebElement userName;
	
	@FindBy(xpath="//*[@id='pwdInput']")
	public WebElement password;
	
	@FindBy(xpath="//*[@id='loginBtn']")
	public WebElement loginButton;
	
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}


}
