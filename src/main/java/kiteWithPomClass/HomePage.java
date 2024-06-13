package kiteWithPomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	 WebDriver driver;
	@FindBy(xpath = "//span[text()='DAA677']") private WebElement MyuserId;
	@FindBy(linkText = "Logout")private WebElement LogOutButton;
	
	public HomePage (WebDriver driver2) 
	{
	     this.driver = driver2;
	}
	
	public String getactualvaliduserId() 
	{
		String actualUserID = MyuserId.getText();
		return actualUserID;
	}
	public void clickOnLogoutButton() throws InterruptedException 
	{
		MyuserId.click();
		Thread.sleep(1000);
		LogOutButton.click();
	}
}
