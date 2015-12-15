package cn.gloryroad.pageobjects3;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage extends LoadableComponent<LoginPage>{
	@FindBy(xpath="//*[@id='idInput']")
	public WebElement userName;
	@FindBy(xpath="//*[@id='pwdInput']")
	public WebElement password;
	@FindBy(xpath="//*[@id='loginBtn']")
	public WebElement loginButton;
	private String url="http://mail.126.com/";
	private String title = "ÍøÒ×Ãâ·ÑÓÊ";
	public WebDriver driver;
	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@Override
	protected void load(){
		
		this.driver.get(url);
	}
	
	public void close(){
		this.driver.close();
	}
	
	public HomePage login(){
		load();
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("idInput")));
		userName.clear();
		userName.sendKeys("testman1978");
		password.sendKeys("wulaoshi1978");
		
		loginButton.click();
		
		return new HomePage(driver);
	}
	
	
	public String getPageSource(){
		return driver.getPageSource();
	}
	
	public LoginPage LoginExpectingFailure() throws InterruptedException{
		load();
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("idInput")));
		userName.clear();
		userName.sendKeys("testman1978");
		password.sendKeys("123456");
		loginButton.click();
		return new LoginPage(driver);
	}
	
	@Override
	protected void isLoaded() throws Error{
		Assert.assertTrue(driver.getTitle().contains(title));
	}

}

