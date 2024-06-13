package Test;

import java.time.Duration;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseStudy.Base;
import UtilityStudy.Utility;
import kiteWithPomClass.HomePage;
import kiteWithPomClass.LoginPage;
import kiteWithPomClass.PinPage;

public class NewTest1  extends Base{
     HomePage Home;
     LoginPage login;
     PinPage Pin;
     int TCID=999;
     
	@BeforeClass
	public void LanchBrow() 
	{    
		super.lanchBrowser();
		Home=new HomePage(driver);
		login = new LoginPage(driver);
		Pin = new PinPage(driver);
		
	}
	@BeforeMethod
	public void loginToKite() throws Exception 
	{
		login.EnterUserName(Utility.getDataFromExcel(0, 0));
		login.sendPassword(Utility.getDataFromExcel(0, 1));
		login.ClickLoginButton();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		 
		Pin.sendpin(Utility.getDataFromExcel(0, 2));
		Pin.ClickContinueButton();
		
		
	}
	
	
	@Test
  public void validateUserId() throws Exception 
  {     
		String actual = Home.getactualvaliduserId();
		String expected = Utility.getDataFromExcel(0, 3);
		Assert.assertEquals(actual, expected);
		Reporter.log("ValideUserID  ",true);
		
//		Utility.takeScreenShot(driver, TCID);
		
  }
	@AfterMethod
	public void Logout() throws InterruptedException 
	{
		Home.clickOnLogoutButton();
	}
	
	@AfterClass
	public void closeBrowser()
	{
		CloseBrowser();
	}
}
