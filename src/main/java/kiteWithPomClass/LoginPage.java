package kiteWithPomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{

	@FindBy(id="userid") private WebElement UserID;
	@FindBy(id="password") private WebElement Password;
	@FindBy(xpath = "//button[@type='submit']") private WebElement LoginButton;
	@FindBy(xpath = "//span[contains(text(),'Password should')]") private WebElement passwordErrorMassage;
	@FindBy(xpath = "//span[contains(text(),'User ID')]") private WebElement userIDErrormsg;
	
	public LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	public void EnterUserName(String UID) 
	{
		UserID.sendKeys(UID);
	}
	public void sendPassword(String PWD)
	{
		Password.sendKeys(PWD);
	}
	public void ClickLoginButton() 
	{
		LoginButton.click();
    }
	public String getErrorMassage() 
	{
		String actualErrMsg = passwordErrorMassage.getText();
		return actualErrMsg;
	}
	public String getuserIdError()
	{
		String actualErrorMSG = userIDErrormsg.getText();
		return actualErrorMSG;
	}
	

 
}